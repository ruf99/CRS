import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main_Execute implements Serializable {
	
	private static final long serialVersionUID = 1L;
	static ArrayList<Course_Information> courses = new ArrayList<Course_Information>();
	static ArrayList<Admin_Information> admins = new ArrayList<Admin_Information>();
	static ArrayList<Student_Information> students = new ArrayList<Student_Information>();
	
	public static void serialize(String file, ArrayList<?> this_list) throws IOException {

		try {
			FileOutputStream fileOutS = new FileOutputStream(file);
			ObjectOutputStream objOutS = new ObjectOutputStream(fileOutS);
			
			objOutS.writeObject(this_list);
			objOutS.close();
			fileOutS.close();
		}
		catch (IOException ex) {
			System.out.println("Exception caught");
			ex.printStackTrace();
		}
		
		catch (Exception exp) {
            System.out.println("Exception caught");
            exp.printStackTrace();
        }
	}
	
	
	public static ArrayList<?> deSerialize(String file) {

		try {
			FileInputStream fileInS = new FileInputStream(file);
			ObjectInputStream objInS = new ObjectInputStream(fileInS);

			ArrayList<?> this_list = (ArrayList<?>) objInS.readObject();
			objInS.close();
			fileInS.close();
			return this_list;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		
		start_readingCSV(courses);
		

		WelcomeToNYU();
	}
	
	
	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public static void start_readingCSV(ArrayList<Course_Information> courses) throws IOException {
	
		File checkExistence = new File("Courses");
		if (!checkExistence.exists()) {
			try {
				File thisIsCSVFile = new File("MyUniversityCourses (4).csv");
				FileReader f = new FileReader(thisIsCSVFile);
				@SuppressWarnings("resource")
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
			
			catch (Exception e) {
                System.out.println("Error found");
            }
			
			serialize("Courses", courses);
			
		}
		
		else {
			courses = (ArrayList<Course_Information>)deSerialize("Courses");
		}
		
		File file_2real = new File("Admins");
        if (!file_2real.exists()) {
            Admin_Information main_admin = new Admin_Information("Rufaida", "Khan", "Admin", "Admin001");
            admins.add(main_admin);

            serialize("Admins", admins);
        } 
        
        else {
            admins = (ArrayList<Admin_Information>) deSerialize("Admins");
        }

   
        File file_3real = new File("Students");
        if (!file_3real.exists()) {
            
            Student_Information student = new Student_Information ("Jane", "Doe", "JD", "Doe99");
            students.add(student);
            serialize("Students", students);
        } 
        
        else {
            students = (ArrayList<Student_Information>) deSerialize("Students");
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
			
		
				
				
				if (decision2 == '1') { 	
				Admin_Information.createNewC();
				System.out.println();
				}
				
				if (decision2 == '2') {	Admin_Information.deleteCourse();
				serialize("Courses", courses);
				System.out.println();		
				}
				if (decision2 == '3') {	Admin_Information.editCourse();
				serialize("Courses", courses);
				System.out.println();
				}
				if (decision2 == '4') {	Admin_Information.displayCourse(courses);
				System.out.println();
				}
				if (decision2 == '5') {	
				students.add(Student_Information.registerStudent());
				serialize("Students", students);
				System.out.println();
				}
				if (decision2 == '6') {	
				
				WelcomeToNYU();
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
				System.out.println("Sorting courses...");
				Admin_Information.sortKids(courses);
			}
			
			if (decision2 == '6') {
				
				WelcomeToNYU();
			}
			
		}selectionAdmin(1);
		
		

	}
	
	
	private static void studentMenu() throws IOException {
	
		Scanner scan = new Scanner(System.in);
		Student_Information student_input = null;
		
			System.out.println("Please enter your username: ");
			String user_name = scan.nextLine();
			for (Student_Information s : students) {
				if (s.getUserName().equals(user_name)) {
					student_input = s;
				}
			}
			
			System.out.println("Please enter your password for account: " + user_name);
			String pass_word = scan.nextLine();
			if (student_input != null) {
				if (pass_word.equals(student_input.getPassword())) {
					System.out.println("Hi " + student_input.getFirstName() + " " + student_input.getLastName() + "! ");
					System.out.println();
				}
				
				else {
					System.out.println("Wrong password, please try again!");
				}
				
			}
			
			selectionStudent(student_input);
			
	}
	
	
	public static void selectionStudent(Student_Information student_input) throws IOException {
		int selectStud = -1;
		
		Scanner scan = new Scanner(System.in);
		
		if (student_input.getCourses_Reg() == null) {
			student_input.setCourses_Reg(new ArrayList<Course_Information>());
		}
		System.out.println();
		System.out.println("Please enter the menu option you would like.");
		while (true) {
			System.out.println("Course Management");
            System.out.println("1. View all courses");
            System.out.println("2. View all courses that are NOT full");
            System.out.println("3. Register in a course");
            System.out.println("4. Withdraw from a course");
            System.out.println("5. View all courses the current student is registered in");
            System.out.println("6. Exit");
            System.out.println();
         
            
            	try {
            		selectStud = Integer.parseInt(scan.nextLine());
            	}
            	
            	catch(Exception ex) {
            		System.out.println("Error. Exception caught");
            		
            	}
            	
            	if (selectStud != -1) {
            		break;
            	}
            }
            
            if (selectStud == 1) {	
				Student_Information.viewAllCourses();
				
			}
			
			if (selectStud == 2) {	
				Student_Information.viewOpenCourses();
			}
			
			if (selectStud == 3) {	
				
				Student_Information.Registration(student_input);
				
			}
			
			if (selectStud == 4) {	
				Student_Information.Withdraw(student_input);
			}
			
			if (selectStud == 5) {	
				Student_Information.CurrentlyRegistered(student_input);
				
			}
			
			if (selectStud == 6) {
				WelcomeToNYU();
			}
			
			selectionStudent(student_input);
		
            
		}
			

	
	
}