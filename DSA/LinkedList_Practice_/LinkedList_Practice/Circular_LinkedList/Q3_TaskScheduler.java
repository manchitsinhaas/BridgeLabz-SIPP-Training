import java.util.Scanner;

class Task {
    int taskId;
    String name;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String name, int priority, String dueDate) {
        this.taskId = taskId;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class Q3_TaskScheduler {
    Task head = null;
    Task current = null;

    public void addAtBeginning(Task task) {
        if (head == null) {
            head = task;
            task.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            task.next = head;
            head = task;
            temp.next = head;
        }
    }

    public void addAtEnd(Task task) {
        if (head == null) {
            head = task;
            task.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = task;
            task.next = head;
        }
    }

    public void addAtPosition(Task task, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(task);
            return;
        }

        Task temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        task.next = temp.next;
        temp.next = task;
    }

    public void removeById(int id) {
        if (head == null) return;

        if (head.taskId == id) {
            if (head.next == head) {
                head = null;
                current = null;
            } else {
                Task temp = head;
                while (temp.next != head) temp = temp.next;
                head = head.next;
                temp.next = head;
                if (current.taskId == id) current = head;
            }
            return;
        }

        Task prev = head;
        Task curr = head.next;
        while (curr != head) {
            if (curr.taskId == id) {
                prev.next = curr.next;
                if (current.taskId == id) current = prev;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void viewCurrentAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks.");
            return;
        }
        System.out.println("Current Task: " + current.taskId + " | " + current.name + " | Priority: " + current.priority + " | Due: " + current.dueDate);
        current = current.next;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        do {
            System.out.println("ID: " + temp.taskId + " | " + temp.name + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("ID: " + temp.taskId + " | " + temp.name + " | Due: " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        Q3_TaskScheduler scheduler = new Q3_TaskScheduler();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Beginning\n2. Add End\n3. Add Position\n4. Delete by ID\n5. View & Next\n6. Display All\n7. Search by Priority\n0. Exit");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: case 2: case 3:
                    System.out.print("Task ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Priority: "); int prio = sc.nextInt(); sc.nextLine();
                    System.out.print("Due Date: "); String date = sc.nextLine();
                    Task t = new Task(id, name, prio, date);
                    if (choice == 1) scheduler.addAtBeginning(t);
                    else if (choice == 2) scheduler.addAtEnd(t);
                    else {
                        System.out.print("Position: "); int pos = sc.nextInt();
                        scheduler.addAtPosition(t, pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    scheduler.removeById(sc.nextInt());
                    break;

                case 5:
                    scheduler.viewCurrentAndMoveNext();
                    break;

                case 6:
                    scheduler.displayAll();
                    break;

                case 7:
                    System.out.print("Priority: ");
                    scheduler.searchByPriority(sc.nextInt());
                    break;
            }

        } while (choice != 0);
    }
}
