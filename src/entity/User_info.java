package entity;

public class User_info {



	private String user_id;
	private String user_name;
	private String telepone;
	private String password;

	public User_info() {
	}

	public User_info(String user_id,String user_name,String telepone ,String password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.telepone = telepone;
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTelepone() {
		return telepone;
	}

	public void setTelepone(String telepone) {
		this.telepone = telepone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}






}