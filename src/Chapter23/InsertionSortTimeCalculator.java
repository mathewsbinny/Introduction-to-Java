package Chapter23;
import java.util.Random;

public class InsertionSortTimeCalculator {

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

        // Perform insertion sort
        insertionSort(list);

        // Get the end time
        long endTime = System.currentTimeMillis();

        // Calculate the execution time
        long executionTime = endTime - startTime;

        // Print the execution time
        System.out.println("Execution time for insertion sort: " + executionTime + " milliseconds");
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }
}

