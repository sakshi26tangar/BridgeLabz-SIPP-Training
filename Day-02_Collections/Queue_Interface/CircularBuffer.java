public class CircularBuffer {
    static class CircularQueue {
        int[] buffer;
        int front = 0, size = 0, capacity;

        CircularQueue(int capacity) {
            this.capacity = capacity;
            buffer = new int[capacity];
        }

        void add(int value) {
            buffer[(front + size) % capacity] = value;
            if (size < capacity) {
                size++;
            } else {
                front = (front + 1) % capacity;
            }
        }

        void printBuffer() {
            System.out.print("Buffer: ");
            for (int i = 0; i < size; i++) {
                System.out.print(buffer[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue buffer = new CircularQueue(3);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.printBuffer(); // 1 2 3
        buffer.add(4);
        buffer.printBuffer(); // 2 3 4
        buffer.add(5);
        buffer.printBuffer(); // 3 4 5
    }
}
