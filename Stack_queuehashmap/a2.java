import java.util.Stack;

public class SortStackRecursion {
    static void sortStack(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sortStack(s);
            insertSorted(s, x);
        }
    }

    static void insertSorted(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
        } else {
            int temp = s.pop();
            insertSorted(s, x);
            s.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(1);
        s.push(4);
        s.push(2);

        sortStack(s);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
