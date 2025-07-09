import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class Q1_StudentRecordLinkedList {
    private Student head = null;

    public void addAtBeginning(Student newStudent) {
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(Student newStudent) {
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addAtPosition(Student newStudent, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(newStudent);
            return;
        }

        Student temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRoll(int rollNo) {
        if (head == null) return;

        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }

        Student prev = head;
        Student curr = head.next;
        while (curr != null) {
            if (curr.rollNo == rollNo) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public Student searchByRoll(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void updateGrade(int rollNo, char newGrade) {
        Student s = searchByRoll(rollNo);
        if (s != null) {
            s.grade = newGrade;
        }
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No records found.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Q1_StudentRecordLinkedList list = new Q1_StudentRecordLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Delete by Roll No\n5. Search by Roll No\n6. Update Grade\n7. Display All\n0. Exit");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char grade = sc.next().charAt(0);
                    Student s = new Student(roll, name, age, grade);
                    if (choice == 1) list.addAtBeginning(s);
                    else if (choice == 2) list.addAtEnd(s);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(s, pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    int delRoll = sc.nextInt();
                    list.deleteByRoll(delRoll);
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    int searchRoll = sc.nextInt();
                    Student found = list.searchByRoll(searchRoll);
                    if (found != null)
                        System.out.println("Found: " + found.name + ", Age: " + found.age + ", Grade: " + found.grade);
                    else
                        System.out.println("Student not found.");
                    break;

                case 6:
                    System.out.print("Enter Roll No: ");
                    int updateRoll = sc.nextInt();
                    System.out.print("Enter New Grade: ");
                    char newGrade = sc.next().charAt(0);
                    list.updateGrade(updateRoll, newGrade);
                    break;

                case 7:
                    list.displayAll();
                    break;
            }

        } while (choice != 0);
    }
}
