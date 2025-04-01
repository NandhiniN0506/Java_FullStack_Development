import java.util.Scanner;

public class AlternateCapitalization {
    public static String capitalizeAlternate(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = (i % 2 == 0) ? Character.toUpperCase(str.charAt(i)) : Character.toLowerCase(str.charAt(i));
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();
        scanner.close();
        
        System.out.println("Output: " + capitalizeAlternate(input));
    }
}