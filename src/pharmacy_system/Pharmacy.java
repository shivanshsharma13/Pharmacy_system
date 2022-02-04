package pharmacy_system;

public class Pharmacy {

	private int id;
	private String name;
	private int licence_number;
	private String chain_id;

	
	
//	Using setters and getters for providing the value


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLicence_number() {
		return licence_number;
	}

	public void setLicence_number(int licence_number) {
		this.licence_number = licence_number;
	}

	public String getChain_id() {
		return chain_id;
	}

	public void setChain_id(String chain_id) {
		this.chain_id = chain_id;
	}
}
