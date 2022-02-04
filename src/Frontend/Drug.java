package Frontend;

import pharmacy_system.Prescriber;
import pharmacy_system.Drugs;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Drug extends JFrame{

	JButton searchbtn;
	JButton addbtn;
	JTextField id;
	JTextField name;
	JTextField ndc_number;
	JTextField brand;


	//		DB stuff
	Connection c = null;
	Dbconn db = new Dbconn();

	public ArrayList<Drugs> Fetch() throws Exception{

		ArrayList<Drugs> d = new ArrayList<Drugs>();
		c = db.con();
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery("select * from drug");

		while(rs.next()){
			Drugs obj = new Drugs();
			obj.setid(rs.getInt(1));
			obj.setname(rs.getString(2));
			obj.setbrand(rs.getString(3));
			obj.setndc(rs.getString(4));
			d.add(obj);
		}
		return d;
	}

	public void fire(int id, String name, String brand, String ndc) throws Exception{
		c = db.con();
		String query = "insert into drug values(?,?,?,?)";

		PreparedStatement st = c.prepareStatement(query);
		st.setInt(1,id);
		st.setString(2,name);
		st.setString(3,brand);
		st.setString(4,ndc);
		st.executeUpdate();
		st.close();
		c.close();
	}




	Drug() throws Exception {

		JLabel label = new JLabel();
		label.setText("Welcome to drug page");
		label.setBounds(0,0,500,500);
		JButton drug_order = new JButton("Drug order");
		JButton update = new JButton("Update");
		JTable logs = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] col = {"id","Drug name","brand","NDC Number"};
		Object[] row = new Object[4];
		ArrayList<Drugs> d = Fetch();


		model.setColumnIdentifiers(col);
		logs.setModel(model);
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(logs);
		
		
		JPanel logpanel = new JPanel(new GridLayout(1,1));
		logpanel.add(sc);
		logpanel.setBorder(new EmptyBorder(10, 10, 10, 10));





		id = new JTextField();
		id.setPreferredSize(new Dimension(150,30));
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
				row[0] = Integer.parseInt(id.getText());
//				System.out.println(Integer.parseInt(id.getText()));
				row[1] = name.getText();
				row[2] = brand.getText();
				row[3] = ndc_number.getText();


				try {
					fire(Integer.parseInt(id.getText()),name.getText(),brand.getText(),ndc_number.getText());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				model.addRow(row);
				id.setText("");
				name.setText("");
				ndc_number.setText("");
				brand.setText("");
			}
		});
		
		searchbtn = new JButton("Search");
		searchbtn.setFocusable(false);
		searchbtn.setSize(20,20);
		
		searchbtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = name.getText();
				TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
				logs.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(str));
	
			}
		});


		JLabel ids = new JLabel("id");
		JLabel lname = new JLabel("Drug name");
		JLabel lndc_number = new JLabel("ndc_number");
		JLabel lbrand = new JLabel("brand");



		for(int i=0;i<d.size();i++){
			row[0] = d.get(i).getid();
			row[1] = d.get(i).getname();
			row[2] = d.get(i).getbrand();
			row[3] = d.get(i).getndc();
			model.addRow(row);
		}


		drug_order.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrugOrder d = new DrugOrder();
			}
		});



		
		JPanel searchpanel = new JPanel(new GridLayout(6,2));
		searchpanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		searchpanel.add(ids);
		searchpanel.add(id);
		searchpanel.add(lname);
		searchpanel.add(name);
		searchpanel.add(lbrand);
		searchpanel.add(brand);
		searchpanel.add(lndc_number);
		searchpanel.add(ndc_number);
		searchpanel.add(searchbtn);
		searchpanel.add(addbtn);
		searchpanel.add(update);
		searchpanel.add(drug_order);
		
		this.setVisible(true);
		this.setSize(600,420);
//		this.getContentPane().setBackground(new Color (0X123456));
		this.setTitle("Drug Page");
		this.setLayout(new GridLayout(2,1));
		this.add(searchpanel);
		this.add(logpanel);
		
		
		
	}
}
