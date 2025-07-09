import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
    }
}

public class Q8_TextEditorUndoRedo {
    TextState head = null, tail = null, current = null;
    int size = 0, limit = 10;

    public void addState(String content) {
        TextState newState = new TextState(content);

        if (current != null && current.next != null) {
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = tail;
        }

        size++;
        if (size > limit) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo.");
        }
    }

    public void displayCurrent() {
        if (current != null)
            System.out.println("Current Text: " + current.content);
        else
            System.out.println("Empty editor.");
    }

    public static void main(String[] args) {
        Q8_TextEditorUndoRedo editor = new Q8_TextEditorUndoRedo();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Type Text\n2.Undo\n3.Redo\n4.Show Current\n0.Exit");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    editor.addState(sc.nextLine());
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrent();
                    break;
            }
        } while (choice != 0);
    }
}
