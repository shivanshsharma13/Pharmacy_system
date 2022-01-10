package pharmacy_system;

public class Prescriber {

//	Creating the properties for the class with the private attributes
	private String first_name;
	private String last_name;
	private String DEA_number;
	
	
//	Using setters and getters for providing the value
	public void setname(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public String getname() {
		return "Prescriber's name is " + this.first_name + " " + this.last_name;
	}
	
	public void setDEA(String DEA_number) {
		this.DEA_number = DEA_number;
	}
	
	public String getndc() {
		return "DEA number of the doctor is" + this.DEA_number;
	}
	
}
