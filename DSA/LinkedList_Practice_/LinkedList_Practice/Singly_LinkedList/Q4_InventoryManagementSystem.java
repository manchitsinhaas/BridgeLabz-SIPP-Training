import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class Q4_InventoryManagementSystem {
    Item head = null;

    public void addAtBeginning(Item item) {
        item.next = head;
        head = item;
    }

    public void addAtEnd(Item item) {
        if (head == null) {
            head = item;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = item;
    }

    public void addAtPosition(Item item, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(item);
            return;
        }
        Item temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) temp = temp.next;
        item.next = temp.next;
        temp.next = item;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item prev = head;
        Item curr = head.next;
        while (curr != null) {
            if (curr.id == id) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByIdOrName(String query) {
        boolean found = false;
        Item temp = head;
        while (temp != null) {
            if (String.valueOf(temp.id).equals(query) || temp.name.equalsIgnoreCase(query)) {
                System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Qty: " + temp.quantity + ", Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    public void displayAll() {
        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    public void sortByName(boolean ascending) {
        head = mergeSortByName(head, ascending);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSortByPrice(head, ascending);
    }

    private Item mergeSortByName(Item h, boolean asc) {
        if (h == null || h.next == null) return h;
        Item mid = getMid(h);
        Item nextToMid = mid.next;
        mid.next = null;
        Item left = mergeSortByName(h, asc);
        Item right = mergeSortByName(nextToMid, asc);
        return sortedMergeByName(left, right, asc);
    }

    private Item sortedMergeByName(Item a, Item b, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;
        Item result;
        int cmp = a.name.compareToIgnoreCase(b.name);
        if ((asc && cmp <= 0) || (!asc && cmp > 0)) {
            result = a;
            result.next = sortedMergeByName(a.next, b, asc);
        } else {
            result = b;
            result.next = sortedMergeByName(a, b.next, asc);
        }
        return result;
    }

    private Item mergeSortByPrice(Item h, boolean asc) {
        if (h == null || h.next == null) return h;
        Item mid = getMid(h);
        Item nextToMid = mid.next;
        mid.next = null;
        Item left = mergeSortByPrice(h, asc);
        Item right = mergeSortByPrice(nextToMid, asc);
        return sortedMergeByPrice(left, right, asc);
    }

    private Item sortedMergeByPrice(Item a, Item b, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;
        Item result;
        if ((asc && a.price <= b.price) || (!asc && a.price > b.price)) {
            result = a;
            result.next = sortedMergeByPrice(a.next, b, asc);
        } else {
            result = b;
            result.next = sortedMergeByPrice(a, b.next, asc);
        }
        return result;
    }

    private Item getMid(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Q4_InventoryManagementSystem inv = new Q4_InventoryManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Add Begin\n2.Add End\n3.Add Pos\n4.Delete\n5.Update Qty\n6.Search\n7.Display\n8.Total Value\n9.Sort Name\n10.Sort Price\n0.Exit");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: case 2: case 3:
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Qty: "); int qty = sc.nextInt();
                    System.out.print("Price: "); double price = sc.nextDouble();
                    Item item = new Item(name, id, qty, price);
                    if (choice == 1) inv.addAtBeginning(item);
                    else if (choice == 2) inv.addAtEnd(item);
                    else {
                        System.out.print("Pos: "); int pos = sc.nextInt();
                        inv.addAtPosition(item, pos);
                    }
                    break;

                case 4:
                    System.out.print("ID to remove: ");
                    inv.removeById(sc.nextInt());
                    break;

                case 5:
                    System.out.print("ID: ");
                    int uid = sc.nextInt();
                    System.out.print("New Qty: ");
                    int newQty = sc.nextInt();
                    inv.updateQuantity(uid, newQty);
                    break;

                case 6:
                    System.out.print("Enter ID or Name to search: ");
                    String query = sc.nextLine();
                    inv.searchByIdOrName(query);
                    break;

                case 7:
                    inv.displayAll();
                    break;

                case 8:
                    inv.calculateTotalValue();
                    break;

                case 9:
                    System.out.print("Ascending? true/false: ");
                    inv.sortByName(sc.nextBoolean());
                    break;

                case 10:
                    System.out.print("Ascending? true/false: ");
                    inv.sortByPrice(sc.nextBoolean());
                    break;
            }
        } while (choice != 0);
    }
}
