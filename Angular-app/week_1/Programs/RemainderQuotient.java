package Programs;

import java.util.*;

public class RemainderQuotient {
	public static int findQuotientRemainder(int quotient,int divisor,int dividend) {
		if (divisor == 0) {
			throw new ArithmeticException("Enter the valid Divisor.");
		}
		if (dividend < divisor) {
			System.out.printf("The quotient is  : %d",quotient);
			System.out.println();
			System.out.printf("The remainder is : %d ",dividend);
			return quotient;
		}
		else return findQuotientRemainder(quotient+=1,divisor,dividend - divisor);
	}

	public static void main(String[] args) throws InputMismatchException{
		// TODO Auto-generated method stub
		try {
			int quotient = 0;
			Scanner s = new Scanner(System.in);
			System.out.print("Enter the Dividend :  ");
			int dividend = s.nextInt();
			System.out.print("Enter the Dividend : ");
			int divisor = s.nextInt();
			findQuotientRemainder(quotient,divisor,dividend);
		}
		catch(InputMismatchException e){
			throw new InputMismatchException("Enter the Valid Input.");
		}
		
		

	}

}
