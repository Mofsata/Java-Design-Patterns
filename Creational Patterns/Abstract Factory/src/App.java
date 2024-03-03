
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
