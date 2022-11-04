package application;

public class Customer {
private String name;
private String asuriteID;
private String password;


	public void setName(String name){
		this.name = name;
	}
	
	public void setAsuriteID(String asuriteID) {
		this.asuriteID = asuriteID;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAsuriteID() {
		return asuriteID;
	}
	public String getPassword() {
		return password;
	}
}
