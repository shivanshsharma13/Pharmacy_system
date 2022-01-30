package Frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import pharmacy_system.Prescriber;

public class Doctor  extends JFrame{
	
	
	JButton searchbtn;
	JButton addbtn;
	JTextField f_name;
	JTextField l_name;
	
	
//	public ArrayList listdoc() {
//		
////		Already existing
//		p.setname("Shivanh", "SHarma");
//		list.add(p.getname());
//		p.setname("rahul", "raj");
//		list.add(p.getname());
//		
//		return list;
//	}
	
	
//	public void addrow() {
//		DefaultTableModel model = new DefaultTableModel();
//		ArrayList<String>list = listdoc();
//		Object raw[] = new Object[2];
//		for(int i=0;i<list.size();i++) {
//			raw[0] = list.get(i);
//			model.addRow(raw);
//		}
//	}
	

	Doctor(){

		ArrayList<Prescriber> list = new ArrayList<Prescriber>();
		Prescriber p1 = new Prescriber();
		p1.setname("Shivansh", "Sharma");
		Prescriber p2 = new Prescriber();
		Prescriber p3 = new Prescriber();
		Prescriber p4 = new Prescriber();
		
		
		
//		String info[][] = {{p.getname(),p.getname()}};
		
		
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] col = {"First Name","Last Name"};
		Object[] row = new Object[2];
		model.setColumnIdentifiers(col);
		table.setModel(model);
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(table);
		
		
		
		
		f_name = new JTextField();
		f_name.setPreferredSize(new Dimension(150,30));
		l_name = new JTextField();
		l_name.setPreferredSize(new Dimension(150,30));
		
		addbtn = new JButton("add");
		addbtn.setFocusable(false);
		addbtn.setSize(20,20);
		
		
		
		
		addbtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = f_name.getText();
				row[1] = l_name.getText();
				model.addRow(row);
				
				f_name.setText("");
				l_name.setText("");
			}
		});
		
		searchbtn = new JButton("Search");
		searchbtn.setFocusable(false);
		searchbtn.setSize(20,20);
		
		
		searchbtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = f_name.getText();
			
				TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(str));
	
			}
		});

		
		JPanel searchpanel = new JPanel(new GridLayout(4,1));
		searchpanel.add(f_name);
		searchpanel.add(l_name);
		searchpanel.add(searchbtn);
		searchpanel.add(addbtn);
//		searchpanel.setBackground(Color.red);

	
	
	
		
		JPanel bpanel = new JPanel();
		bpanel.add(sc);
//		bpanel.setBackground(Color.blue);
		

		
		
		
		
		
		
		JLabel label = new JLabel();
		label.setText("Welcome to doctor page");
		label.setBounds(0,0,500,500);
		
		
		this.setVisible(true);
		this.setSize(600,420);
//		this.getContentPane().setBackground(new Color (0X123456));
		this.setTitle("Doctor Page");
		this.setLayout(new GridLayout(3,1));
//		this.add(label);
		this.add(searchpanel);
		
		this.add(bpanel);
		
		
		
		
	}


}
