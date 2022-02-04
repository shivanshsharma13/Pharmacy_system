package Frontend;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import pharmacy_system.Drugs;
import pharmacy_system.Pharmacy;

public class Stores extends JFrame{


	JButton searchbtn;
	JButton addbtn;
	JTextField id;
	JTextField storename;
	JTextField lic;
	JComboBox contact;

	//		DB stuff
	Connection c = null;
	Dbconn db = new Dbconn();

	public ArrayList<Pharmacy> Fetch() throws Exception{

		ArrayList<Pharmacy> d = new ArrayList<Pharmacy>();
		c = db.con();
		String query = "select s.id,s.store_name, c.chain_name, s.ncpdp_number from store s left JOIN chain c ON c.id = s.chain_id";
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(query);

		while(rs.next()){
			Pharmacy obj = new Pharmacy();
			obj.setId(rs.getInt(1));
			obj.setName(rs.getString(2));
			obj.setChain_id(rs.getString(3));
			obj.setLicence_number(rs.getInt(4));
			d.add(obj);
		}
		return d;
	}


	public ArrayList<String> chains() throws Exception{
		c = db.con();
		String query = "select chain_name from chain";
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> ch = new ArrayList<String>();
		while(rs.next()){
			ch.add(rs.getString(1));
		}
		return ch;
	}


	public int chain_ids(String ch) throws Exception{
		c = db.con();
		String query = "select id from chain where chain_name= " +'"'+ ch+'"';
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		int a = rs.getInt(1);
		return a;
	}


	public void fire(int id, String store_name, int chain_id, String ncpdp_number) throws Exception{
		c = db.con();
		String query = "insert into store values(?,?,?,?)";

		PreparedStatement st = c.prepareStatement(query);

		st.setInt(1,id);
		st.setString(2,store_name);
//		st.setInt(3,chain_id);
		st.setInt(3,chain_id);
		st.setString(4,ncpdp_number);
		st.executeUpdate();
		st.close();
		c.close();
	}
	
	


	
	
	Stores() throws Exception {

//		JLabel label = new JLabel();
//		label.setText("Welcome to Stores page");
//		label.setBounds(0,0,500,500);
		
		
		
		
//		
		
		JTable logs = new JTable();
		
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] col = {"Store id","Store name", "chain", "Licence number"};
		Object[] row = new Object[4];
		ArrayList<Pharmacy> ph = Fetch();

		model.setColumnIdentifiers(col);
		logs.setModel(model);
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(logs);
		
		
		JPanel logpanel = new JPanel(new GridLayout());
		logpanel.add(sc);


		ArrayList<String> chains = chains();

		id = new JTextField();
		id.setPreferredSize(new Dimension(150,30));
		storename = new JTextField();
		storename.setPreferredSize(new Dimension(150,30));
		lic = new JTextField();
		lic.setPreferredSize(new Dimension(150,30));
		contact = new JComboBox(chains.toArray());
		contact.setPreferredSize(new Dimension(150,30));



		addbtn = new JButton("add");
		addbtn.setFocusable(false);
		addbtn.setSize(20,20);
		
		
		
		
		addbtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = id.getText();
				row[1] = storename.getText();
				row[2] = contact.getSelectedItem().toString();
				row[3] = lic.getText();
				model.addRow(row);

				try {
					fire(Integer.parseInt(id.getText()),storename.getText(),chain_ids(contact.getSelectedItem().toString()),lic.getText());
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				id.setText("");
				storename.setText("");
				lic.setText("");


			}
		});
		
		searchbtn = new JButton("Search");
		searchbtn.setFocusable(false);
		searchbtn.setSize(20,20);

		for(int i=0;i<ph.size();i++){
			row[0] = ph.get(i).getId();
			row[1] = ph.get(i).getName();
			row[2] = ph.get(i).getChain_id();
			row[3] = ph.get(i).getLicence_number();
			model.addRow(row);
		}
		
		searchbtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = storename.getText();
				TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
				logs.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(str));
	
			}
		});

		
		JLabel ids = new JLabel("id");
		JLabel storenames = new JLabel("Store name");
		JLabel lics = new JLabel("Licence number");
		JLabel chs = new JLabel("Chain");
		
		
		
		JPanel searchpanel = new JPanel(new GridLayout(6,1));
		searchpanel.add(ids);
		searchpanel.add(id);
		searchpanel.add(storenames);
		searchpanel.add(storename);
		searchpanel.add(lics);
		searchpanel.add(lic);
		searchpanel.add(chs);
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
