# Domain-Specific Ontology README

## Summary

This domain-specific ontology focuses on modeling aspects related to human behavior, locations, and interactions within a specific context, such as a school environment. It defines classes, properties, and relationships to represent complex social phenomena, specifically around the behaviors and environments of humans and children, including actions like smoking and moving to school. The ontology utilizes RDF (Resource Description Framework) and RDFS (RDF Schema) to structure this information, promoting modularity and adaptability in simulation models.

## Detailed Description

### Ontology Structure

The ontology is structured around several key concepts, including locations, objects, actions, and agent characteristics. It employs an RDF Bag to list locations relevant to the simulation, such as schools, homes, stores, sports clubs, and streets.

#### Classes and Subclasses

- **Object and Place Classes**: Defined as subclasses of `NonAutonomous`, these classes categorize non-agent entities within the simulation.
- **Human and Child Classes**: Represent agents with specific characteristics and actions. `Human` is a superclass for `Child`, indicating inheritance of properties and the potential for additional, age-specific characteristics.

#### Location List

A predefined list of locations (`locationsList`) important for the simulation scenarios, including `School`, `Home`, `Store`, `Sports Club`, and `Street`.

#### Actions

- **School Actions**: Actions related to school, such as ringing the first and lunch bells, are defined with commitment factors and periods.
- **Human Actions**: Include consuming and acquiring cigarettes, with preconditions, parameter factors, and weights specified for each action.
- **Child Actions**: Focus on behaviors specific to children, such as moving to school, with associated commitments and conditions.

#### Parameters and Perceptions

- **Human Parameters**: Parameters like `propensityToSmoke` define characteristics influencing agent actions.
- **Child Parameters**: Additional parameters for children, including `childAge`, `sportsFrequency`, `timeSpentWithParents`, and `grades`, with each having defined minimum and maximum values and relationships affecting the propensity to smoke.
- **Perceptions**: Define how agents perceive their environment or actions, such as `smoking`, with relationships to other objects and functions to calculate effects on parameters.

### Relationships and Functions

The ontology includes detailed definitions of actions (`Action`), commitments (`Commitment`), and periods (`Period`) for events such as bell ringing at a school. It also outlines how various parameters (`Parameter`) and perceptions (`Perception`) are related to agent actions and decision-making processes. For instance, the `consumecigRel` relationship describes how consuming a cigarette affects an agent's propensity to smoke.
