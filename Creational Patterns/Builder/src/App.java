import java.util.LinkedList;

// "Product"
class Product {
    // You can use any data structure that you prefer. We have used LinkedList here.
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
    void BuildPC();
    void InsertCPU();
    void InsertGPU();
    void AddRAM();
    Product GetPC();
}

// "Director"
class Director {
    IBuilder myBuilder;

    // A series of steps—for the production
    public void Construct(IBuilder builder) {
        myBuilder = builder;
        myBuilder.BuildPC();
        myBuilder.InsertCPU();
        myBuilder.InsertGPU();
        myBuilder.AddRAM();
    }
}

// MyPC is ConcreteBuilder
class MyPC implements IBuilder {
    private Product product = new Product();

    @Override
    public void BuildPC() {
        product.Add("My PC has :");
    }

    @Override
    public void InsertCPU() {
        product.Add("\tIntel i9 CPU");
    }

    @Override
    public void InsertGPU() {
        product.Add("\tRTX 3060 GPU");
    }

    @Override
    public void AddRAM() {
        product.Add("\t32GB RAM");
    }

    @Override
    public Product GetPC() {
        return product;
    }
}

// OthersPC is a ConcreteBuilder
class OthersPC implements IBuilder {
    private Product product = new Product();

    @Override
    public void BuildPC() {
        product.Add("Your PC has :");
    }

    @Override
    public void InsertCPU() {
        product.Add("\tRyzen 9 CPU");
    }

    @Override
    public void InsertGPU() {
        product.Add("\tRX 7800 XT GPU");
    }

    @Override
    public void AddRAM() {
        product.Add("\t16GB RAM");
    }

    @Override
    public Product GetPC() {
        return product;
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("***Builder Pattern Demo***");
        Director director = new Director();
        IBuilder myPCBuilder = new MyPC();
        IBuilder yourPCBuilder = new OthersPC();
        // Making My PC
        director.Construct(myPCBuilder);
        Product p1 = myPCBuilder.GetPC();
        p1.Show();
        // Making Your PC
        director.Construct(yourPCBuilder);
        Product p2 = yourPCBuilder.GetPC();
        p2.Show();
    }
}
