package Topics.StringHandling;

import java.util.Arrays;
import java.util.Scanner;

public class StringProcessing {
	public static String reverseString(String input) {
		String ans = "";
		int length = input.length()-1;
		while (length >= 0) {
			ans += input.charAt(length);
			length--;
		}
		return ans;
	}
	
	public static String splitAndCapitalize(String input) {
		String[] words = input.trim().split("\\s+");
        int wordCount = words.length;
		String[] result = new String[wordCount];
		boolean newLetter = true;
		int index = 0;
		int i = 0;
		while (i < input.length()){
			String ans = "";
			while (i < input.length()  && input.charAt(i) != ' ') {
				if (newLetter) {
					ans += Character.toUpperCase(input.charAt(i));
					newLetter = false;
				}
				else {
					ans += input.charAt(i);
				}
				i++;
			}
			result[index] = ans;
			index++;
			i++;
			newLetter = true;	
		}
		return Arrays.toString(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Operations to be done.");
		System.out.println("1.Reverse The String");
		System.out.println("2.Split and Capitalize the words in String");
		int value = s.nextInt();
		s.nextLine();
		switch(value) {
			case 1 :
				{
					System.out.println("Enter the String to reverse it : ");
					String input = s.nextLine();
					System.out.println(reverseString(input));
					break;
				}
			case 2 :
				{
					System.out.println("Enter the sentence to split and Capitalize :");
					String input = s.nextLine();
					System.out.println(splitAndCapitalize(input));
					break;
				}
		}
	}
}
