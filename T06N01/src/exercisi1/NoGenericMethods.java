package exercisi1;

public class NoGenericMethods {
	private String name;
	private String lastName;
	private String gender;
	
	public NoGenericMethods(String name, String lastName, String gender) {
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
