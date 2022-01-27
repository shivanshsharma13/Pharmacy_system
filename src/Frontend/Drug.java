package Frontend;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Drug extends JFrame{
	
	Drug(){

		JLabel label = new JLabel();
		label.setText("Welcome to drug page");
		label.setBounds(0,0,500,500);
		
		
		this.setVisible(true);
		this.setSize(600,420);
//		this.getContentPane().setBackground(new Color (0X123456));
		this.setTitle("Drug Page");
		this.setLayout(null);
		this.add(label);
		
		
		
		
	}
}
