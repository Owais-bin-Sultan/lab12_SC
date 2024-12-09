import java.math.BigInteger;
import java.util.Scanner;

/**
 * The RecursiveSumOfDigits class computes the sum of digits of a given BigInteger.
 * It handles both positive and negative input numbers and employs recursion to
 * calculate the sum by repeatedly extracting the last digit and adding it to the sum of the remaining digits.
 * 
 * Specifications:
 * 
 * - The `sumOfDigits` method is a recursive function that calculates the sum of digits of a BigInteger. 
 *   It handles both positive and negative inputs, using the absolute value of the number.
 * 
 * - The recursion works by dividing the number by 10 repeatedly, extracting the last digit at each step, 
 *   and adding it to the sum.
 * 
 * - The base case for the recursion is when the number becomes 0, at which point the recursion ends and returns 0.
 * 
 * Time Complexity:
 * - O(d), where d is the number of digits in the input number, as each recursive call reduces the number 
 *   by a factor of 10, which corresponds to the number of digits.
 * 
 * Space Complexity:
 * - O(d), where d is the depth of the recursion, which corresponds to the number of digits in the input.
 */
public class RecursiveSumOfDigits {

    /**
     * Computes the sum of digits of a given BigInteger.
     * Handles both positive and negative inputs.
     * 
     * @param number The BigInteger whose digits are to be summed.
     * @return The sum of the digits of the number.
     */
    public static int sumOfDigits(BigInteger number) {
        // Handle negative numbers by converting to positive
        number = number.abs();

        // Base case: If number is 0, return 0
        if (number.equals(BigInteger.ZERO)) {
            return 0;
        }

        // Recursive case: Add the last digit to the sum of digits of the remaining number
        return (number.mod(BigInteger.TEN)).intValue() + sumOfDigits(number.divide(BigInteger.TEN));
    }

    /**
     * Main method to accept user input, compute the sum of digits, and display the result.
     * 
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a non-negative integer
        System.out.print("Enter a non-negative integer: ");
        String input = scanner.nextLine();

        // Convert the input to BigInteger
        BigInteger bigNumber = new BigInteger(input);

        // Compute and display the result
        int result = sumOfDigits(bigNumber);
        System.out.println("The sum of the digits is: " + result);

        // Close the scanner
        scanner.close();
    }
}
