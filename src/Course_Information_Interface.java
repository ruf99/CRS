import java.util.ArrayList;

public interface Course_Information_Interface {
	
	
	public String getCourseName();
	
	public String getCourseID();
	
	public int getMaximumStudents();
	
	public int getCurrentStudents();
	
	public  ArrayList<Student_Information> getStudentsNames();
	
	public String getCourseInstructor();
	
	public int getCourseSection();
	
	public String getCourseLocation();
	
	
	public String setCourseLocation(String courseLoc);
		
	public int setCourseSection(int courseSec);
	
	public ArrayList<Student_Information> setStudentList(ArrayList<Student_Information> student_Names);
	
	public String setCourseInstructor(String courseInstruc);
		
		
	public int setCurrentStudents(int courseCurrStu);
		
	public int setCourseMaximumStudents(int mStu);


	public void addKid(Student_Information s_a);


	public Student_Information removeKid(Student_Information s_r);

}
