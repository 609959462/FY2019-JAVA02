package nueedu;

public class User {
	
	public String username;
	public String password;
	public String name;
	public String email;
	public User() {};
	public User(String username,String password,String name,String email) {
		this.username=username;
		this.password=password;
		this.name=name;
		this.email=email;
	};                  
	
	public String getUsername() {      
		return username;
	}
	public String getPassword() {      
		return password;
	}
	public String getName() {      
		return name;
	}
	public String getEmail() {      
		return email;
	}
	public void setUsername(String username) {      
		this.username=username;
	}
	public void setPassword(String password) {      
		this.password=password;
	}
	public void setName(String name) {      
		this.name=name;
	}
	public void setEmail(String email) {      
		this.email=email;
	}
	User a1=new User("admin","admin","name"," admin@123.com");
	User a2=new User("tom","cat","tomcat","tomcat@cat.com");
	User[] a=new User[] {a1,a2};
	

	 }
