import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The BinarySearchAllIndices class implements a recursive binary search algorithm
 * to find all indices of a target element in a sorted array that may contain duplicates.
 * 
 * Specifications:
 * 
 * - The `binarySearchAllIndices` method takes a sorted array, a target element, and 
 *   a range defined by the indices `low` and `high` to search for all occurrences of the target element.
 * 
 * - It throws an `IllegalArgumentException` if the provided array is null or empty.
 * 
 * - If the target element is found, the method adds all its occurrences to the list `indices`.
 * 
 * - The method ensures that the list of indices is sorted in ascending order before returning.
 * 
 * - The `main` method demonstrates how to use the `binarySearchAllIndices` method by 
 *   initializing a sorted array and a target element, then searching for all occurrences 
 *   of the target element and printing the result.
 * 
 * Time Complexity:
 * - Best Case: O(log n), if the element is found at the middle on the first attempt.
 * - Average/Worst Case: O(n), as all occurrences of the target might need to be found recursively.
 * 
 * Space Complexity:
 * - O(log n) for the recursive stack due to the recursive calls, and O(k) for the list of indices 
 *   where k is the number of occurrences of the target element.
 */
public class BinarySearchAllIndices {

    /**
     * Performs a recursive binary search on a sorted array to find all indices of a target element.
     * 
     * @param array The sorted array in which the target element is to be searched.
     * @param target The element whose indices need to be found in the array.
     * @param low The lower index of the current search range.
     * @param high The higher index of the current search range.
     * @return A list containing all indices where the target element is found.
     * @throws IllegalArgumentException If the array is null or empty.
     */
    public static List<Integer> binarySearchAllIndices(int[] array, int target, int low, int high) {
        List<Integer> indices = new ArrayList<>();

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        if (low > high) {
            return indices; // Return empty list if not found
        }

        int mid = low + (high - low) / 2;

        if (array[mid] == target) {
            indices.add(mid);
            // Search the left side for any other occurrences of the target
            indices.addAll(binarySearchAllIndices(array, target, low, mid - 1)); 
            // Search the right side for any other occurrences of the target
            indices.addAll(binarySearchAllIndices(array, target, mid + 1, high)); 
            // Ensure indices are in ascending order
            Collections.sort(indices); 
        } else if (target < array[mid]) {
            indices.addAll(binarySearchAllIndices(array, target, low, mid - 1));
        } else {
            indices.addAll(binarySearchAllIndices(array, target, mid + 1, high));
        }

        return indices;
    }

    /**
     * The main method demonstrates the usage of the binarySearchAllIndices method.
     * It initializes a sorted array, searches for all occurrences of a target element,
     * and prints the result.
     * 
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 3, 3, 4, 5};
        int target = 3;

        try {
            List<Integer> results = binarySearchAllIndices(sortedArray, target, 0, sortedArray.length - 1);
            System.out.println("Indices of target: " + results);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
