import java.util.*;

class FriendNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    FriendNode next;

    public FriendNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class Q7_SocialMediaFriendConnections {
    FriendNode head = null;

    public void addUser(FriendNode newUser) {
        newUser.next = head;
        head = newUser;
    }

    public FriendNode findUserById(int id) {
        FriendNode temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addConnection(int id1, int id2) {
        FriendNode u1 = findUserById(id1);
        FriendNode u2 = findUserById(id2);
        if (u1 != null && u2 != null && id1 != id2) {
            if (!u1.friendIds.contains(id2)) u1.friendIds.add(id2);
            if (!u2.friendIds.contains(id1)) u2.friendIds.add(id1);
        }
    }

    public void removeConnection(int id1, int id2) {
        FriendNode u1 = findUserById(id1);
        FriendNode u2 = findUserById(id2);
        if (u1 != null && u2 != null) {
            u1.friendIds.remove(Integer.valueOf(id2));
            u2.friendIds.remove(Integer.valueOf(id1));
        }
    }

    public void findMutualFriends(int id1, int id2) {
        FriendNode u1 = findUserById(id1);
        FriendNode u2 = findUserById(id2);
        if (u1 != null && u2 != null) {
            Set<Integer> set = new HashSet<>(u1.friendIds);
            for (int id : u2.friendIds) {
                if (set.contains(id)) System.out.println("Mutual Friend ID: " + id);
            }
        }
    }

    public void displayFriends(int id) {
        FriendNode user = findUserById(id);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIds);
        }
    }

    public void searchUser(String input) {
        FriendNode temp = head;
        while (temp != null) {
            if (String.valueOf(temp.userId).equals(input) || temp.name.equalsIgnoreCase(input)) {
                System.out.println("Found: " + temp.name + ", ID: " + temp.userId + ", Age: " + temp.age);
            }
            temp = temp.next;
        }
    }

    public void countFriends() {
        FriendNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Q7_SocialMediaFriendConnections sm = new Q7_SocialMediaFriendConnections();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Add User\n2.Add Friend\n3.Remove Friend\n4.Mutual Friends\n5.Display Friends\n6.Search User\n7.Count Friends\n0.Exit");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("User ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt();
                    sm.addUser(new FriendNode(id, name, age));
                    break;

                case 2:
                    System.out.print("User ID 1: "); int id1 = sc.nextInt();
                    System.out.print("User ID 2: "); int id2 = sc.nextInt();
                    sm.addConnection(id1, id2);
                    break;

                case 3:
                    System.out.print("User ID 1: "); int rid1 = sc.nextInt();
                    System.out.print("User ID 2: "); int rid2 = sc.nextInt();
                    sm.removeConnection(rid1, rid2);
                    break;

                case 4:
                    System.out.print("User ID 1: "); int m1 = sc.nextInt();
                    System.out.print("User ID 2: "); int m2 = sc.nextInt();
                    sm.findMutualFriends(m1, m2);
                    break;

                case 5:
                    System.out.print("User ID: "); int fid = sc.nextInt();
                    sm.displayFriends(fid);
                    break;

                case 6:
                    System.out.print("Enter User ID or Name: ");
                    sm.searchUser(sc.nextLine());
                    break;

                case 7:
                    sm.countFriends();
                    break;
            }

        } while (choice != 0);
    }
}
