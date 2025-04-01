package Task;

import java.util.*;

public class ExceptionHandle {
	public float processInput() throws InputMismatchException{
		Scanner s = new Scanner(System.in);
		try {
			System.out.print("Enter the number to get the reciprocal : ");
			int value = s.nextInt();
			return (float)1.0/value;
		}
		catch (ArithmeticException e) {
			throw new ArithmeticException("You Entered Zero.Enter valid Number for reciprocal.");
		}
		catch(InputMismatchException e) {
			throw new InputMismatchException("Enter the Valid Input Form.");
		}
		finally {
			s.close();
		}
	}
	public static void main(String[] args) {
		ExceptionHandle expObj = new ExceptionHandle();
		System.out.printf("The reciprocal is %f",expObj.processInput());
		
		
	}

}
