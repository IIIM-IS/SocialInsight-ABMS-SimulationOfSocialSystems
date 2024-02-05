# Substance Use Ontology README

## Summary

The Substance Use Ontology is an RDF-based model designed to represent the behaviors, environments, and interactions associated with substance use, specifically smoking. It extends the foundational structure of an upper ontology to include specific elements related to the consumption of cigarettes by autonomous agents (humans and children) within various environments. This ontology focuses on parameters like urge to smoke, actions such as acquiring and consuming cigarettes, and the conditions and effects of these actions.

## Detailed Description

### Ontology Structure

The ontology is built upon a hierarchy starting from the concept of `Thing`, branching into `Agent`, and further into `Autonomous` and `NonAutonomous` classes to differentiate between entities that can act independently versus those that cannot.

#### Classes

- **Agent Classes**: Define entities that can perceive, decide, and act. This includes `Human` and `Child` classes, with `Child` being a subclass of `Human` for more specific modeling.
- **Parameter Class**: Captures characteristics or states that can influence agents' decisions and actions, such as `urgeToSmoke`.
- **Perception Class**: Models how agents perceive their environment or internal states affecting their behavior.
- **Action Classes**: Encompasses all possible actions agents can take, divided into subcategories like `MoveTo`, `Acquire`, and `Consume` to reflect movement and resource management behaviors.

#### Parameters and Perceptions

- **Human and Child Parameters**: Include `urgeToSmoke` and `childAge`, among others, to model the factors influencing substance use behaviors.
- **Perceptions**: Such as `smoking`, link to parameters through relationships, indicating how certain behaviors or environmental factors modify agents' internal states.

#### Actions and Preconditions

- **Actions**: Detailed actions like `CONSUMECIG` (consuming a cigarette) and `ACQUIRECIG` (acquiring cigarettes) are defined, each with preconditions (e.g., having a cigarette or being in a specific location like a store).
- **Preconditions**: Specify the necessary conditions for an action to take place, including location, time, and possession of resources.

### Modeling Substance Use Behaviors

This ontology provides a comprehensive framework for simulating substance use scenarios. It allows for the detailed representation of the conditions leading to substance use, the act of using substances, and the immediate and long-term consequences of these actions on the agents' perceptions and states.

- **Consumption Actions**: Model the immediate effect of substance use, such as a temporary decrease in the urge to smoke, along with the conditions under which these actions occur.
- **Acquisition Actions**: Detail how agents obtain substances, including the necessary preconditions such as being at a specific location (e.g., a store).
