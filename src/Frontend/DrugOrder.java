package Frontend;

import pharmacy_system.Drugs;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DrugOrder extends JFrame {

    JLabel drugname_label = new JLabel("Drugname");
    JTextField drugname;
    JLabel qty_label = new JLabel("Quantity");
    JTextField qty;
    JButton order;



    JPanel search = new JPanel(new GridLayout(3,1,10,10));
    JPanel logpanel = new JPanel(new GridLayout(1,1));


    DrugOrder(){

        JTable logs = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] col = {"Drug name","Time","Date","Quantity","Status"};
        Object[] row = new Object[5];

        model.setColumnIdentifiers(col);
        logs.setModel(model);
        JScrollPane sc = new JScrollPane();
        sc.setViewportView(logs);






        drugname = new JTextField();
        drugname.setPreferredSize(new Dimension(150,30));
        qty = new JTextField();
        qty.setPreferredSize(new Dimension(150,30));
        order = new JButton("Order Drug");

        Date dNow = new Date( );
        SimpleDateFormat day = new SimpleDateFormat ("E, yyyy.MM.dd");
        SimpleDateFormat time = new SimpleDateFormat ("hh:mm:ss a");



        order.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                Thread t = new Thread();
                t.start();
                row[0] = drugname.getText();
                row[1] = time.format(dNow);
                row[2] = day.format(dNow);
                row[3] = qty.getText();
                row[4] = "✔️";
                model.addRow(row);

                drugname.setText("");
                qty.setText("");

            }
        });


        search.add(drugname_label);
        search.add(drugname);
        search.add(qty_label);
        search.add(qty);
        search.add(order);

        logpanel.add(sc);
        logpanel.setBorder(new EmptyBorder(10, 10, 10, 10));



        this.setVisible(true);
        this.setSize(600,420);
        this.setTitle("Order Drug");
        this.setLayout(new GridLayout(2,1));
        this.add(search);
        this.add(logpanel);

    }



}
