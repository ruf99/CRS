import java.io.Serializable;
import java.util.ArrayList;

public class Data_Information implements Serializable {

	private static final long serialVersionUID = 1L;
	public static ArrayList<Student_Information> students = new ArrayList<Student_Information>();
	public Object s;
	public Object c;
	public static ArrayList<String> course = new ArrayList<String>();
	
	//SETTERS:
	
	public void setStudents(ArrayList<Student_Information> students) {
		Data_Information.students = students;
	}
	
	public void setCourses(ArrayList<String> course) {
		Data_Information.course = course;
	}
	
	//GETTERS:
	
	public static ArrayList<Student_Information> getStudents() {
		return students;
	}
	
	public static ArrayList<String> getCourses() {
		return course;
	}
	
}

