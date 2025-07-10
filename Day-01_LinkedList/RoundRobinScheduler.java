import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int id, int burstTime, int priority) {
        this.processId = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    private Process head = null;

    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.processId == id && head.next == head) {
            head = null;
            return;
        }
        Process curr = head, prev = null;
        do {
            if (curr.processId == id) {
                if (curr == head) {
                    Process last = head;
                    while (last.next != head)
                        last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0, totalWaitingTime = 0, totalTurnaroundTime = 0, completed = 0;
        int totalProcesses = countProcesses();
        Process curr = head;

        while (completed < totalProcesses) {
            if (curr.remainingTime > 0) {
                if (curr.remainingTime > timeQuantum) {
                    time += timeQuantum;
                    curr.remainingTime -= timeQuantum;
                } else {
                    time += curr.remainingTime;
                    totalTurnaroundTime += time;
                    totalWaitingTime += time - curr.burstTime;
                    curr.remainingTime = 0;
                    completed++;
                }
            }
            curr = curr.next;
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / totalProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / totalProcesses);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        while (true) {
            System.out.println("\n--- Round Robin Scheduler Menu ---");
            System.out.println("1. Add Process");
            System.out.println("2. Remove Process");
            System.out.println("3. Display Processes");
            System.out.println("4. Run Round Robin Scheduling");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            if (ch == 5) break;

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter Process ID, Burst Time, Priority: ");
                    int id = sc.nextInt();
                    int bt = sc.nextInt();
                    int pr = sc.nextInt();
                    scheduler.addProcess(id, bt, pr);
                }
                case 2 -> {
                    System.out.print("Enter Process ID to remove: ");
                    scheduler.removeById(sc.nextInt());
                }
                case 3 -> scheduler.displayProcesses();
                case 4 -> {
                    System.out.print("Enter Time Quantum: ");
                    scheduler.simulateRoundRobin(sc.nextInt());
                }
                default -> System.out.println("Invalid");
            }
        }

        sc.close();
    }
}
