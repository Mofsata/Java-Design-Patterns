import java.util.LinkedList;

// "Product"
class Product {
    // We can use any data structure that you prefer. We have used LinkedList here.
    private LinkedList<String> parts;

    public Product() {
        parts = new LinkedList<String>();
    }

    public void Add(String part) {
        // Adding parts
        parts.addLast(part);
    }

    public void Show() {
        System.out.println("\nProduct completed as below :");
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("\t"+parts.get(i));
        }
    }
}

interface IBuilder {
    void BuildBody();

    void InsertWheels();

    void AddHeadlights();

    Product GetVehicle();
}

// "Director"
class Director {
    IBuilder myBuilder;

    // A series of steps—for the production
    public void Construct(IBuilder builder) {
        myBuilder = builder;
        myBuilder.BuildBody();
        myBuilder.InsertWheels();
        myBuilder.AddHeadlights();
    }
}

// Car is ConcreteBuilder
class Car implements IBuilder {
    private Product product = new Product();

    @Override
    public void BuildBody() {
        product.Add("This is a body of a Car");
    }

    @Override
    public void InsertWheels() {
        product.Add("4 wheels are added");
    }

    @Override
    public void AddHeadlights() {
        product.Add("2 Headlights are added");
    }

    @Override
    public Product GetVehicle() {
        return product;
    }
}

// Motorcycle is a ConcreteBuilder
class MotorCycle implements IBuilder {
    private Product product = new Product();

    @Override
    public void BuildBody() {
        product.Add("This is a body of a Motorcycle");
    }

    @Override
    public void InsertWheels() {
        product.Add("2 wheels are added");
    }

    @Override
    public void AddHeadlights() {
        product.Add("1 Headlights are added");
    }

    @Override
    public Product GetVehicle() {
        return product;
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("***Builder Pattern Demo***");
        Director director = new Director();
        IBuilder carBuilder = new Car();
        IBuilder motorBuilder = new MotorCycle();
        // Making Car
        director.Construct(carBuilder);
        Product p1 = carBuilder.GetVehicle();
        p1.Show();
        // Making MotorCycle
        director.Construct(motorBuilder);
        Product p2 = motorBuilder.GetVehicle();
        p2.Show();
    }
}
