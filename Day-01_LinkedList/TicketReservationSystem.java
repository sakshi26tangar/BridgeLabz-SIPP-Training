import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private Ticket head = null;

    public void addTicket(int id, String name, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, name, movie, seat, time);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    public void removeTicket(int id) {
        if (head == null) return;
        if (head.ticketId == id && head.next == head) {
            head = null;
            return;
        }

        Ticket curr = head, prev = null;
        do {
            if (curr.ticketId == id) {
                if (curr == head) {
                    Ticket last = head;
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

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Name: " + temp.customerName + ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) return;
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Name: " + temp.customerName + ", Movie: " + temp.movieName +
                        ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No matching tickets found.");
    }

    public void countTickets() {
        if (head == null) {
            System.out.println("Total Booked Tickets: 0");
            return;
        }
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Booked Tickets: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\n--- Ticket Reservation Menu ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Name/Movie");
            System.out.println("5. Count Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            if (ch == 6) break;

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter Ticket ID, Name, Movie, Seat, Time: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String movie = sc.next();
                    String seat = sc.next();
                    String time = sc.next();
                    system.addTicket(id, name, movie, seat, time);
                }
                case 2 -> {
                    System.out.print("Enter Ticket ID to remove: ");
                    system.removeTicket(sc.nextInt());
                }
                case 3 -> system.displayTickets();
                case 4 -> {
                    System.out.print("Enter Customer Name or Movie Name: ");
                    system.searchTicket(sc.next());
                }
                case 5 -> system.countTickets();
                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
