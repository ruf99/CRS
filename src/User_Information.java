
public abstract class User_Information {
	
	User_Information() {
		
	}
	
	private String student_name;
	private String username;
	private String password;
	
	//GETTERS:
	
	public String getStudentName() {
		return student_name;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	//SETTERS:
	
	public void setStudentName(String sn) {
		this.student_name = sn;
	}
	
	public void setUsername(String un) {
		this.username = un;
	}
	
	public void setPassword(String p) {
		this.password = p;
	}
	
	
}
