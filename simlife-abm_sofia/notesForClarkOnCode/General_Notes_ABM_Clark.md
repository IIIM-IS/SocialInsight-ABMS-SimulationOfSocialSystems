(1) An upper ontology describing general terms encapsulating the com-
ponents of an ABM; (2) a domain-specific ontology describing the phenomenon to
simulate using the general terms from the upper-ontology; (3) an ABM framework
that utilises the domain information and executes a simulation given pre-defined set-
tings.

ABM - Agent-Based Modelling
RDF - Resource Description Framework

Some Notes:
- Sofia left alot of TODOS across these files and it is not clear how many are left undone.
- You can visualize results of the simulation but you have to follow the graphDB.md to get these images.
- The ontologies have classes and functions specified in them but you would have to code these back in the framework if you decide to change anything regarding function. If you just want to use them as they are, then the ontologies are the place to tune these parameter values, which will change the outcome of the simulation.

# Simulation System Overview
This simulation system is designed to model complex agent behaviors and interactions within a simulated environment. The system is built around a core set of Java classes that define agents, actions, states, and their relationships. Below is a summary of each component and how they relate to each other.

## Summary
### Main.java: Initializes and runs the simulation, setting up agents and the simulation environment based on parameters defined in an ontology.
### SimInitializer.java: Responsible for initializing the simulation, including creating agents and defining their initial states and available actions.
### SimController.java: Manages the simulation's execution, iterating through simulation days and managing agent actions and perceptions.
### OntologyParser.java: Parses ontology data to dynamically configure the simulation parameters, actions, and relationships.
### Action.java: Abstract class representing actions that agents can perform, with subclasses defining specific actions.
### Interactions.java: Implements an interface for calculating the effects of interactions between agents and between agents and their environment.
### Agent.java: Represents agents in the simulation, including their properties, behaviors, and decision-making processes.
### Preconditions.java: Manages preconditions for actions, ensuring actions are executed in appropriate contexts.
### State.java: Represents states that can affect agents and the simulation environment.
### ActionRelationship.java: Defines relationships between actions and parameters, specifying how actions affect various aspects of the simulation.

## Dependencies and Functionalities
### Initialization: The simulation starts in Main.java, where OntologyParser is used to load simulation parameters from an ontology. SimInitializer then creates agents based on this data.
### Execution: SimController takes over to manage the simulation's execution, cycling through time steps and managing agent behaviors.
### Agent Behavior: Agents, defined in Agent.java, decide on actions based on their current states and the outcomes of interactions, as modeled by Interactions.java and ActionRelationship.java.
### Actions and Effects: Actions, derived from Action.java, have preconditions and effects on agents' states or the environment, which are checked and applied using Preconditions.java and ActionRelationship.java.
### Dynamic Configuration: The simulation is dynamically configurable through ontology data, parsed by OntologyParser.java, allowing for flexible simulation setups.

# Difference between substance-use.ttl and domainSpecificOntology.ttl
## Scope and Focus
- **Substance Use Ontology**: Specifically designed to model the domain of substance use, including detailed aspects of substance consumption behaviors, environmental influences, and agent interactions related to smoking and potentially other substances.
- **Domain-Specific Ontology**: Focuses on a broader range of human behaviors and interactions within specific contexts (e.g., educational settings), not limited to substance use. It aims to capture a wider variety of social phenomena.

## Content and Structure
- **Substance Use Ontology**: Contains a set of classes, properties, and individuals related to substance use scenarios, such as `SmokingBehavior`, `Cigarette`, `UrgeLevel`, and relationships that define how agents interact with these substances.
- **Domain-Specific Ontology**: Encompasses a diverse set of entities that represent various aspects of human behavior and environmental contexts, such as `Person`, `Location`, `BehavioralEvent`, with a structure that supports a wide range of scenarios beyond substance use.

