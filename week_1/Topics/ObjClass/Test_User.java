package Topics.ObjClass;

public class Test_User {
	public static void main(String[] args) {
		User user = new User();
		SecondUser secondUser = new SecondUser();
		System.out.println("The overridden toString() for Class User : " + user);
		System.out.println("The toString() for Class SecondUser " + secondUser);
		System.out.println();
		System.out.println("The overridden hashcode() for Class User " + user.hashCode());
		System.out.println("The hashcode() for Class SecondUSer " + secondUser.hashCode());
		System.out.println();
		System.out.println("The overridden equals() for Class User " + user.equals(user));
		System.out.println("The equals() for Class SecondUser " + secondUser.equals(secondUser));
	}
}
