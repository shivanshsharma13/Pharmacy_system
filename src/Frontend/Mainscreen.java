package Frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mainscreen implements ActionListener{

	JButton doc = new JButton("Doctor");
	JButton drug = new JButton("drug");
	JButton store = new JButton("store");
	
	
	public Mainscreen() {
		
		
		doc.setFocusable(false);
		doc.setBounds(0,50,100,30);
		doc.addActionListener(this);

		
		
		drug.setFocusable(false);
		drug.setBounds(0,150,100,30);
		drug.addActionListener(this);

		
		
		store.setFocusable(false);
		store.setBounds(0,254,100,30);
		store.addActionListener(this);

		
		JLabel label = new JLabel();
		label.setText("EPS System");
		label.setBounds(0, 0, 600, 400);
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		JFrame screen = new JFrame();
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
		screen.setSize(600,400);
		screen.setLayout(new GridLayout(4,1));
		screen.add(label);
		screen.add(doc);
		screen.add(drug);
		screen.add(store);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == doc) {
			
			Doctor d = new Doctor();
		}
		
		if(e.getSource() == drug) {
			Drug dr = new Drug();
		}
		
		if(e.getSource() == store) {
			Stores st = new Stores();
		}
		
	}
	
}
