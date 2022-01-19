package pharmacy_system;

public class Pharmacy {

	private String name;
	private int licence_number;
	private String address;
	private String contact_number;
	
	
//	Using setters and getters for providing the value
	public void setname(String name) {
		this.name = name;
	}
	
	public String getname() {
		return this.name;
	}
	
	public void setlicence(int licence_number) {
		this.licence_number = licence_number;
	}
	
	public String getndc() {
		return ""+this.licence_number;
	}
	
	public void setaddress(String address) {
		this.address = address;
	}
	
	public String getaddress() {
		return this.address;
	}
	
	public void setcontact(String contact_number) {
		this.contact_number = contact_number;
	}
	
	public String getcontact() {
		return this.contact_number;
	}
}
