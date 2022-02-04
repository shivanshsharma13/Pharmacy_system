package pharmacy_system;

import java.util.ArrayList;

public class Prescriber {

//	Creating the properties for the class with the private attributes
	private int id;
	private String first_name;
	private String last_name;
	private String DEA_number;
	
	
	
//	Using setters and getters for providing the value


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setfname(String first_name) {
		this.first_name = first_name;
	}

	public void setlname(String last_name){
		this.last_name = last_name;
	}
	
	public String getfname() {
		return this.first_name;
	}
	
	public String getlname() {
		return this.last_name;
	}
	
	
	public void setDEA(String DEA_number) {
		this.DEA_number = DEA_number;
	}
	
	public String getndc() {
		return this.DEA_number;
	}

	public void setname(ArrayList<String> fi_name, ArrayList<String> la_name) {
		// TODO Auto-generated method stub
		fi_name.add(this.first_name);
		la_name.add(this.last_name);
		
	}
	
}
