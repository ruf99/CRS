import java.io.Serializable;
import java.util.ArrayList;

public class Course_Information implements Serializable {

	public static final long serialVersionUID = 1L;
	public String courseName;
	public String courseID;
	public int maximumStudents;
	public int currentStudents;
	public ArrayList<Student_Information> studentNames;
	public String courseInstructor;
	public int courseSection;
	public String courseLocation;
	
	public Course_Information(String cName, String cID, int maxStu, int curStu, ArrayList<Student_Information> student_Names, String cInstruc, int cSec, String cLoc) {
		this.courseName = cName;
		this.courseID = cID;
		this.maximumStudents = maxStu;
		this.currentStudents = curStu;
		this.studentNames = student_Names;
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
	
	public  ArrayList<Student_Information> getStudentsNames() {
		return studentNames;
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
	
	public String setCourseLocation(String courseLoc) {
		courseLocation = courseLoc;
		return courseLocation;
	}
		
	public int setCourseSection(int courseSec) {
		courseSection = courseSec;
		return courseSection;
	}
	
	public ArrayList<Student_Information> setStudentList(ArrayList<Student_Information> student_Names) {
		studentNames = student_Names;
		return studentNames;
	}
	
	public String setCourseInstructor(String courseInstruc) {
		courseInstructor = courseInstruc;
		return courseInstructor;
	}
		
		
	public int setCurrentStudents(int courseCurrStu) {
		currentStudents = courseCurrStu;
		return currentStudents;
	}
		
	public int setCourseMaximumStudents(int mStu) {
		maximumStudents = mStu;
		return maximumStudents;
	}


	public void addKid(Student_Information s_a) {
		studentNames.add(s_a);
	}


	public Student_Information removeKid(Student_Information s_r) {
		 if (studentNames.remove(s_r))
	            return s_r;
	        else
	            return null;
	}

	
}