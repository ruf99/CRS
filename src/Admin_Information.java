import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Admin_Information extends User_Information implements Admin_Information_Interface, Serializable{

	private static final long serialVersionUID = 1L;
	
	public Admin_Information(String student_name, String username, String password) {
		String sn = student_name;
		String un = username;
		String p = password;
	}
	
	//A (1 through 6):
	
	public static void createNewC() {
		//A1
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Course Name [STRING] :");
		String courseName = input.nextLine();
		System.out.println("Enter Course ID [STRING] :");
		String courseID = input.nextLine();
		System.out.println("Enter Maximum Students in course  [INT] :");
		int maximumStudents = Integer.parseInt(input.nextLine());
		System.out.println("Enter Current Students [INT] :");
		int currentStudents = Integer.parseInt(input.nextLine());
		System.out.println("Enter Course Instructor [STRING] :");
		String courseInstructor = input.nextLine();
		System.out.println("Enter Course Section [INT] :");
		int courseSection = Integer.parseInt(input.nextLine());
		System.out.println("Enter Course Location [STRING] :");
		String courseLocation = input.nextLine();
		Course_Information courseCreation = new Course_Information(courseName, courseID, maximumStudents, currentStudents, null, courseInstructor, courseSection, courseLocation);
		Main_Execute.courses.add(courseCreation);
		String success = "Successfully created new course!";
		System.out.println(success);
	}

	public static void deleteCourse() {
		//A2
		Scanner scan = new Scanner(System.in);
		Course_Information c = new Course_Information();
		System.out.println("Please enter the: \nCourse ID [STRING] \nCourse Section [INT]");
		String delCourseID = scan.nextLine();
		int delCourseSec = scan.nextInt();
		int count = 0;
		for (int x = 0; x < Main_Execute.courses.size(); x++) {
			c = Main_Execute.courses.get(x);
			
			if (c.getCourseID().equals(delCourseID)) {
				if (c.getCourseSection() == delCourseSec) {
					break;
				}
			}
			count++;
			
		}
		Main_Execute.courses.remove(count - 1);
		System.out.println("Successfully deleted course!");
		
	}

	public static void editCourse() {
		//A3
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the Course Name [STRING] and Course ID [STRING] of the course you would like to edit.");
		String courseName = s.nextLine();
		String courseID = s.nextLine();
		Course_Information course = new Course_Information();
		int counter = 0;
		int choice;
		for (int x = 0; x < Main_Execute.courses.size(); x++) {
			course = Main_Execute.courses.get(x);
				if (course.getCourseName().equals(courseName) && (course.getCourseID().equals(courseID))) {
					counter++;
					if (counter == 1) {
						System.out.println("What would you like to edit?");
						System.out.println("1. Maximum Students \n2. Current Students \n3. Course Instructor \n4. Course Section \n5. Course Location ");
						choice = s.nextInt();
					
						if (choice == 1) {
							Scanner scan1 = new Scanner(System.in);
							System.out.println("The maximum number of students for this course is: " + course.getMaximumStudents());
							System.out.println("What would you like to edit it to? [INT] : ");
							int courseMaxStu = scan1.nextInt();
							course.setCourseMaximumStudents(courseMaxStu);
						}
					
						if (choice == 2) {
							Scanner scan2 = new Scanner(System.in);
							System.out.println("The existing number of students for this course is: " + course.getCurrentStudents());
							System.out.println("What would you like to edit it to? [INT] : ");
							int courseCurrStu = scan2.nextInt();
							course.setCourseCurrentStudents(courseCurrStu);
							
						}
					
						if (choice == 3) {
							Scanner scan3 = new Scanner(System.in);
							System.out.println("The existing Instructor for this course is: " + course.getCourseInstructor());
							System.out.println("What would you like to edit it to? [STRING] : ");
							String courseInstruc = scan3.nextLine();
							course.setCourseInstructor(courseInstruc);
							
						}
					
						if (choice == 4) {
							Scanner scan4 = new Scanner(System.in);
							System.out.println("The existing Section for this course is: " + course.getCourseSection());
							System.out.println("What would you like to edit it to? [INT] : ");
							int courseSec = scan4.nextInt();
							course.setCourseSection(courseSec);
							
						}
					
						if (choice == 5) {
							Scanner scan5 = new Scanner(System.in);
							System.out.println("The existing location for this course is: " + course.getCourseLocation());
							System.out.println("What would you like to edit it to? [STRING] : ");
							String courseLoc = scan5.nextLine();
							course.setCourseLocation(courseLoc);
							
						}
					}
				}
			}
		Course_Information c = new Course_Information();
		for (int l = 0; l < Main_Execute.courses.size(); l++) {
			c = Main_Execute.courses.get(l);
			if (courseName.equals(c.getCourseName())) {
				System.out.println("\nCourse Name: " + c.getCourseName() + "\nCourse ID: " + c.getCourseID() + "\nMax Students: " + c.getMaximumStudents()+ "\nCurrent Students: " + c.getCurrentStudents() + "\nCourse Instructor: " + c.getCourseInstructor() + "\nCourse Section: " + c.getCourseSection() + "\nCourse Location: " + c.getCourseLocation());
			}
			
		}
	}

	public static void displayCourse() {
		//A4
		System.out.println("Please enter the course name [STRING] you wish to display information for.");
		Scanner ss = new Scanner(System.in);
		String courseName = ss.nextLine();
		Course_Information c = new Course_Information();
		for (int l = 0; l < Main_Execute.courses.size(); l++) {
			c = Main_Execute.courses.get(l);
			if (courseName.equals(c.getCourseName())) {
				System.out.println("\nCourse Name: " + c.getCourseName() + "\nCourse ID: " + c.getCourseID() + "\nMax Students: " + c.getMaximumStudents()+ "\nCurrent Students: " + c.getCurrentStudents() + "\nCourse Instructor: " + c.getCourseInstructor() + "\nCourse Section: " + c.getCourseSection() + "\nCourse Location: " + c.getCourseLocation());
				
			}
				
		}
		
	}
	
	public static void registerStudent() {
		//A5
		Scanner inputStu = new Scanner(System.in);
		System.out.println("Enter Student First Name: ");
		String fname = inputStu.nextLine();
		System.out.println("Enter Student Last Name: ");
		String lname = inputStu.nextLine();
		String usern = null; 
		String pass = null;
		String fn = fname + " " + lname;
		
		Student_Information studentCreation = new Student_Information(fn,usern, pass,Data_Information.course);
		Data_Information.students.add(studentCreation);
		System.out.println("New student has been successfully added!");
		System.out.println(" ");
	}
	
	//A6 is Exit. 
	
	//REPORTS (B):
	
	public static void viewCourses() {
		//B1
		System.out.println(String.format("%-42s %-20s %-20s %-10s", "Course Name: ","Course ID: ","Current Students: ","Maximum Students "));
		Course_Information c = new Course_Information();
		for (int l = 0; l < Main_Execute.courses.size(); l++) {
			c = Main_Execute.courses.get(l);
			System.out.println(String.format("%-42s %-28s %-21s %-10s", c.getCourseName(),c.getCourseID(),c.getCurrentStudents(),c.getMaximumStudents()));
		}	
	}

	public static void viewFullCourses() {
		//B2
		Course_Information p = new Course_Information();
		for (int j = 0; j < Main_Execute.courses.size(); j++) {
			p = Main_Execute.courses.get(j);
			if (p.getCurrentStudents() == p.getMaximumStudents()) {
				System.out.println(p.getCourseName());
			}
		}
		
	}

	public static void fileWriterFull() {
		//B3
		try {
			FileWriter write2File = new FileWriter("TheseAreFullCourses.txt");
			write2File.write("These are the courses that are full: ");
			for (int i = 0; i <Main_Execute.courses.size(); i++) {
				Course_Information c = Main_Execute.courses.get(i);	
				if (c.getCurrentStudents() == c.getMaximumStudents()) {
					write2File.write(c.getCourseName());
				}
			}
			write2File.close();	
		} catch (IOException e) {
			System.out.println("There are currently no full courses to display.");
			e.printStackTrace();
		}
		
	}

	public static void specificReg() {
		//B4
		Scanner sss = new Scanner(System.in);
		System.out.println("Please enter the Course ID to view registered students' list: ");
		String courseID = sss.next();
		for (int h = 0; h <Main_Execute.courses.size(); h++) {
			Course_Information c = Main_Execute.courses.get(h);	
			if (c.getCourseID().equals(courseID)) {
				System.out.println(c.getStudentsNames().toString());
			}
		}
		
		
	}

	
	/*public static void studentsCourseList() {
		//B5
				Scanner sb5 = new Scanner(System.in);
				System.out.println("Please enter the full name of the Student to view registered Courses: ");
				String student_name = sb5.next();
				
				Student_Information thisIsStudent = new Student_Information(student_name, null,null,null);
				System.out.println("The registered courses for " + student_name + " are: ");
				
				Course_Information c = new Course_Information();
				
				for (int z = 0; z < Data_Information.students.size(); z++) {
					Student_Information stu = Data_Information.students.get(z);
					
					if (stu.getStuName().equals(student_name)) {
						for (int n = 0; n < Main_Execute.courses.size(); n++) {
							c = Main_Execute.courses.get(n);
							System.out.println(c.getstudent_courses().toString());
							
						}
					}
				}	
	}*/

	public static void sortKids() {
		//B5 - New
		ArrayList<Integer> sortedKids = new ArrayList<Integer>();
		Course_Information c = new Course_Information();
		for (int x = 0; x < Main_Execute.courses.size(); x++) {
			c = Main_Execute.courses.get(x);
			sortedKids.add(c.currentStudents);
			String courseID = c.getCourseID();
		}
		
		Collections.sort(sortedKids, Collections.reverseOrder());
		System.out.println(sortedKids.toString());
	}

	

}

