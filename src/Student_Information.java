import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student_Information extends User_Information {
	

	private static final long serialVersionUID = 1L;
	public static ArrayList<Course_Information> register_StuCourses; 
	
	public Student_Information (String f_name, String l_name, String u_name, String pwrd) {
		super(f_name, l_name, u_name, pwrd);
		
	}
	
	//GETTERS
	
	public ArrayList<Course_Information> getCourses_Reg() {
		return register_StuCourses;
	}
	

	

	//SETTERS:
	

	public ArrayList<Course_Information> setCourses_Reg (ArrayList<Course_Information> register_StuC_s) {
	       ArrayList<Course_Information> c = register_StuCourses;
	       register_StuCourses = register_StuC_s;
	       return c;
	 }
	
	public void addRegisteredCourse(Course_Information cs) {
		register_StuCourses.add(cs);
	   }
	
	public static Student_Information registerStudent() {
		//A5 from Admin Menu
		Scanner inputStu = new Scanner(System.in);
		System.out.println("Enter Student First Name: ");
		String f_name = inputStu.nextLine();
		System.out.println("Enter Student Last Name: ");
		String l_name = inputStu.nextLine();
		
		System.out.print("Enter Student username: ");
	    String u_name = inputStu.nextLine();
	    System.out.print("Enter Student password: ");
	    String password = inputStu.nextLine();
	       
		Student_Information studentCreation = new Student_Information (f_name, l_name, u_name, password);
		System.out.println("New student: " + studentCreation.getFirstName() + " " + studentCreation.getLastName() + " has been successfully added!");
		System.out.println(" ");
		return studentCreation;
	}
	
	public static void viewAllCourses() {
		//1
		System.out.println(String.format("%-42s %-30s", "Course Name: ","Course ID: "));
		for (Course_Information c : Main_Execute.courses) {
			System.out.println(String.format("%-42s %-30s", c.getCourseName(),c.getCourseID()));
		}
		
	}

	public static void viewOpenCourses() {
		//2
		for (Course_Information c : Main_Execute.courses) {
			if (c.getCurrentStudents() < c.getMaximumStudents()) {
				System.out.println("Course Name: " + c.getCourseName());
			}
		}
		
	}

	public static void Registration(Student_Information student_input) throws IOException {
		//3
		Scanner spot = new Scanner(System.in);
		System.out.println("Courses that have spots left: ");
		ArrayList<Course_Information> remainingSpots = new ArrayList<Course_Information>();
		for (Course_Information c : Main_Execute.courses) {
			if (c.getCurrentStudents() < c.getMaximumStudents()) {
				System.out.println(String.format("%-42s %-30s", c.getCourseName(),c.getCourseID()));
				remainingSpots.add(c);
			}
		}
		
		boolean keep_going = true;
		while (keep_going) {
			 System.out.print("Enter the Course ID of the course you wish to enroll in: ");
			 String select_courseID = spot.nextLine();
			 for (Course_Information c : remainingSpots) {
				 if (select_courseID.equals(c.getCourseID())) {
					 for (Course_Information enrol : student_input.getCourses_Reg()) {
						 if (select_courseID.equals(enrol.getCourseID())) {
							 System.out.println("You're trying to double-enroll in this course, you are already enrolled. Please try again.");
							 
							
										enrol.getStudentsNames().remove(student_input);
										enrol.setCurrentStudents(enrol.getCurrentStudents() - 1);
										student_input.getCourses_Reg().remove(enrol);

										try {
											Main_Execute.serialize("Courses", Main_Execute.courses);
										} catch (IOException e) {
											e.printStackTrace();
										}
										
										try {
											Main_Execute.serialize("Students", Main_Execute.students);
										} catch (IOException e) {
											e.printStackTrace();
										}
										
										
									}
									
							 
							 break;
						 }
					 }
					 
					 c.setCurrentStudents((c.getCurrentStudents() + 1));
					 if (c.getStudentsNames() != null) {
						 c.getStudentsNames().add(student_input);
					 }
					 
					 else {
						 c.setStudentList(new ArrayList<Student_Information>());
					 }
					 
					 student_input.addRegisteredCourse(c);
					 
						Main_Execute.serialize("Courses", Main_Execute.courses);
					
						Main_Execute.serialize("Students", Main_Execute.students);
					
					 keep_going = false;
					 
				 }
			 }
			 
		
		}
		
	

	public static void Withdraw(Student_Information student_input) {
		//4
		Scanner sc = new Scanner(System.in);
		System.out.println("Your currently enrolled courses are: ");
		if ((student_input.getCourses_Reg() != null) && (student_input.getCourses_Reg().size() != 0)) {
			for (Course_Information c : student_input.getCourses_Reg()) {
				System.out.println("Course Name: " + c.getCourseName() + " \tCourse ID: " + c.getCourseID());
				System.out.println();
			}
			
			boolean we_are_still_here = true;
			while (we_are_still_here) {
				
				System.out.println("Please enter the Course ID of the course you want to withdraw from: ");
				String user_withdraw = sc.nextLine();
				for (Course_Information wd : student_input.getCourses_Reg()) {
					if (user_withdraw.equals(wd.getCourseID())) {
						wd.getStudentsNames().remove(student_input);
						wd.setCurrentStudents(wd.getCurrentStudents() - 1);
						student_input.getCourses_Reg().remove(wd);
						
						we_are_still_here = false;
						
						try {
							Main_Execute.serialize("Courses", Main_Execute.courses);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						try {
							Main_Execute.serialize("Students", Main_Execute.students);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						break;
					}
					
					if (true) {
						System.out.println("Invalid Course ID, please try again!");
					}
				}
			}
		}
		
		else {
			 System.out.println("you are not enrolled in any courses!");
		}
		
	}

	public static void CurrentlyRegistered(Student_Information student_input) {
		//5
		System.out.println("You are currently registered in: ");
		if ((student_input.getCourses_Reg() != null) && (student_input.getCourses_Reg().size() != 0)) {
			for (Course_Information c : student_input.getCourses_Reg()) {
				System.out.println("Course Name: " + c.getCourseName());
			}
		}
		
		else {
			System.out.println("You are not enrolled in any courses yet!");
		}
	}

}