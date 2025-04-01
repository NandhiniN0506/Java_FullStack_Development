package Programs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrailingZerosInFactorial {

    // Method to calculate the number of trailing zeros in the factorial of a given number
    public static int trailingZeros(int value) {
        int sum = 0;  // Variable to store the number of trailing zeros
        int power = 1;  // Initialize the power of 5
        // Loop to check for multiples of 5, 25, 125, etc., in the factorial
        while ((int) Math.pow(5, power) <= value) {
            sum += (value / (int) Math.pow(5, power));  // Add the number of multiples of 5^power
            power++;  // Increment the power of 5 for the next iteration
        }
        return sum;  // Return the total number of trailing zeros
    }

    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number to find the trailing zeros of the factorial: ");
        
        try {
            int value = s.nextInt();  // Read the input value
            
            // Check for non-positive values as factorial is only defined for positive integers
            if (value < 0) {
                System.out.println("Factorial is not defined for negative numbers.");
            } else {
                // Call the method to calculate trailing zeros and display the result
                System.out.println("The number of Trailing Zeros in the factorial of " + value + " is " + trailingZeros(value));
            }
        } catch (InputMismatchException e) {
            // Handle invalid input (non-integer values)
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            s.close();  // Close the scanner to avoid resource leak
        }
    }
}
