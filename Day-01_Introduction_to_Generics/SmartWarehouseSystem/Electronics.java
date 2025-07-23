public class Electronics extends WarehouseItem {
    public Electronics(String id, String name) {
        super(id, name);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}