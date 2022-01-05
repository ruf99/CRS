import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Main_Execute implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static ArrayList<Course_Information> courses = new ArrayList<Course_Information>();

	public static void main(String[] args) throws IOException {
		User_Information this_is_Admin = new Admin_Information("Rufaida Khan", "Admin", "Admin001");
		Serialize_Deserialize.deSerializeStudents();
		Serialize_Deserialize.deSerializeCourses();
		start_readingCSV(courses);
		WelcomeToNYU();
	}
	
	
	public static void start_readingCSV(ArrayList<Course_Information> courses) throws IOException {
		
		
			try {
		
				File thisIsCSVFile = new File("MyUniversityCourses (4).csv");
				FileReader f = new FileReader(thisIsCSVFile);
				BufferedReader b = new BufferedReader(f);
				String thisIsLine = "";
				b.readLine(); //Skipping header because it's useless
				
				while ((thisIsLine = b.readLine()) != null) {
					String [] information = thisIsLine.split(",");
					Course_Information parseCSVtoCourses = new Course_Information(information[0], information[1], Integer.parseInt(information[2]), Integer.parseInt(information[3]), null, information[5], Integer.parseInt(information[6]), information[7]);
					courses.add(parseCSVtoCourses);
				}		
			
		}
		
			catch (IOException e) {
				e.printStackTrace();
			}
			
		
	}
		
	
	
	public static void WelcomeToNYU() throws IOException {
		
		System.out.println("Hello! Welcome to Course Registration. I am Albert, and I will do my best to help you today. \nAre you an (1) Admin or a (2) Student, or do you want to (3) Exit? \n(Note: Press 1 for Admin, 2 for Student and 3 for Exit)");
		
		Scanner input = new Scanner(System.in);
		int user_Input = input.nextInt();
		int counter = 0;
		while (counter < 1) {
			if (user_Input > 0 && user_Input < 4) {
				counter++;
			}
			
			else if (user_Input != 1 || user_Input != 2) {
				if (user_Input != 3) {
					System.out.println("Sorry! That input is invalid. Please try again.");
					System.out.println("Are you an (1) Admin or a (2) Student? or do you want to (3) Exit?: ");
					user_Input = input.nextInt();
				}
				
			}	
		}
		
		if (user_Input == 1) {
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Hello Admin! Please enter your username and password to proceed.");
			String usernameAdmin;
			System.out.println("Username [STRING]: ");
			usernameAdmin = b.readLine();
			String adminPassword;
			System.out.println("Password [STRING]: ");
			adminPassword = b.readLine();
			if (usernameAdmin.equals("Admin")) {
				if (adminPassword.equals("Admin001")) {
					adminMenu(user_Input);
				}
			}
		}
		
		if (user_Input == 2) {
			System.out.println("Hello Student!");
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			String stuNF, stuNL, stuUserN, stuPass;
			System.out.println("Student First Name [STRING]: ");
			stuNF = r.readLine();
			System.out.println("Student Last Name [STRING]: ");
			stuNL = r.readLine();
			System.out.println("Username [STRING]: ");
			stuUserN = r.readLine();
			System.out.println("Password [STRING]: ");
			stuPass = r.readLine();
			String student_fullname = stuNF + " " + stuNL;

			
			studentMenu();
			
		}
		
		if (user_Input == 3) { 
			System.out.println("You are choosing to exit, goodbye!");
			System.exit(0);
		}
		
		
	}

	public static void adminMenu(int user_input) throws IOException {
		System.out.println("A. Course Management: ");
		System.out.println("1. Create a new course");
		System.out.println("2. Delete a course");
		System.out.println("3. Edit a course");
		System.out.println("4. Display information for a given course");
		System.out.println("5. Register a student");
		System.out.println("6. Exit");
		
		System.out.println("B. Reports: ");
		System.out.println("1. View all Courses");
		System.out.println("2. View FULL Courses");
		System.out.println("3. Write to file (full courses)");
		System.out.println("4. View the names of students being registered in a specific course");
		System.out.println("5. Sort courses based on current number of student registers");
		System.out.println("6. Exit");
		
		selectionAdmin(user_input);
	}

	public static void selectionAdmin(int user_input) throws IOException {
		String selectAd;
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter the menu option you would like.");
		System.out.println("Eg. If you want Course Management - Register a Student, enter A5.");
		System.out.println("Please enter your selection here: ");
		selectAd = scan.nextLine();
		char decision1 = selectAd.charAt(0);
		char decision2 = selectAd.charAt(1);
		
		if (user_input == 1 && decision1 == 'A') {
			
		
				
				
				if (decision2 == '1') { 	Admin_Information.createNewC();
				System.out.println();
				}
				if (decision2 == '2') {	Admin_Information.deleteCourse();
				System.out.println();		
				}
				if (decision2 == '3') {	Admin_Information.editCourse();
				System.out.println();
				}
				if (decision2 == '4') {	Admin_Information.displayCourse();
				System.out.println();
				}
				if (decision2 == '5') {	Admin_Information.registerStudent();
				System.out.println();
				}
				if (decision2 == '6') {	WelcomeToNYU();
				System.out.println();
				}

			

		}
		
		
		
		if (user_input == 1 && decision1 == 'B') {
			if (decision2 == '1') {
				Admin_Information.viewCourses();
			}
			
			if (decision2 == '2') {
				Admin_Information.viewFullCourses();
			}	
			
			if (decision2 == '3') {
				Admin_Information.fileWriterFull();
			}
			
			if (decision2 == '4') {
				Admin_Information.specificReg();
			}	
			
			if (decision2 == '5') {
				Admin_Information.sortKids();
			}
			
			if (decision2 == '6') {
				WelcomeToNYU();
			}
			
		}selectionAdmin(1);
		

	}
	
	public static void studentMenu() throws IOException {
		System.out.println();
		
		System.out.println("Course Management\r\n"
				+ "1. View all courses\r\n"
				+ "2. View all courses that are not FULL\r\n"
				+ "3. Register on a course (in this case the student must enter the course name, section, and\r\n"
				+ "student full name, the name will be added to the appropriate course)\r\n"
				+ "4. Withdraw from a course (in this case the student will be asked to enter her/his student\r\n"
				+ "name and the course, then the name of the student will be taken off from the given course’\r\n"
				+ "list)\r\n"
				+ "5. Exit");
	selectionStudent();
	}
	
	public static void selectionStudent() throws IOException {
		int selectStud;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the menu option you would like.");
		System.out.println("Eg. If you want to - View all courses, enter 1 [INT] ");
		System.out.println("Please enter your selection here: ");
		selectStud = scan.nextInt();
		
		if (selectStud == 1) {	
			Student_Information.viewAllCourses();
		}
		
		if (selectStud == 2) {	
			Student_Information.viewOpenCourses();
		}
		
		if (selectStud == 3) {	
			Student_Information.Registration();
		}
		
		if (selectStud == 4) {	
			Student_Information.WithdrawCourse();
		}
		
		if (selectStud == 5) {	
			WelcomeToNYU();
		}
		selectionStudent();
	}
	
}
