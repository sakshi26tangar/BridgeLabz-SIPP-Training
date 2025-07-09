import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friends;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

public class FriendConnectionSystem {
    private User head = null;

    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    public User findUser(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 != null && u2 != null && id1 != id2) {
            if (!u1.friends.contains(id2)) u1.friends.add(id2);
            if (!u2.friends.contains(id1)) u2.friends.add(id1);
        }
    }

    public void removeFriendConnection(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 != null && u2 != null) {
            u1.friends.remove(Integer.valueOf(id2));
            u2.friends.remove(Integer.valueOf(id1));
        }
    }

    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user == null) return;
        System.out.println("Friends of " + user.name + ":");
        for (int fid : user.friends) {
            User f = findUser(fid);
            if (f != null) System.out.println(f.name + " (ID: " + f.userId + ")");
        }
    }

    public void mutualFriends(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 == null || u2 == null) return;
        Set<Integer> set1 = new HashSet<>(u1.friends);
        System.out.println("Mutual friends:");
        for (int f : u2.friends) {
            if (set1.contains(f)) {
                User mutual = findUser(f);
                if (mutual != null)
                    System.out.println(mutual.name + " (ID: " + mutual.userId + ")");
            }
        }
    }

    public void searchUser(String key) {
        User temp = head;
        while (temp != null) {
            if (String.valueOf(temp.userId).equals(key) || temp.name.equalsIgnoreCase(key)) {
                System.out.println("User: " + temp.name + ", ID: " + temp.userId + ", Age: " + temp.age);
            }
            temp = temp.next;
        }
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " (ID: " + temp.userId + ") has " + temp.friends.size() + " friend(s).");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FriendConnectionSystem system = new FriendConnectionSystem();

        while (true) {
            System.out.println("\n--- Friend Connection Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends");
            System.out.println("5. Mutual Friends");
            System.out.println("6. Search User");
            System.out.println("7. Count Friends of All Users");
            System.out.println("8. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            if (ch == 8) break;

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter ID, Name, Age: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int age = sc.nextInt();
                    system.addUser(id, name, age);
                }
                case 2 -> {
                    System.out.print("Enter two User IDs: ");
                    int id1 = sc.nextInt();
                    int id2 = sc.nextInt();
                    system.addFriendConnection(id1, id2);
                }
                case 3 -> {
                    System.out.print("Enter two User IDs: ");
                    int id1 = sc.nextInt();
                    int id2 = sc.nextInt();
                    system.removeFriendConnection(id1, id2);
                }
                case 4 -> {
                    System.out.print("Enter User ID: ");
                    system.displayFriends(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter two User IDs: ");
                    int id1 = sc.nextInt();
                    int id2 = sc.nextInt();
                    system.mutualFriends(id1, id2);
                }
                case 6 -> {
                    System.out.print("Enter Name or ID: ");
                    system.searchUser(sc.next());
                }
                case 7 -> system.countFriends();
                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
