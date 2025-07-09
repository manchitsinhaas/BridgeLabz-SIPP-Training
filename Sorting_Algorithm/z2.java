public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {
        int[] empIDs = {102, 56, 78, 34, 89};
        insertionSort(empIDs);
        System.out.println("Sorted Employee IDs:");
        for (int id : empIDs) {
            System.out.print(id + " ");
        }
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
