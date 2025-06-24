class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayItem(int quantity) {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per item: ₹" + price);
        System.out.println("Total cost for " + quantity + " items: ₹" + (price * quantity));
    }

    public static void main(String[] args) {
        Item item = new Item(501, "Mouse", 450);
        item.displayItem(3);
    }
}
