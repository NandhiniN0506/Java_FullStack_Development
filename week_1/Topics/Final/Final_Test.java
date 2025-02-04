package Topics.Final;

import java.util.*;

public class Final_Test {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.printf("Enter the number to get sum on n natural numbers : ");
		long value = s.nextLong();
		System.out.printf("The sum of %d natural numbers is %d",value,Final_Keyword.sumMod(value));
	}
}
