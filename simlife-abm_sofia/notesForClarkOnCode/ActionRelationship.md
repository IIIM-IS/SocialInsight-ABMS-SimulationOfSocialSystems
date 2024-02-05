Summary
ActionRelationship encapsulates the connection between an action and its effects on one or more parameters, using functions to describe how the action modifies these parameters. This structure allows for the dynamic adjustment of simulation states based on agent actions.

In-depth Description
Attributes:

subject: The Action object that this relationship pertains to. It represents the cause in the cause-effect relationship captured by this class.
objects: An array of Parameter objects that are affected by the action. These parameters represent the state aspects that the action influences.
functions: An array of strings, each corresponding to a function that describes how the action affects the associated parameter. These functions are presumably evaluated to compute the new values of parameters after the action is taken.
Constructor: The class constructor initializes an ActionRelationship with a subject action, the parameters (objects) it affects, and the functions describing those effects. This setup enables a flexible definition of action impacts within the simulation.

Methods:

getSubject, getObjectNr, getFunction, and getObjects are accessor methods providing access to the relationship's components. These methods are essential for the simulation logic to query and apply the effects of actions on parameters.
toString Method: It overrides the toString method to provide a textual representation of the action relationship, which can be useful for debugging or logging the simulation's behavior.
