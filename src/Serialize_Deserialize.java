
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Serialize_Deserialize implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//SERIALIZE COURSES: 
	public static void serializeCourses() throws IOException {
		
		ArrayList<Course_Information> serializedCourses = Main_Execute.courses;
		
		try {
			FileOutputStream fileOutS = new FileOutputStream("Courses.ser");
			ObjectOutputStream objOutS = new ObjectOutputStream(fileOutS);
			
			objOutS.writeObject(serializedCourses);
			objOutS.close();
			fileOutS.close();
			//System.out.println("You have successfully completed the Course Serialization process!");
		}
		
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deSerializeCourses() {
		//DESERIALIZE COURSES
		
		ArrayList<Course_Information> deserialized_Courses = new ArrayList<Course_Information>();
		
		try {
			FileInputStream fileInS = new FileInputStream("Courses.ser");
			ObjectInputStream objInS = new ObjectInputStream(fileInS);
			
			deserialized_Courses = (ArrayList<Course_Information>)objInS.readObject();
			objInS.close();
			fileInS.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			return;
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return;
		}
		
	}
	
	public static void serializeStudents() {
		
		//SERIALIZE STUDENTS
		ArrayList<Student_Information> serialized_Students = Data_Information.students;
		
		try {
			
			FileOutputStream fileOutputS = new FileOutputStream("Students.ser");
			ObjectOutputStream objOutputS = new ObjectOutputStream(fileOutputS);
			
			
			objOutputS.writeObject(serialized_Students);
			objOutputS.close();
			fileOutputS.close();
			
			//System.out.println("You have successfully completed the Student Serialization process!");
			
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//DE-SERIALIZE STUDENTS:

		public static void deSerializeStudents() {
			ArrayList<Student_Information> deserialized_Students = Data_Information.students;
			
			try {
				FileInputStream fileInputS = new FileInputStream("Students.ser");
				ObjectInputStream objInputS = new ObjectInputStream(fileInputS);
				deserialized_Students = (ArrayList<Student_Information>)objInputS.readObject();
				objInputS.close();
				fileInputS.close();
			}
			catch (IOException e) {
				e.printStackTrace();
				return;
			}
			catch(ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
				return;
			}

		}
}
