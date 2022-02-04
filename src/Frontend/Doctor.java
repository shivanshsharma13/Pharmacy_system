package Frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import pharmacy_system.Prescriber;

public class Doctor  extends JFrame{
	
	
	JButton searchbtn;
	JButton addbtn;
	JTextField id;
	JTextField f_name;
	JTextField l_name;
	JTextField dea_number;




	//		DB stuff
	Connection c = null;
	Dbconn db = new Dbconn();

	public ArrayList<Prescriber> Fetch() throws Exception{

		ArrayList<Prescriber> p = new ArrayList<Prescriber>();
		c = db.con();
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery("select * from prescriber");

		while(rs.next()){
			Prescriber obj = new Prescriber();
			obj.setId(rs.getInt(1));
			obj.setfname(rs.getString(2));
			obj.setlname(rs.getString(3));
			obj.setDEA(rs.getString(4));
			p.add(obj);
		}
		return p;
	}

	public void fire(int id, String fname, String lname, String deanumber) throws Exception{
		c = db.con();
		String query = "insert into prescriber values(?,?,?,?)";

		PreparedStatement st = c.prepareStatement(query);
		st.setInt(1,id);
		st.setString(2,fname);
		st.setString(3,lname);
		st.setString(4,deanumber);
		st.executeUpdate();
		st.close();
		c.close();
	}


	public Doctor() throws Exception {
		
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] col = {"Prescriber id","First Name","Last Name","Dea Number"};
		Object[] row = new Object[4];
		ArrayList<Prescriber> pre = Fetch();

		model.setColumnIdentifiers(col);
		table.setModel(model);
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(table);



		id = new JTextField();
		id.setPreferredSize(new Dimension(150,30));
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
				row[0] = Integer.parseInt(id.getText());
				row[1] = f_name.getText();
				row[2] = l_name.getText();
				row[3] = dea_number.getText();
				model.addRow(row);

				try {
					fire(Integer.parseInt(id.getText()),f_name.getText(),l_name.getText(),dea_number.getText());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				id.setText("");
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

		for(int i=0;i<pre.size();i++){
			row[0] = pre.get(i).getId();
			row[1] = pre.get(i).getfname();
			row[2] = pre.get(i).getlname();
			row[3] = pre.get(i).getndc();
			model.addRow(row);
		}

		JLabel ids = new JLabel("Prescriber ID");
		JLabel first = new JLabel("First name");
		JLabel last = new JLabel("Last name");
		JLabel deanumber = new JLabel("DEA number");

		JPanel searchpanel = new JPanel(new GridLayout(5,1));
		searchpanel.setBorder(new EmptyBorder(10, 10, 10,10));
		searchpanel.add(ids);
		searchpanel.add(id);
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
		bpanel.setBorder(new EmptyBorder(10, 10, 10,10));
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
