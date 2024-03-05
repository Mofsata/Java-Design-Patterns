# Factory Method

Also knwon as `Virtual Constructor`.

## Objective

Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses

## Applicability

Use the Factory Method pattern when :

- A class can't anticipate the class of objects it must create.
- A class wants its subclasses to specify the objectsit creates.
- Classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.

## Implementation

```java

```

```java

```

```java

```

The  output of this code :

```terminal

```

## Consequences

The Factory pattern has the following benefits and liabilities:

1. Provides hooks for subclasses.
2. Connects parallel class hierarchies.
3. Eliminate the need to bind application-specific classes into your code.
4. Supporting new kinds of products is difficult.

## Related Patterns

[Abstract Factory](../Abstract%20Factory/README.md) is often implemented with factory methods. The Motivation example in the Abstract Factory pattern illustrates Factory Method as well.

Factory methods are usually called within [Template Methods](https://).
