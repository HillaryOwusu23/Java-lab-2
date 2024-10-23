package PartThree;
import java.util.Scanner;

public class SortingAlgorithms {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Array after Bubble Sort: ");
        displayArray(arr);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("Array after Selection Sort: ");
        displayArray(arr);
    }

    public static void displayArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void compareTimeComplexity() {
        System.out.println("Bubble Sort Time Complexity: O(n^2)");
        System.out.println("Selection Sort Time Complexity: O(n^2)");
        System.out.println("Use Case: Both algorithms are simple but inefficient for large datasets. More efficient algorithms like QuickSort or MergeSort (O(n log n)) are better for larger datasets.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        bubbleSort(arr);

        System.out.println("Re-enter the elements for Selection Sort:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        selectionSort(arr);

        compareTimeComplexity();

        scanner.close();
    }
}
