package homework_10_23_23;

import java.util.Arrays;

/*
2. Sorting algorithm implementation.
Choose any from the list:
Insertion sort, Selection sort, bubble sort, Merge sort, Quicksort.
 */

public class BubbleSort {
    public static void main(String[] args) {
        // Unsorted array
        int[] arr = {5, 4, 3, 2, 1};

        // Sort the array using bubble sort
        bubbleSort(arr);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        // Iterate over the array, starting from the second element (index 1)
        for (int i = 1; i < arr.length; i++) {
            // Initialize the flag to indicate if any swaps were made
            boolean swapped = false;

            // Iterate over the array, starting from the beginning
            for (int j = 0; j < arr.length - i; j++) {
                // If the current element is greater than the next element, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Set the flag to true
                    swapped = true;
                }
            }
            // If no swaps were made, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }
}