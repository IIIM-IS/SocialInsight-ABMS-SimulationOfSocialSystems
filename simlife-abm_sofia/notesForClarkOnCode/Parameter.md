# Parameter.java Summary

## Overview
`Parameter.java` defines a class that encapsulates the concept of parameters within the simulation. Parameters are essential for representing quantifiable attributes of agents or the environment, such as health levels, resource amounts, or any measurable factor that influences decision-making and behavior in the simulation.

## Variables
- `parameterName`: A `String` identifying the parameter.
- `minimum` and `maximum`: `Double` values defining the allowable range of values for the parameter.
- `hasRelationships`: A `boolean` indicating whether this parameter is involved in any relationships with other parameters.
- `pr`: An instance of `ParameterRelationship` that represents the relationships this parameter has with other parameters.

## Constructor
- The constructor initializes a `Parameter` with a name, minimum value, and maximum value. It also sets `hasRelationships` to false by default, indicating no relationships are defined initially.

## Methods
- `setParameterName(String name_)`, `setMinimum(Double min)`, `setMaximum(Double max)`: Methods for setting the parameter's name, minimum value, and maximum value.
- `addRelationship(ParameterRelationship pr)`: Adds a relationship to the parameter, indicating it has a defined relationship with another parameter.
- `toString()`: Provides a string representation of the parameter, including its name and value range.

## Functionality
The `Parameter` class serves as a foundational component for modeling various aspects of the simulation that require quantification and range definition. By allowing parameters to be linked through relationships, the simulation can represent complex dependencies and influences between different entities or attributes. This mechanism is crucial for simulating realistic scenarios where behaviors and outcomes are determined by a network of interrelated factors.

