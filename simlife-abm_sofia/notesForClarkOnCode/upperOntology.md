# Upper Ontology README

## Summary

The upper ontology provides a structure for representing and modeling entities, behaviors, and interactions in agent-based models (ABMs). It defines a comprehensive hierarchy of classes and properties to represent agents, their actions, perceptions, parameters, and the environment in which they operate. This ontology is designed to be generic and adaptable, serving as a core framework upon which domain-specific ontologies can be built and extended.

## Detailed Description

### Ontology Structure

The upper ontology is organized into several key components, each designed to capture different aspects of the simulation environment and agent interactions:

#### Core Classes

- **Thing**: The root class from which all entities in the ontology derive.
- **Agent**: Represents entities capable of perceiving, deciding, and acting within the simulation. It is a subclass of `Thing`.
- **Autonomous**: Entities that have the agency to act independently, subclass of `Agent`.
- **NonAutonomous**: Entities that cannot act without external forces, also a subclass of `Agent`.

#### Agent Characteristics

- **Parameters**: Quantitative or qualitative characteristics of agents defined by the `Parameter` class. Parameters can have a name, minimum, and maximum values.
- **Perceptions**: The information an agent can perceive from its environment, modeled by the `Perception` class.
- **Actions**: The set of possible actions an agent can perform, detailed in subclasses such as `MoveTo`, `Acquire`, and `Consume`.

#### Actions and Preconditions

- **Action**: Defines a general class for agent actions, with specific subclasses for movement and resource management (`MoveTo`, `Acquire`, `Consume`).
- **Preconditions**: Conditions that must be met for an action to occur, including location, time, and possession of resources.

### Relationships and Properties

- **Parameters and Perceptions**: Linked to agents through `agentParameters` and `agentPerceptions` properties, allowing the definition of what an agent can have and perceive.
- **Actions**: Connected to agents via the `agentActions` property, detailing what actions an agent can take and the effects of those actions, including changes in state, commitments, and perceptions.
- **Commitments**: Represent obligations or intended actions of agents, associated with actions through the `commitmentFactor` property and defined by a commitment period.
- **Relationships**: Used to define complex relationships between different entities, such as the influence of parameters on actions or the effects of actions on perceptions.
