public class Main {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E001", "Laptop"));
        electronicsStorage.addItem(new Electronics("E002", "Smartphone"));
        electronicsStorage.addItem(new Electronics("E003", "Tablet"));
        

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("G001", "Rice"));
        groceriesStorage.addItem(new Groceries("G002", "Wheat"));
        groceriesStorage.addItem(new Groceries("G003", "Sugar"));

        
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F001", "Chair"));
        furnitureStorage.addItem(new Furniture("F002", "Table"));
        furnitureStorage.addItem(new Furniture("F003", "Desk"));
    

        System.out.println("=== Electronics ===");
        WarehouseUtils.displayAllItems(electronicsStorage.getItems());

        System.out.println("\n=== Groceries ===");
        WarehouseUtils.displayAllItems(groceriesStorage.getItems());

        System.out.println("\n=== Furniture ===");
        WarehouseUtils.displayAllItems(furnitureStorage.getItems());
    }
}