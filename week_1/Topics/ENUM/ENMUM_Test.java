package Topics.ENUM;

import java.util.Scanner;

public class ENMUM_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the day to check for Holiday or not : ");
		String day = s.nextLine().toUpperCase();
		boolean valid = false;
		for(ENUM_Days d : ENUM_Days.values()) {
			if (d.name().equals(day)) {
				valid = true;
				break;
			}
		}
		if (!valid) {
			System.out.println(ENUM_Holiday_Not_Holiday.ENTER_VALID_INPUT);
		}
		else if (day.toLowerCase().equals("sunday") || day.toLowerCase().equals("saturday")){
			System.out.println(ENUM_Holiday_Not_Holiday.HOLIDAY);
		}
		else {
			System.out.println(ENUM_Holiday_Not_Holiday.NOT_HOLIDAY);
		}

	}

}
