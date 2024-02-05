Summary
Interactions provides the functionality to compute the outcomes of various interactions that occur in the simulation, applying specified functions to agent parameters and perceptions. It plays a crucial role in the simulation's ability to model complex behaviors and interactions dynamically.

In-depth Description
Function Evaluation: The class uses a stack-based approach to evaluate functions that represent the effects of interactions. These functions can be defined in prefix notation and involve operations on current and previous values of agent parameters (SCURRENT, SPREVIOUS) or other agents' parameters (OCURRENT).

Handling Variables and Operators: It distinguishes between variables (isVariable method) and operators (isOperator method), allowing for the dynamic calculation of effects based on the current state of agents and their interactions. This feature is essential for simulating real-world phenomena where the outcome of an action can depend on multiple factors.

Calculating Parameter Effects: The calculateParameterEffect method applies a specified function to the parameters of agents involved in an interaction, enabling the simulation to model a wide range of effects, from simple additive impacts to complex formula-based changes.

Perception Interaction: The class also manages perception interactions through the perceptionInteraction method, updating parameter states based on perceptions. This mechanism allows agents to adjust their behaviors based on their perceptions of the environment or other agents, facilitating a reactive and adaptive simulation environment.
