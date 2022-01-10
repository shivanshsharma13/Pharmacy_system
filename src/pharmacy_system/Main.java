package pharmacy_system;


import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
//		constructor 1
		
		Scanner sc = new Scanner(System.in);
		

		
//		Patient p = new Patient("Shivansh", "Sharma", "13/10/2000");
		
		
//		display the result
//		p.display();
		
		
//		Drug
		Drug d = new Drug();
		d.setname("Combiflame");
		d.setndc("23X4544ffg");
		
		System.out.println(d.getname());
		System.out.println(d.getndc());
		
//		p.setpatient("Shivansh", "sharma", "13/10/2000");
//		System.out.println(p.getpatient());
	}
	
}
