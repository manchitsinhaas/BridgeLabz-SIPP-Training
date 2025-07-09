public class HeapSortSalaries {
    public static void main(String[] args) {
        int[] salaries = {50000, 60000, 45000, 75000, 55000};
        heapSort(salaries);
        System.out.println("Sorted Salaries:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }

    static void heapSort(int[] arr) {
        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i]; arr[i] = arr[largest]; arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
