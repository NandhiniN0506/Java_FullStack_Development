package Topics.Primitive_vs_Reference;

import java.util.Arrays;
import java.util.Scanner;

public class Primitive_vs_Reference {
	public static int primitiveModify(int value) {
		int result = 0;
		while (value > 0) {
			result += (value % 10);
			value /= 10;
		}
		return value;
	}
	public static String referenceModify(int[] reverseArr) {
		int l = 0;
		int r = reverseArr.length - 1;
		int temp = 0;
		while (l <= r) {
			temp = reverseArr[l];
			reverseArr[l] = reverseArr[r];
			reverseArr[r] = temp;
			l++;
			r--;
		}
		return Arrays.toString(reverseArr);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number  : ");
		int number = s.nextInt();
		System.out.println("The value in main method is " + number + " and the value inside the method is " + primitiveModify(number));
		System.out.println("This is CALL BY VALUE.");
		System.out.println("Enter the size of the arr : " );
		int size = s.nextInt();
		System.out.println("Enter the elements of the arry ");
		int[] reverseArr = new int[size];
		for(int i = 0;i < size;i++) {
			reverseArr[i] = s.nextInt();
		}
		System.out.println("The arr in main method is " + Arrays.toString(reverseArr) + " and the modifed reversed Array after the method passing is " + referenceModify(reverseArr));
	}

}
