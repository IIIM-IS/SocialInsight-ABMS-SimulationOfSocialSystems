import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;


// behavior class
// one method with behave
// routine, smoking behavior, it basically says behave
// array that contains behaviors, every time you call agent.act() you will go over the behavior array and call the behave()
// behaviors can be ordered by order of most urgent/important in terms of need
// behavior accesses the time of day

// TODO: Actions that are tied to a commitment should not affect the value for that action when in a commitment for that location
// TODO: Initialize agents according to distributions
// TODO: Time needs to be adjusted (currently its an hour per tick but it should be smaller, perhaps 15 mins?)
// TODO: Add the perception effect when an action is implemented within the action class


public class Agent {
    private String location;
    private Map<String, Double> resources;
    private int id;
    private Boolean smokes;
    private BroadcastMediator bc;
    private InteractionsMediator ii;
    private ParameterState[] parameters;
    private FriendGroup fgroup;
    // have a list of friends, not every agent knows others
    // how do they become friends, call a function that becomeFriends? updateFriends? Friendship interface
    private List<MoveTo> movementActions ;
    private List<Acquire> acquireActions ;
    private List<Consume> consumeActions ;
    private List<Action> otherActions;
    private Map<Perception,PerceptionStateRelationship> perceptionRelationships;
    private boolean inCommitment;
    private Commitment currentCommitment;
    private int lastPerceivedTime;


    public Agent(int id,
                 Boolean smokes,
                 BroadcastMediator bc,
                 ParameterState[] parameters,
                 InteractionsMediator ii,
                 Map<Perception,PerceptionStateRelationship> perceptionRelationships,
                 List<MoveTo> movementActions, List<Acquire> acquireActions, List<Consume> consumeActions, List<Action> otherActions) {
        this.id = id;
        this.location = "Home";
        this.smokes = smokes;
        this.bc = bc;
        this.prepare_new_day();
        this.parameters = parameters;
        this.ii = ii;
        this.perceptionRelationships = perceptionRelationships;
        this.movementActions = movementActions;
        this.acquireActions = acquireActions;
        this.consumeActions = consumeActions;
        this.otherActions = otherActions;
        this.resources = new HashMap<>();
        this.inCommitment = false;
    }
    @Override
    public String toString() {
        String str = " I am agent " + this.id + "\n";
        if (this.parameters.length > 0){
            for(int i = 0; i < this.parameters.length; i++){
                str+= " * " + this.parameters[i].toString() + "\n";
            }
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if( o instanceof Agent){
            Agent a = (Agent) o;
            return this.id == a.id;
        }
        return false;
    }

    public void setFriendGroup(FriendGroup fg ){
        this.fgroup = fg;
    }

    public FriendGroup getFgroup(){
        return this.fgroup;
    }

    private void prepare_new_day() {
        // commitments should be reloaded perhaps
    }
    public void perceive(Perception percept){
        if (this.perceptionRelationships.containsKey(percept)){
            // send it to the mediator to do something about it
            System.out.println("I am perceiving " + percept.toString());
            ii.perceptionInteraction(perceptionRelationships.get(percept));
        }
    }

    public void perceive_time(int time) {
        this.lastPerceivedTime = time;
        if (this.inCommitment){
            if (time == this.currentCommitment.getTimeEnd()){
                this.inCommitment = false;
                this.currentCommitment = null;
            }
        }
//        if (type == "time") {
//            if ( message == TimeOfDay.EARLY_MORNING){
//                this.prepare_new_day();
//            }
//            System.out.println("I am perceiving the time of day " + message);
//            this.decide(message);
//
//        }else {
//            System.out.println("I ," + this.id + ", am perceiving");
//        }
        this.decide();
    }
    private Double commitmentModifier(){
        // TODO: we may want to add commitments to the ontology with a modifier, so that there are different levels of commitments
        if (this.inCommitment){
            return 1.5;
        }
        return 0.0;
    }
    private Map.Entry<Integer, Double> compareActionValue(Action action, Integer actionIndex, Map.Entry<Integer, Double> highestPair){
        if(action.isPossible(this.lastPerceivedTime)){
            // System.out.println("Final value for " + this.movementActions.get(i).getName() + " = " + this.movementActions.get(i).calculateActionValue(this.location, this.resources, this.parameters, this.lastPerceivedTime));
            Double value = action.calculateActionValueGeneral(this.location, this.resources, this.parameters, this.lastPerceivedTime);
            // applying the commitment modifier
            value = value - this.commitmentModifier();

            if (highestPair.getValue() < value){
                return new AbstractMap.SimpleEntry<>(actionIndex, value);
            }
        }
        return highestPair;
    }
    private void decide() {
        // In decision-making, the agent goes over each possible action and their value, picking the highest valued action
        // should they decide to do nothing should multiple actions have the same value?
        // should they decide to pick a random action if multiple actions have the same value but have a higher value than others? If so, where is the cutoff
        // TODO: commitments which have been fulfilled should not be in the list anymore of commitments..
        // TODO: make a better way to pick the maximum for each of the action types (right now its just a simple way)
        System.out.println("I am deciding");

        Map.Entry<Integer, Double> moveToHighest = new AbstractMap.SimpleEntry<>(0, 0.0);
        Map.Entry<Integer, Double> acquireHighest = new AbstractMap.SimpleEntry<>(0, 0.0);
        Map.Entry<Integer, Double> consumeHighest = new AbstractMap.SimpleEntry<>(0, 0.0);

        for (int i = 0 ; i < this.movementActions.size(); i++){
            if (!this.movementActions.get(i).equals(this.location)){
                moveToHighest = this.compareActionValue(this.movementActions.get(i), i, moveToHighest);
            }
        }
        for (int i = 0 ; i < this.acquireActions.size(); i++){
            acquireHighest =  this.compareActionValue(this.acquireActions.get(i), i, acquireHighest);

        }
        for (int i = 0 ; i < this.consumeActions.size(); i++){
            // do i have the resource AND is it enough for the consume action OR am i able to acquire it at this time
            if ((this.resources.containsKey(this.consumeActions.get(i).getResource())
                    && this.consumeActions.get(i).isEnoughToConsume(this.resources.get(this.consumeActions.get(i).getResource())))
                    ||
                    this.consumeActions.get(i).isPossibleToAcquire(this.lastPerceivedTime))
            {
                consumeHighest = this.compareActionValue(this.consumeActions.get(i), i, consumeHighest);
            }
        }
        //this.pickAction(moveToIndex, moveToMaximum, acquireIndex, acquireMaximum, consumeIndex, consumeMaximum);
        this.decideAction(moveToHighest, acquireHighest, consumeHighest);
    }

    private void decideAction( Map.Entry<Integer, Double> moveToHighest, Map.Entry<Integer, Double> acquireHighest, Map.Entry<Integer, Double> consumeHighest){
        if (moveToHighest.getValue() > acquireHighest.getValue() && moveToHighest.getValue() > consumeHighest.getValue()){
            // if the highest value is a moveTo action
            System.out.println("I want to " + this.movementActions.get(moveToHighest.getKey()).getName() + " with value " + moveToHighest.getValue());
            this.movementActions.get(moveToHighest.getKey()).executeAction(this);

            // Send this to all friends -CLARK
            for (Agent friend : this.getFgroup().getFriends(this)){
                this.movementActions.get(moveToHighest.getKey()).executeGeneralAction(friend);
            }

        } else if (acquireHighest.getValue() > moveToHighest.getValue() && acquireHighest.getValue() > consumeHighest.getValue()){
            // if the highest value is an acquire action
            System.out.println("I want to " + this.acquireActions.get(acquireHighest.getKey()).getName() + " with value " + acquireHighest.getValue());
            this.acquireActions.get(acquireHighest.getKey()).executeAction(this, this.location);

            // Send this to all friends -CLARK
            for (Agent friend : this.getFgroup().getFriends(this)){
                this.acquireActions.get(acquireHighest.getKey()).executeGeneralAction(friend);
            }

        } else if(consumeHighest.getValue() > moveToHighest.getValue() && consumeHighest.getValue() > acquireHighest.getValue()){
            // if the highest value is a consume action
            System.out.println("I want to " + this.consumeActions.get(consumeHighest.getKey()).getName() + " with value " + consumeHighest.getValue());
            if(this.resources.containsKey(this.consumeActions.get(consumeHighest.getKey()).getResource()) && this.consumeActions.get(consumeHighest.getKey()).isEnoughToConsume(this.resources.get(this.consumeActions.get(consumeHighest.getKey()).getResource()))){
                // if the agent has the resource then we can just consume
                this.consumeActions.get(consumeHighest.getKey()).executeAction(this, this.location, false);

                // Send this to all friends -CLARK
                for (Agent friend : this.getFgroup().getFriends(this)) {
                    this.consumeActions.get(consumeHighest.getKey()).executeGeneralAction(friend);
                }
            }else{
                // if the agent doesn't have the resource then it needs to acquire
                this.consumeActions.get(consumeHighest.getKey()).executeAction(this, this.location, true);

                // Send this to all friends -CLARK
                for (Agent friend : this.getFgroup().getFriends(this)) {
                    this.consumeActions.get(consumeHighest.getKey()).executeGeneralAction(friend);
                }
            }
        }else {
            // currently if all highest actions of each category (move, consume, acquire) have the same value then the agent chooses to do nothing
            // here we would add that if they are above a certain threshold, the agent could pick one at random
            System.out.println("I want to do nothing");
        }
    }

    private void act(String type, Action action) {
        System.out.println("I am acting");
    }

    public void consumeResource(String resource, Double quantity){
        System.out.println("Consuming " + resource + "  current value " + this.resources.get(resource) + " consuming " + quantity.toString());
        this.resources.put(resource, this.resources.get(resource) - quantity);
    }
    public void acquireResource(String resource, Double quantity){
        // if the resource is already in the resources, we add the quantity to it
        if( this.resources.containsKey(resource)){
            System.out.println("Acquiring " + resource + "  current value " + this.resources.get(resource) + " acquiring " + quantity.toString());
            this.resources.put(resource, this.resources.get(resource) + quantity);
        // otherwise we have to put it
        }else{
            System.out.println("Acquiring " + resource + " acquiring " + quantity.toString());
            this.resources.put(resource, quantity);
        }
    }
    public void move(String location, Commitment commitment){
        this.location = location;
        if (commitment != null){
            this.inCommitment = true;
            this.currentCommitment = commitment;
        }
    }
}
