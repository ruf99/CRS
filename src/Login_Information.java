import java.util.Scanner;

public class Login_Information extends User_Information {
	
	public static void User() {
		
	}
	
	public void StudentName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Student full name: ");
		String sn = sc.next();
	}
	
	public void Username() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Username: ");
		String username = sc1.next();
	}
	
	public void Password() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Password: ");
		String password = sc2.next();
	}
	
}
