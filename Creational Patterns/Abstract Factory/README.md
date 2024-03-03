# Abstract Factory

Also knwon as `Kit`.

## Objective

Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

## Applicability

Use the Abstract Factory pattern when :

- A system should be independent of how its products are created, composed, and represented.
- A system should be configured with one of multiple families of products.
- A family of related product objects is designed to be used together, and
you need to enforce this constraint.
- You want to provide a class library of products, and you want to reveal
just their interfaces, not their implementations.

## Implementation

```java
interface IFactory {
    IMetal getMetalProduct();
    IWood getWoodenProduct();
}

interface IWood {
    String productName();
}

interface IMetal {
    String productName();
}
```

In this Application, the interface `IFactory` Contains two methods, each one of them returns a type of product by the interfaces `IWood` and `IMetal`.

```java
class TableFactory implements IFactory {

    @Override
    public IMetal getMetalProduct() {
        return new MetalTable();
    }

    @Override
    public IWood getWoodenProduct() {
        return new WoodTable();
    }
}

class ChairFactory implements IFactory {

    @Override
    public IMetal getMetalProduct() {
        return new MetalChair();
    }

    @Override
    public IWood getWoodenProduct() {
        return new WoodChair();
    }
}
```

The `IFactory` interface is implemented in the `TableFactory` and `ChairFactory` concrete Classes.

```java
class WoodTable implements IWood {

    @Override
    public String productName() {
        return "This Table is made of wood";
    }

}

class MetalTable implements IMetal {

    @Override
    public String productName() {
        return "This Table is made of metal";
    }

}

class WoodChair implements IWood {

    @Override
    public String productName() {
        return "This Chair is made of wood";
    }

}

class MetalChair implements IMetal {

    @Override
    public String productName() {
        return "This Chair is made of metal";
    }

}
```

The products produced by these Factories are the concrete Classes `WoodTable`, `MetalTable`, `WoodChair` and `MetalChair`.
These Classes implement the type of product interfaces `IWood` and `IMetal`.

```java
public class App {
    public static void main(String[] args) throws Exception {
        TableFactory tableFactory = new TableFactory();
        IWood woodTable = tableFactory.getWoodenProduct();
        IMetal metalTable = tableFactory.getMetalProduct();

        System.out.println("Table Factory products :");
        System.out.println("\t" + woodTable.productName());
        System.out.println("\t" + metalTable.productName());
        System.out.println();

        ChairFactory chairFactory = new ChairFactory();
        IWood woodChair = chairFactory.getWoodenProduct();
        IMetal metalChair = chairFactory.getMetalProduct();

        System.out.println("Chair Factory products :");
        System.out.println("\t" + woodChair.productName());
        System.out.println("\t" + metalChair.productName());

    }
}
```

The  output of this code :

```terminal
Table Factory products :
    This Table is made of wood
    This Table is made of metal

Chair Factory products :
    This Chair is made of wood
    This Chair is made of metal
```

## Consequences

The Abstract Factory pattern has the following benefits and liabilities:

1. It isolates concrete classes.
2. It makes exchanging product families easy.
3. It promotes consistency among products.
4. Supporting new kinds of products is difficult.

## Related Patterns

Abstract Factory classes are often implemented with [Factory Method](../), but they can also be implemented using [Prototype](https://). A concrete factory is often a [Singleton](https://).
