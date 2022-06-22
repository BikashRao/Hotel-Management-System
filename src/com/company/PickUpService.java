package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUpService extends JFrame implements ActionListener {

    Choice c1;
    JButton b1,b2;
    JTable t1;
    PickUpService(){

        JLabel l1 = new JLabel("Pickup Service");
        l1.setFont(new Font("Serif",Font.BOLD,30));
        l1.setForeground(Color.blue);
        l1.setBounds(400,0,300,30);
        add(l1);

        JLabel l2 = new JLabel("Type of Car");
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        l2.setBounds(50,50,120,30);
        add(l2);

        c1 = new Choice();
        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()){
                c1.add(rs.getString("model"));
            }

        }catch (Exception e){}
        c1.setBounds(200,50,150,30);
        c1.setFont(new Font("Monospaced",Font.BOLD,16));
        c1.setBackground(Color.white);
        add(c1);

        t1 = new JTable();
        t1.setFont(new Font("Monospaced",Font.BOLD,15));
        t1.setBounds(0,150,985,250);
        add(t1);

        b1 = new JButton("Submit");
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(100,440,150,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(750,440,150,30);
        b2.addActionListener(this);
        add(b2);


        JLabel l3 = new JLabel("Name");
        l3.setBounds(50, 120, 70, 20);
        l3.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l3);

        JLabel l4 = new JLabel("Age");
        l4.setBounds(200, 120, 70, 20);
        l4.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l4);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(330, 120, 70, 20);
        l5.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l5);

        JLabel l6 = new JLabel("Car");
        l6.setBounds(480, 120, 90, 20);
        l6.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l6);

        JLabel l7 = new JLabel("Model");
        l7.setBounds(610, 120, 70, 20);
        l7.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l7);

        JLabel l8 = new JLabel("Availability");
        l8.setBounds(730, 120, 120, 20);
        l8.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l8);

        JLabel l9 = new JLabel("Location");
        l9.setBounds(880, 120, 70, 20);
        l9.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l9);


        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(180,150,1000,550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PickUpService().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try {
                String str = "select * from driver where model = '" + c1.getSelectedItem() + "'";
                Conn c = new Conn();
                ResultSet rs;
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception ex){}
        }else if(e.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
