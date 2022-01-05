import java.io.Serializable;
import java.util.ArrayList;

public class Course_Information implements Serializable {
	
	public Course_Information() {
		
	}
	
	public static final long serialVersionUID = 1L;
	public String courseName;
	public String courseID;
	public int maximumStudents;
	public int currentStudents;
	public ArrayList<String> studentNames;
	public String courseInstructor;
	public int courseSection;
	public String courseLocation;
	public ArrayList<String> students_Courses;
	
	public Course_Information(String cName, String cID, int maxStu, int curStu, ArrayList<String> studentNames, String cInstruc, int cSec, String cLoc) {
		this.courseName = cName;
		this.courseID = cID;
		this.maximumStudents = maxStu;
		this.currentStudents = curStu;
		this.studentNames = new ArrayList<String>();
		this.courseInstructor = cInstruc;
		this.courseSection = cSec;
		this.courseLocation = cLoc;
	}
	

	//GETTERS

	public String getCourseName() {
		return courseName;
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public int getMaximumStudents() {
		return maximumStudents;
	}
	
	public int getCurrentStudents() {
		return currentStudents;
	}
	
	public  ArrayList<String> getStudentsNames() {
		return studentNames;
	}
	
	public ArrayList<String> getstudent_courses() {
		return students_Courses;
	}
	
	public String getCourseInstructor() {
		return courseInstructor;
	}
	
	public int getCourseSection() {
		return courseSection;
	}
	
	public String getCourseLocation() {
		return courseLocation;
	}
	
	//SETTER:
	
	public void setCourseLocation(String courseLoc) {
		courseLocation = courseLoc;
	}
		
	public void setCourseSection(int courseSec) {
		courseSection = courseSec;
	}
	
	public void setStudents(ArrayList<String> students) {
		studentNames = students;
	}
	
	public void setstudent_courses(ArrayList<String> student_courses) {
		this.students_Courses = student_courses;
	}
	
	public void setCourseInstructor(String courseInstruc) {
		courseInstructor = courseInstruc;
	}
		
	public void setCurrentStudents(int currentStu) {
		currentStudents += currentStu;
	}
		
	public void setCourseCurrentStudents(int courseCurrStu) {
		currentStudents = courseCurrStu;
	}
		
	public void setCourseMaximumStudents(int mStu) {
		maximumStudents = mStu;
	}


	public void addKid(String fStudentName) {
		this.studentNames.add(fStudentName);
		this.currentStudents += 1;
	}


	public void removeKid(String student_name) {
		this.studentNames.remove(student_name);
		this.currentStudents -= 1;
	}

	
}
