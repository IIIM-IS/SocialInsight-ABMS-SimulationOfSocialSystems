# BroadcastToFriend.java Summary

## Overview
`BroadcastToFriend.java` defines a class that implements the `BroadcastMediator` interface, focusing on the functionality to send perceptions to an agent's friends within the simulation. This class allows for targeted communication, where perceptions or messages are only broadcast to agents that have a defined friendship relationship with the sender.

## Implementation Details
- Implements `BroadcastMediator` interface.

## Methods
- `sendPerception(Perception p, Agent a)`: Takes a `Perception` object and an `Agent` as parameters. It broadcasts the given perception to all friends of the specified agent. This is achieved by iterating over the agent's friends (retrieved through `a.getFgroup().getFriends(a)`) and invoking the `perceive` method on each friend agent with the perception `p`.

## Functionality
The `BroadcastToFriend` class is crucial for simulating social dynamics and information spread within networks of agents. By enabling agents to broadcast perceptions only to their friends, the simulation can model more realistic scenarios of communication and influence, such as the spread of rumors, shared awareness of events, or coordinated actions among a group of friends.

This selective broadcasting mechanism supports the development of complex social interactions and behaviors, contributing to the depth and realism of the simulation environment by reflecting how information and perceptions are often shared within social networks.

