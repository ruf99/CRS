import java.util.ArrayList;
import java.util.Scanner;

public class Student_Information extends User_Information implements Student_Information_Interface {
	
	public static ArrayList<String> register_StuCourses = new ArrayList<String>();
	
	public String student_name,username,password;
	
	public Student_Information() {
		
	}
	
	public static Student_Information s = new Student_Information();	//creating object s
	
	public Student_Information (String student_name, String username, String password, ArrayList<String> c) {
		this.student_name = student_name;
		this.username = username;
		this.password = password;
		Student_Information.register_StuCourses = c;
	}
	
	//GETTERS
	
	public ArrayList<String> getRegCourse(){
		return register_StuCourses;
	}
	
	public String getStuName(){
		return student_name;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	//SETTERS:
	
	public void setRegCourse(ArrayList<String> reg) {
		Student_Information.register_StuCourses = reg;
	}
	
	public void setStudentName(String student_name) {
		this.student_name = student_name;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void viewAllCourses() {
		//1
		System.out.println(String.format("%-42s %-20s %-20s %-10s", "Course Name: ","Course ID: ","Current Students: ","Maximum Students "));
		Course_Information c = new Course_Information();
		for (int l = 0; l < Main_Execute.courses.size(); l++) {
			c = Main_Execute.courses.get(l);
			System.out.println(String.format("%-42s %-28s %-21s %-10s", c.getCourseName(),c.getCourseID(),c.getCurrentStudents(),c.getMaximumStudents()));
		}
		
	}

	public static void viewOpenCourses() {
		//2
		for (int j = 0; j < Main_Execute.courses.size(); j++) {
			Course_Information p = Main_Execute.courses.get(j);
			if (p.getCurrentStudents() != p.getMaximumStudents()) {
				System.out.println(p.getCourseName());
			}
		}
		
	}

	public static void Registration() {
		//3
		Scanner use = new Scanner(System.in);
		Course_Information ccc = new Course_Information();
		ArrayList<String> registerStudent = new ArrayList<String>();
		
		System.out.println("Please enter full name of the student [STRING]: ");
		String fStudentName = use.nextLine();
		System.out.println("Please enter the Course Name [STRING] you wish to register in: ");
		String courseN = use.nextLine();
		System.out.println("Please enter the Course Section [INT] you wish to register in: ");
		int courseSec = use.nextInt();
		
		
		for (int i = 0; i < Data_Information.students.size(); i++) {
			Student_Information sss = Data_Information.students.get(i);
			
			if (sss.getStuName().equals(fStudentName)) {
				for (int p = 0; p < Main_Execute.courses.size(); p++) {
					ccc = Main_Execute.courses.get(p);
					
					if ((ccc.getCourseName().equals(courseN)) && (ccc.getCourseSection() == (int) courseSec)) {
						if ((ccc.getCurrentStudents() != ccc.getMaximumStudents()) || (ccc.getCurrentStudents() < ccc.getMaximumStudents())) {
							ccc.setCurrentStudents(1);
							System.out.println("Registered!");
							ccc.addKid(fStudentName);
						}
						 
							
					}
					
				}
			}
			
		}
	}

	public static void WithdrawCourse() {
		//4
		Course_Information c = new Course_Information();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Course Name you wish to withdraw from: ");
		String courseName = sc.next();
		System.out.println("Please verify your full name for our system: ");
		String student_name = sc.next();
		
		for (int z = 0; z < Data_Information.students.size(); z++) {
			Student_Information stu = Data_Information.students.get(z);
			
			if (stu.getStuName().equals(student_name)) {
				for (int n = 0; n < Main_Execute.courses.size(); n++) {
					c = Main_Execute.courses.get(n);
					
					if (courseName.equals(c.getCourseName())) {
						c.removeKid(student_name);
					}
				}
			}
			Data_Information.course.remove(courseName);
		}
		
	}

	/*public static void DisplayMyCourses() {
		//5
		for (int s = 0; s < Data_Information.course.size(); s++) {
			System.out.println(Data_Information.course.get(s));
		}
		
	}*/
}
