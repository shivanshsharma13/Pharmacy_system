package pharmacy_system;

public class Drug {

//	Creating the properties for the class with the private attributes
	
	private String name;
	private String ndc_number;
	private String brand;

	
//	Using setters and getters for providing the value
	public void setname(String name) {
		this.name = name;
	}
	
	public String getname() {
		return this.name;
	}
	
	public void setndc(String ndc_number) {
		this.ndc_number = ndc_number;
	}
	
	public String getndc() {
		return this.ndc_number;
	}
	
	public void setbrand(String brand) {
		this.brand = brand;
	}
	
	public String getbrand() {
		return this.brand;
	}
	
}
