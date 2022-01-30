package Frontend;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import pharmacy_system.Pharmacy;

public class Stores extends JFrame{
	
	
	ArrayList<Pharmacy>Store_list;
	String header[] = new String[] {"Name", "Licence number", "address", "Contact number"};
	DefaultTableModel dtm;
	int row, col;
	
	
	JButton searchbtn;
	JButton addbtn;
	JTextField name;
	JTextField lic;
	JTextField add;
	JTextField contact;
	
	
	Stores(){

//		JLabel label = new JLabel();
//		label.setText("Welcome to Stores page");
//		label.setBounds(0,0,500,500);
		
		
		
		
//		
		
		JTable logs = new JTable();
		
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] col = {"Store Name","Licence Number", "Address","Contact number"};
		Object[] row = new Object[4];
		
		model.setColumnIdentifiers(col);
		logs.setModel(model);
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(logs);
		
		
		JPanel logpanel = new JPanel(new GridLayout());
		logpanel.add(sc);
		

		
		
		
		name = new JTextField();
		name.setPreferredSize(new Dimension(150,30));
		lic = new JTextField();
		lic.setPreferredSize(new Dimension(150,30));
		add = new JTextField();
		add.setPreferredSize(new Dimension(150,30));
		contact = new JTextField();
		contact.setPreferredSize(new Dimension(150,30));
		
		addbtn = new JButton("add");
		addbtn.setFocusable(false);
		addbtn.setSize(20,20);
		
		
		
		
		addbtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = name.getText();
				row[1] = lic.getText();
				row[2] = add.getText();
				row[3] = contact.getText();
				model.addRow(row);
				
				name.setText("");
				lic.setText("");
				add.setText("");
				contact.setText("");
			}
		});
		
		searchbtn = new JButton("Search");
		searchbtn.setFocusable(false);
		searchbtn.setSize(20,20);
		
		
//		name.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				String str = name.getText();
//				TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
//				logs.setRowSorter(trs);
//				trs.setRowFilter(RowFilter.regexFilter(str));
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		searchbtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = name.getText();
				TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
				logs.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(str));
	
			}
		});

		
		JLabel lname = new JLabel("Store name");
		JLabel llic = new JLabel("Licence number");
		JLabel ladd = new JLabel("address");
		JLabel lcontact = new JLabel("Contact");
		
		
		
		JPanel searchpanel = new JPanel(new GridLayout(5,1));
		searchpanel.add(lname);
		searchpanel.add(name);
		searchpanel.add(llic);
		searchpanel.add(lic);
		searchpanel.add(ladd);
		searchpanel.add(add);
		searchpanel.add(lcontact);
		searchpanel.add(contact);
		searchpanel.add(searchbtn);
		searchpanel.add(addbtn);

		
		
		
		
		
		this.setVisible(true);
		this.setSize(600,420);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.getContentPane().setBackground(new Color (0X123456));
		this.setTitle("Store Page");
		this.setLayout(new GridLayout(2,1));
		this.add(searchpanel);
		this.add(logpanel);
		
	}
}
