public class Furniture extends WarehouseItem {
    public Furniture(String id, String name) {
        super(id, name);
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }
}