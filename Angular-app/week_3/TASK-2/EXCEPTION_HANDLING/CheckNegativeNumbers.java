import java.io.*;
import java.util.*;

public class CheckNegativeNumbers {
    public static void checkNumbers(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num > 0) {
                scanner.close();
                throw new Exception("File contains a positive number: " + num);
            }
        }
        scanner.close();
        System.out.println("All numbers are non-positive");
    }
    
    public static void main(String[] args) {
        try {
            checkNumbers("numbers.txt");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
