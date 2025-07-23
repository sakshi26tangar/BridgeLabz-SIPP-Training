public abstract class WarehouseItem {
    private String id;
    private String name;

    public WarehouseItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return "[" + getCategory() + "] ID: " + id + ", Name: " + name;
    }
}