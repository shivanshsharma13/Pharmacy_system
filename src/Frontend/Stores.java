package Frontend;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import pharmacy_system.Pharmacy;

public class Stores extends JFrame{
	
	
	ArrayList<Pharmacy>Store_list;
	String header[] = new String[] {"Name", "Licence number", "address", "Contact number"};
	DefaultTableModel dtm;
	int row, col;
	
	
	Stores(){

		JLabel label = new JLabel();
		label.setText("Welcome to Stores page");
		label.setBounds(0,0,500,500);
		
		
		this.setVisible(true);
		this.setSize(600,420);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.getContentPane().setBackground(new Color (0X123456));
		this.setTitle("Store Page");
		this.setLayout(null);
		this.add(label);
		
		
		
		
	}
}
