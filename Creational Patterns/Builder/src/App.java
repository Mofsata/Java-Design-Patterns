// "Product"
class Product {
    String CPU;
    String GPU;
    int RAM;
    String diskDriver;

    void Show(){
        if (this.CPU != null)
            System.out.println("\tCPU : "+ this.CPU);
        if (this.GPU != null)
            System.out.println("\tGPU : "+ this.GPU);
        if (this.RAM != 0)
            System.out.println("\tRAM : "+ this.RAM + "GB");
        if (this.diskDriver != null)
            System.out.println("\tDiskDriver : "+ this.diskDriver);
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
        System.out.println("Building My PC...");
    }

    @Override
    public void InsertCPU() {
        product.CPU = "Intel i9 CPU";
    }

    @Override
    public void InsertGPU() {
        product.GPU = "RTX 3060 GPU";
    }

    @Override
    public void AddRAM() {
        product.RAM = 32;
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
        System.out.println("Building Your PC...");
    }

    @Override
    public void InsertCPU() {
        product.CPU = "Ryzen 9 CPU";
    }

    @Override
    public void InsertGPU() {
        product.GPU = "RX 7800 XT GPU";
    }

    @Override
    public void AddRAM() {
        product.RAM = 16;
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
