Summary
Agent encapsulates all necessary attributes and methods for an agent's operation within the simulation. This includes managing resources, executing actions, and maintaining relationships with other agents. It serves as the primary entity through which the simulation's dynamics are expressed and explored.

In-depth Description
Attributes: The class includes several key attributes for an agent:

id, location, smokes: Basic properties identifying the agent, their current location, and specific behaviors (e.g., smoking).
resources: A map tracking the resources available to the agent.
parameters: An array of ParameterState objects representing the agent's current state across various dimensions (e.g., health, energy).
movementActions, acquireActions, consumeActions, otherActions: Lists of actions available to the agent, categorized by their nature.
perceptionRelationships: A map linking perceptions to their effects on the agent's state, facilitating reactive behavior based on the environment or interactions.
Interactions and Mediators: Agents interact with the environment and other agents through BroadcastMediator and InteractionsMediator, enabling communication and effect calculation for actions and perceptions.

Behavior and Decision Making: The class outlines mechanisms for decision-making and behavior execution, including evaluating and selecting actions based on their utility or necessity. Agents assess available actions, considering their current needs, resources, and the state of the environment.

Resource Management: Methods like consumeResource and acquireResource manage the agent's resources, reflecting the outcomes of actions like consuming or acquiring goods.

Movement and Commitments: Agents can change their location and enter into commitments (e.g., attending an event), affecting their available actions and decision-making processes.
