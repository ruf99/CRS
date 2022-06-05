import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Admin_Information extends User_Information implements Admin_Information_Interface, Serializable{

	private static final long serialVersionUID = 1L;
	
	public Admin_Information (String f_name, String l_name, String u_name, String pwrd) {
		super(f_name, l_name, u_name, pwrd);
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
		
		String success = "Successfully created new course!";
		System.out.println(success);
		Main_Execute.courses.add(courseCreation);
		try {
			Main_Execute.serialize("Courses", Main_Execute.courses);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void deleteCourse() {
		//A2
		Scanner scan = new Scanner(System.in);
		for (Course_Information c : Main_Execute.courses) {
			System.out.println(String.format("%-42s %-30s %17s", c.getCourseName(),c.getCourseID(), c.getCourseSection()));
		}
		
		
		
		Course_Information remove_course = null;

			  System.out.println("Please enter the: \nCourse ID [STRING] \nCourse Section [INT]");
			  String delCourseID = scan.nextLine();
			  int delCourseSec = scan.nextInt();
        
              for (Course_Information c : Main_Execute.courses) {
                  if (c.getCourseID().equals(delCourseID) && (c.getCourseSection() == (delCourseSec))) {
                      remove_course = c;
                  }
              }
              
              Main_Execute.courses.remove(remove_course);
              
          
	
	}

	public static void editCourse() throws IOException {
		//A3
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the Course Name [STRING] and Course ID [STRING] of the course you would like to edit.");
		
		for (Course_Information c : Main_Execute.courses) {
			System.out.println(String.format("%-42s %-30s", c.getCourseName(),c.getCourseID()));
		}
		
		Course_Information course_choose = null;
		while (true) {
			String courseName = s.nextLine();
			String courseID = s.nextLine();
			for (Course_Information cs : Main_Execute.courses) {
				if (cs.getCourseName().equals(courseName) && (cs.getCourseID().equals(courseID))) {
					course_choose = cs;
					Main_Execute.courses.remove(cs);
					break;
				}
			}
		
		
			if (course_choose == null) {
				System.out.println("Sorry, that course was not present in our list.");
			}
			else {
				break;
			}
		}
		
		System.out.println("What would you like to edit in " + course_choose.getCourseName() + "?");
		System.out.println("1. Maximum Students \n2. Current Students \n3. Course Instructor \n4. Course Section \n5. Course Location ");
		int choice = s.nextInt();
					
						if (choice == 1) {
							Scanner scan1 = new Scanner(System.in);
							System.out.println("The maximum number of students for this course is: " + course_choose.getMaximumStudents());
							System.out.println("What would you like to edit it to? [INT] : ");
							int courseMaxStu = scan1.nextInt();
							course_choose.setCourseMaximumStudents(courseMaxStu);
							Main_Execute.courses.add(course_choose);
							
							
							
						}
					
						if (choice == 2) {
							Scanner scan2 = new Scanner(System.in);
							System.out.println("The existing number of students for this course is: " + course_choose.getCurrentStudents());
							System.out.println("What would you like to edit it to? [INT] : ");
							int courseCurrStu = scan2.nextInt();
							course_choose.setCurrentStudents(courseCurrStu);
							Main_Execute.courses.add(course_choose);
						
							
						}
					
						if (choice == 3) {
							Scanner scan3 = new Scanner(System.in);
							System.out.println("The existing Instructor for this course is: " + course_choose.getCourseInstructor());
							System.out.println("What would you like to edit it to? [STRING] : ");
							String courseInstruc = scan3.nextLine();
							course_choose.setCourseInstructor(courseInstruc);
							Main_Execute.courses.add(course_choose);
							
							
						}
					
						if (choice == 4) {
							Scanner scan4 = new Scanner(System.in);
							System.out.println("The existing Section for this course is: " + course_choose.getCourseSection());
							System.out.println("What would you like to edit it to? [INT] : ");
							int courseSec = scan4.nextInt();
							course_choose.setCourseSection(courseSec);
							Main_Execute.courses.add(course_choose);
						
							
						}
					
						if (choice == 5) {
							Scanner scan5 = new Scanner(System.in);
							System.out.println("The existing location for this course is: " + course_choose.getCourseLocation());
							System.out.println("What would you like to edit it to? [STRING] : ");
							String courseLoc = scan5.nextLine();
							course_choose.setCourseLocation(courseLoc);
							Main_Execute.courses.add(course_choose);
							
					
							
							
						}
					}

		
			
	
	public static void displayCourse(ArrayList<Course_Information> courses) {
		//A4
		
		Course_Information c_select = null;
		System.out.println("Please enter the course name [STRING] you wish to display information for.");
		Scanner ss = new Scanner(System.in);
		while(true) {
		String courseName = ss.nextLine();
		for (Course_Information cs : courses) {
			if (cs.getCourseName().equals(courseName)) {
				c_select = cs;
				System.out.println("\nCourse Name: " + c_select.getCourseName() + "\nCourse ID: " + c_select.getCourseID() + "\nMax Students: " + 
						c_select.getMaximumStudents()+  "\nCourse Instructor: " + c_select.getCourseInstructor() + "\nCourse Section: " + 
						c_select.getCourseSection() + "\nCourse Location: " + c_select.getCourseLocation());
				if (cs.getStudentsNames() != null) {
					for (Student_Information s : cs.getStudentsNames()) {
						System.out.println(s.getFirstName() + " " + s.getLastName());
					}
				}
				break;
			}
		} 
			
			if (c_select == null)  {
				System.out.println("Sorry, the course you have entered is not in our system. Please try again.");
			}
			
			else {
				break;
			}
		}
		
		try {
			Main_Execute.serialize("Courses", Main_Execute.courses);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	//A5 is in Student_Information
	
	//A6 is Exit. 
	
	//REPORTS (B):
	
	public static void viewCourses() {
		//B1
		System.out.println(String.format("%-42s %-20s %-20s %-10s", "Course Name: ","Course ID: ","Current Students: ","Maximum Students "));
		for (Course_Information cs : Main_Execute.courses) {
			System.out.println(String.format("%-42s %-28s %-21s %-10s", cs.getCourseName(),cs.getCourseID(),cs.getCurrentStudents(),cs.getMaximumStudents()));
			ArrayList<Student_Information> students_List = cs.getStudentsNames();
            if (students_List != null) {
                for (Student_Information s : students_List)
                    System.out.println(s.getFirstName() + " " + s.getLastName());
            }
		}	
		
	}

	public static void viewFullCourses() {
		//B2
	
			for (Course_Information c : Main_Execute.courses) {
				if (c.getCurrentStudents() == c.getMaximumStudents()) {
					System.out.println("Course Name: " + c.getCourseName() + " Course ID: " + c.getCourseID() + 
					" Current Students: " + c.getCurrentStudents() + " Maximum Students: " + c.getMaximumStudents());
				}
			}
	}

	public static void fileWriterFull() {
		//B3
		try {
			File write2File = new File("TheseAreFullCourses.txt");
			if(!write2File.exists()) {
					write2File.createNewFile();
			}
			String these_are_full = "";
			FileWriter w = new FileWriter(write2File.getAbsoluteFile());
			w.write("These are the courses that are full: ");
			for (Course_Information c : Main_Execute.courses) {	
				if (c.getCurrentStudents() == c.getMaximumStudents()) {
					these_are_full += c.getCourseName() + " Max Students: " + c.getMaximumStudents() + " Current Students: " + c.getCurrentStudents() + " \n";
				}
			}
			w.write(these_are_full);
			w.close();
		} catch (IOException e) {
			System.out.println("There are currently no full courses to display.");
			e.printStackTrace();
		}
		catch (Exception ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }
		
	}

	public static void specificReg() {
		//B4
		Scanner sss = new Scanner(System.in);
		for (Course_Information cs : Main_Execute.courses) {
			System.out.println("Course Name: " + cs.getCourseName() + " \tCourse ID: " + cs.getCourseID());
		}
		
		System.out.println("Please enter the Course ID to view registered students' list: ");
		String courseID = sss.next();
		Course_Information select = null;
		while(true) {
			for (Course_Information cs : Main_Execute.courses) {
				if (cs.getCourseID().equals(courseID)) {
					select = cs;
					if(select.getStudentsNames() != null) {
	                    ArrayList<Student_Information> these_students = cs.getStudentsNames();
	                    for (Student_Information s : these_students) {
	                        System.out.println(s.getFirstName() + " " + s.getLastName());
	                    }
					}
					
					else {
						System.out.println("No students are currently enrolled in " + select.getCourseName());
						break;
					}
					break;
				}
			
			}
			
			if (select == null) {
				System.out.println("Course was not found");
			}
			
			else {
				break;
			}
		}
		
	}

		//B5
	
		public static void sortKids(ArrayList<Course_Information> courses) {
		
			for (int i = 0; i < courses.size(); i++) {
				for (int j = courses.size() - 1; j > i; j--) {
					if (courses.get(i).getCurrentStudents() > courses.get(j).getCurrentStudents()) {
						Course_Information sp = courses.get(i);
						courses.set(i, courses.get(j));
						courses.set(j, sp);
					}
				}
			}
			
			displayCourse(courses);
		
	}
		
}
