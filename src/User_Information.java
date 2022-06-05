import java.io.Serializable;

public class User_Information implements Serializable {

	private static final long serialVersionUID = 1L;
	private String first_Name;
	private String last_Name;
	private String username;
	private String password;
	
	public User_Information (String f_name, String l_name, String u_name, String pwrd) {
		first_Name = f_name;
		last_Name = l_name;
		password = pwrd;
	    username = u_name;
	 }
	
	
	//GETTERS:
	
	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getFirstName() { 
		return first_Name;
	}
	
	public String getLastName() { 
		return last_Name;
	}
	
	//SETTERS:
	
	public String setFirstName(String f_name) {
		String t = first_Name;
		first_Name = f_name;
		return t;
	}
	
	public String setLastName(String l_name) {
		String t = last_Name;
		last_Name = l_name;
		return t;
	}
	
	public String setUsername(String pwrd) {
		String t = password;
		password = pwrd;
		return t;
	}
	
	public String setStudentName(String u_name) {
		String t = username;
		username = u_name;
		return t;
	}

	
}