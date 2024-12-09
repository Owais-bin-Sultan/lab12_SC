/**
 * The BinarySearch class implements a recursive binary search algorithm
 * to find the index of a target element in a sorted array.
 * 
 * Specifications:
 * 
 * - The `binarySearchRecursive` method takes a sorted array, a target element, 
 *   and a range defined by the indices `low` and `high` to search for the target element.
 * 
 * - It throws an `IllegalArgumentException` if the provided array is null or empty.
 * 
 * - If the target element is found, the method returns its index in the array.
 * 
 * - If the target element is not found, the method returns -1 to indicate that the target 
 *   is not present in the array.
 * 
 * - The `main` method demonstrates how to use the `binarySearchRecursive` method by 
 *   initializing a sorted array and a target element, then searching for the target element 
 *   and printing the result.
 * 
 * Time Complexity:
 * - Best Case: O(1), if the element is found at the middle on the first attempt.
 * - Average/Worst Case: O(log n), as the search space is halved on each recursive call.
 * 
 * Space Complexity:
 * - O(log n) due to recursive calls on the stack.
 */
public class BinarySearch {

    /**
     * Performs a recursive binary search on a sorted array to find the index of a target element.
     * 
     * @param array The sorted array in which the target element is to be searched.
     * @param target The element that needs to be found in the array.
     * @param low The lower index of the current search range.
     * @param high The higher index of the current search range.
     * @return The index of the target element if found, otherwise returns -1.
     * @throws IllegalArgumentException If the array is null or empty.
     */
    public static int binarySearchRecursive(int[] array, int target, int low, int high) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (array[mid] == target) {
            return mid; // Target found
        } else if (target < array[mid]) {
            return binarySearchRecursive(array, target, low, mid - 1); // Search in the left half
        } else {
            return binarySearchRecursive(array, target, mid + 1, high); // Search in the right half
        }
    }

    /**
     * The main method demonstrates the usage of the binarySearchRecursive method.
     * It initializes a sorted array, searches for a target element, and prints the result.
     * 
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;

        try {
            int result = binarySearchRecursive(sortedArray, target, 0, sortedArray.length - 1);
            System.out.println("Index of target: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
