package Frontend;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Drug extends JFrame{
	
	
	
	JButton searchbtn;
	JButton addbtn;
	JTextField name;
	JTextField ndc_number;
	JTextField brand;
	
	Drug(){

		JLabel label = new JLabel();
		label.setText("Welcome to drug page");
		label.setBounds(0,0,500,500);

		JTable logs = new JTable();
		
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] col = {"Drug name","ndc_number","brand"};
		Object[] row = new Object[4];
		
		model.setColumnIdentifiers(col);
		logs.setModel(model);
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(logs);
		
		
		JPanel logpanel = new JPanel(new GridLayout());
		logpanel.add(sc);
		

		
		
		
		name = new JTextField();
		name.setPreferredSize(new Dimension(150,30));
		ndc_number = new JTextField();
		ndc_number.setPreferredSize(new Dimension(150,30));
		brand = new JTextField();
		brand.setPreferredSize(new Dimension(150,30));
		
		addbtn = new JButton("add");
		addbtn.setFocusable(false);
		addbtn.setSize(20,20);
		
		
		
		
		addbtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = name.getText();
				row[1] = ndc_number.getText();
				row[2] = brand.getText();
				model.addRow(row);
				
				name.setText("");
				ndc_number.setText("");
				brand.setText("");
			}
		});
		
		searchbtn = new JButton("Search");
		searchbtn.setFocusable(false);
		searchbtn.setSize(20,20);
		
		
//		name.addKeyListener(new KeyListener() {
//			
//			@Override
//			pubndc_number void keyTyped(KeyEvent e) {
//				String str = name.getText();
//				TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
//				logs.setRowSorter(trs);
//				trs.setRowFilter(RowFilter.regexFilter(str));
//				
//			}
//			
//			@Override
//			pubndc_number void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			pubndc_number void keyPressed(KeyEvent e) {
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

		
		JLabel lname = new JLabel("Drug name");
		JLabel lndc_number = new JLabel("ndc_number");
		JLabel lbrand = new JLabel("brand");
		
		
		
		JPanel searchpanel = new JPanel(new GridLayout(5,1));
		searchpanel.add(lname);
		searchpanel.add(name);
		searchpanel.add(lndc_number);
		searchpanel.add(ndc_number);
		searchpanel.add(lbrand);
		searchpanel.add(brand);
		searchpanel.add(searchbtn);
		searchpanel.add(addbtn);
		
		this.setVisible(true);
		this.setSize(600,420);
//		this.getContentPane().setBackground(new Color (0X123456));
		this.setTitle("Drug Page");
		this.setLayout(new GridLayout(2,1));
		this.add(searchpanel);
		this.add(logpanel);
		
		
		
		
	}
}
