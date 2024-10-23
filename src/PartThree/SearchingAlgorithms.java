package PartThree;

import java.util.Arrays;
import java.util.Scanner;

public class SearchingAlgorithms {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void compareTimeComplexity() {
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n) (requires sorted array)");
        System.out.println("Use Case: Linear search works well for small or unsorted arrays, while binary search is ideal for large, sorted arrays.");
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

        System.out.print("Enter the target element to search: ");
        int target = scanner.nextInt();

        int linearResult = linearSearch(arr, target);
        if (linearResult != -1) {
            System.out.println("Linear Search: Element found at index " + linearResult);
        } else {
            System.out.println("Linear Search: Element not found.");
        }

        Arrays.sort(arr);
        System.out.println("Sorted array for Binary Search: " + Arrays.toString(arr));

        int binaryResult = binarySearch(arr, target);
        if (binaryResult != -1) {
            System.out.println("Binary Search: Element found at index " + binaryResult);
        } else {
            System.out.println("Binary Search: Element not found.");
        }

        compareTimeComplexity();

        scanner.close();
    }
}
