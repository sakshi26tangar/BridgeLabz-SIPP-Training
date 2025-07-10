import java.util.Scanner;

class State {
    String content;
    State prev, next;

    public State(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditorUndoRedo {
    private State head = null, current = null;
    private int maxHistory = 10;

    public void addState(String content) {
        State newState = new State(content);
        if (head == null) {
            head = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;

            State temp = current;
            int count = 1;
            while (temp.prev != null && count < maxHistory) {
                temp = temp.prev;
                count++;
            }
            temp.prev = null;
            head = temp;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    public void displayCurrent() {
        if (current != null)
            System.out.println("Current State: " + current.content);
        else
            System.out.println("Editor is empty.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditorUndoRedo editor = new TextEditorUndoRedo();

        while (true) {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Type/Add State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 5) break;

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter new content: ");
                    String content = sc.nextLine();
                    editor.addState(content);
                }
                case 2 -> editor.undo();
                case 3 -> editor.redo();
                case 4 -> editor.displayCurrent();
                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
