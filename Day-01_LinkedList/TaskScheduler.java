import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    private Task head = null;
    private Task current = null;

    // Add at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            newTask.next = head;
            head = newTask;
            temp.next = head;
        }
    }

    // Add at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add at specific position (0-based index)
    public void addAtPosition(int index, int id, String name, int priority, String dueDate) {
        if (index == 0) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 0; i < index - 1 && temp.next != head; i++)
            temp = temp.next;
        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove by Task ID
    public void removeById(int id) {
        if (head == null) return;

        if (head.taskId == id) {
            if (head.next == head) {
                head = null;
                current = null;
                return;
            }
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = head.next;
            if (current == head) current = head.next;
            head = head.next;
            return;
        }

        Task prev = head;
        Task curr = head.next;
        while (curr != head) {
            if (curr.taskId == id) {
                prev.next = curr.next;
                if (current == curr) current = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Task not found.");
    }

    // View current task and move to next
    public void viewCurrentTaskAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        System.out.println("Current Task: ID=" + current.taskId + ", Name=" + current.taskName +
                ", Priority=" + current.priority + ", Due=" + current.dueDate);
        current = current.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        System.out.println("Tasks in Circular List:");
        do {
            System.out.println("ID=" + temp.taskId + ", Name=" + temp.taskName +
                    ", Priority=" + temp.priority + ", Due=" + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found: ID=" + temp.taskId + ", Name=" + temp.taskName +
                        ", Due=" + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tasks with given priority found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Task ID");
            System.out.println("5. View Current Task & Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 8) break;

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Enter ID, Name, Priority, DueDate: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int priority = sc.nextInt();
                    String dueDate = sc.next();
                    if (choice == 1) scheduler.addAtBeginning(id, name, priority, dueDate);
                    else if (choice == 2) scheduler.addAtEnd(id, name, priority, dueDate);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        scheduler.addAtPosition(pos, id, name, priority, dueDate);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Task ID to remove: ");
                    int id = sc.nextInt();
                    scheduler.removeById(id);
                }
                case 5 -> scheduler.viewCurrentTaskAndMoveNext();
                case 6 -> scheduler.displayAllTasks();
                case 7 -> {
                    System.out.print("Enter Priority to search: ");
                    int p = sc.nextInt();
                    scheduler.searchByPriority(p);
                }
                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
