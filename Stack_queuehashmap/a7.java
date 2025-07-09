import java.util.*;

public class PairWithSum {
    static boolean hasPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num))
                return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int sum = 10;
        System.out.println(hasPair(arr, sum) ? "Pair Found" : "Pair Not Found");
    }
}
