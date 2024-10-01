package Chapter23;
import java.util.Random;

public class HeapSortTimeCalculator {

    public static void main(String[] args) {
        int size = 200000;
        int[] list = new int[size];

        // Generate random numbers between 1 and 200,000
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list[i] = random.nextInt(200000) + 1;
        }

        // Get the start time
        long startTime = System.currentTimeMillis();

        // Perform heap sort
        heapSort(list);

        // Get the end time
        long endTime = System.currentTimeMillis();

        // Calculate the execution time
        long executionTime = endTime - startTime;

        // Print the execution time
        System.out.println("Execution time for heap sort: " + executionTime + " milliseconds");
    }

    public static void heapSort(int[] list) {
        int n = list.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;

            // Call max heapify on the reduced heap
            heapify(list, i, 0);
        }
    }

    public static void heapify(int[] list, int n, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2;  // right child

        // If left child is larger than root
        if (left < n && list[left] > list[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && list[right] > list[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = list[i];
            list[i] = list[largest];
            list[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(list, n, largest);
        }
    }
}
