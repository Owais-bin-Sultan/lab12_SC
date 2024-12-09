/**
 * The BinarySearchStrings class implements a recursive binary search algorithm
 * to find the index of a target string in a sorted array of strings.
 * 
 * Specifications:
 * 
 * - The `binarySearchRecursive` method takes a sorted array of strings, a target string, 
 *   and a range defined by the indices `low` and `high` to search for the target string.
 * 
 * - It throws an `IllegalArgumentException` if the provided array is null or empty.
 * 
 * - The method compares the target string to the middle element of the current range using the `compareTo` method.
 * 
 * - If the target string is found, it returns the index of the target string in the array.
 * 
 * - If the target is not found, the method recurses on the left or right half of the array depending on the comparison.
 * 
 * Time Complexity:
 * - Best Case: O(1), if the element is found at the middle on the first attempt.
 * - Average/Worst Case: O(log n), where n is the number of elements in the array.
 * 
 * Space Complexity:
 * - O(log n) for the recursive stack due to the recursive calls.
 */
public class BinarySearchStrings {

    /**
     * Performs a recursive binary search on a sorted array of strings to find the index of a target string.
     * 
     * @param array The sorted array of strings in which the target string is to be searched.
     * @param target The string whose index needs to be found in the array.
     * @param low The lower index of the current search range.
     * @param high The higher index of the current search range.
     * @return The index of the target string if found, otherwise -1.
     * @throws IllegalArgumentException If the array is null or empty.
     */
    public static int binarySearchRecursive(String[] array, String target, int low, int high) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        if (low > high) {
            return -1; // Return -1 if the target is not found
        }

        int mid = low + (high - low) / 2;
        int comparison = target.compareTo(array[mid]); // Compare the target to the middle element

        if (comparison == 0) {
            return mid; // Target found at mid index
        } else if (comparison < 0) {
            // Search the left half
            return binarySearchRecursive(array, target, low, mid - 1); 
        } else {
            // Search the right half
            return binarySearchRecursive(array, target, mid + 1, high); 
        }
    }

    /**
     * The main method demonstrates the usage of the binarySearchRecursive method.
     * It initializes a sorted array of strings, searches for a target string, 
     * and prints the result.
     * 
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        String[] sortedArray = {"apple", "banana", "cherry", "date", "elderberry"};
        String target = "cherry";

        try {
            int result = binarySearchRecursive(sortedArray, target, 0, sortedArray.length - 1);
            System.out.println("Index of target: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
