class CustomHashMap {
    static class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 10;
    private Node[] buckets;

    public CustomHashMap() {
        buckets = new Node[SIZE];
    }

    private int getIndex(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(String key, int value) {
        int idx = getIndex(key);
        Node node = buckets[idx];
        if (node == null) {
            buckets[idx] = new Node(key, value);
        } else {
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                if (node.next == null) break;
                node = node.next;
            }
            node.next = new Node(key, value);
        }
    }

    public Integer get(String key) {
        int idx = getIndex(key);
        Node node = buckets[idx];
        while (node != null) {
            if (node.key.equals(key)) return node.value;
            node = node.next;
        }
        return null;
    }

    public void remove(String key) {
        int idx = getIndex(key);
        Node node = buckets[idx], prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev != null) prev.next = node.next;
                else buckets[idx] = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put("apple", 10);
        map.put("banana", 20);
        System.out.println("apple: " + map.get("apple"));
        map.remove("apple");
        System.out.println("apple after removal: " + map.get("apple"));
    }
}
