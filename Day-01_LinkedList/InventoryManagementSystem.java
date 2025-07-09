import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagementSystem {
    private Item head = null;

    public void addAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newItem;
    }

    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos == 0) {
            addAtBeginning(name, id, qty, price);
            return;
        }
        Item newItem = new Item(name, id, qty, price);
        Item temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null) return;
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.itemId == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByIdOrName(String key) {
        Item temp = head;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(key) || temp.itemName.equalsIgnoreCase(key)) {
                System.out.println("Item: " + temp.itemName + ", ID: " + temp.itemId + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            }
            temp = temp.next;
        }
    }

    public void totalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    public void sortBy(String key, boolean ascending) {
        head = mergeSort(head, key, ascending);
    }

    private Item mergeSort(Item node, String key, boolean asc) {
        if (node == null || node.next == null) return node;
        Item middle = getMiddle(node);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSort(node, key, asc);
        Item right = mergeSort(nextOfMiddle, key, asc);
        return sortedMerge(left, right, key, asc);
    }

    private Item sortedMerge(Item a, Item b, String key, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;
        boolean condition;
        if (key.equals("name"))
            condition = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        else
            condition = asc ? a.price <= b.price : a.price > b.price;

        Item result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, key, asc);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, key, asc);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void display() {
        if (head == null) {
            System.out.println("No items.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Item: " + temp.itemName + ", ID: " + temp.itemId + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManagementSystem ims = new InventoryManagementSystem();

        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID/Name");
            System.out.println("7. Display");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by Price");
            System.out.println("11. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            if (ch == 11) break;

            switch (ch) {
                case 1, 2, 3 -> {
                    System.out.print("Enter Name, ID, Qty, Price: ");
                    String name = sc.next();
                    int id = sc.nextInt();
                    int qty = sc.nextInt();
                    double price = sc.nextDouble();
                    if (ch == 1) ims.addAtBeginning(name, id, qty, price);
                    else if (ch == 2) ims.addAtEnd(name, id, qty, price);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        ims.addAtPosition(pos, name, id, qty, price);
                    }
                }
                case 4 -> {
                    System.out.print("Enter ID: ");
                    ims.removeById(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter ID and New Quantity: ");
                    ims.updateQuantity(sc.nextInt(), sc.nextInt());
                }
                case 6 -> {
                    System.out.print("Enter ID or Name: ");
                    ims.searchByIdOrName(sc.next());
                }
                case 7 -> ims.display();
                case 8 -> ims.totalInventoryValue();
                case 9, 10 -> {
                    boolean asc = true;
                    System.out.print("Ascending (true/false)? ");
                    asc = sc.nextBoolean();
                    ims.sortBy(ch == 9 ? "name" : "price", asc);
                }
                default -> System.out.println("Invalid");
            }
        }

        sc.close();
    }
}
