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
	JTextField dea_number;
	

	Doctor(){
//		String info[][] = {{p.getname(),p.getname()}};
		
		
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] col = {"First Name","Last Name","Dea Number"};
		Object[] row = new Object[3];
		
		model.setColumnIdentifiers(col);
		table.setModel(model);
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(table);
		
		
		
		
		f_name = new JTextField();
		f_name.setPreferredSize(new Dimension(150,30));
		l_name = new JTextField();
		l_name.setPreferredSize(new Dimension(150,30));
		dea_number = new JTextField();
		dea_number.setPreferredSize(new Dimension(150,30));
		
		addbtn = new JButton("add");
		addbtn.setFocusable(false);
		addbtn.setSize(20,20);
		
		
		
		
		addbtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = f_name.getText();
				row[1] = l_name.getText();
				row[2] = dea_number.getText();
				model.addRow(row);
				
				f_name.setText("");
				l_name.setText("");
				dea_number.setText("");
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

		
		JLabel first = new JLabel("First name");
		JLabel last = new JLabel("Last name");
		JLabel deanumber = new JLabel("DEA number");
		
		JPanel searchpanel = new JPanel(new GridLayout(4,1));
		searchpanel.add(first);
		searchpanel.add(f_name);
		searchpanel.add(last);
		searchpanel.add(l_name);
		searchpanel.add(deanumber);
		searchpanel.add(dea_number);
		searchpanel.add(searchbtn);
		searchpanel.add(addbtn);
//		searchpanel.setBackground(Color.red);

	
	
	
		
		JPanel bpanel = new JPanel(new GridLayout());
		bpanel.add(sc);
//		bpanel.setBackground(Color.blue);
		
		JLabel label = new JLabel("First name");
		
		
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
