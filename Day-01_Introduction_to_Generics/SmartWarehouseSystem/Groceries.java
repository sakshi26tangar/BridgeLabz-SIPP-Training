public class Groceries extends WarehouseItem {
    public Groceries(String id, String name) {
        super(id, name);
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }
}