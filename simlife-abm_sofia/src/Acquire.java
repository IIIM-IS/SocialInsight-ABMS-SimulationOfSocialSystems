import java.util.Map;

public class Acquire extends Action{
    private String resource;
    private Double quantity;

    public Acquire(String actionName, String resource, Double quantity){
        this.setName(actionName);
        this.resource = resource;
        this.quantity = quantity;
    }
    public boolean isResource(String r){
        return this.resource.equalsIgnoreCase(r);
    }
    public void executeAction(Agent a, String location){
        // TODO: Movement may have a different modifier if the agent is in a commitment, it need to be taken into account here
        System.out.println("I am executing action " + this.name);
        if(this.preconditions != null && this.preconditions.hasLocation() && !this.preconditions.matchesLocation(location)){
            // we need to execute the move to
            this.preconditions.getLocationAction().executeAction(a);

        }else {
            // if the action can be executed immediately
            a.acquireResource(this.resource, this.quantity);
        }
    }
}
