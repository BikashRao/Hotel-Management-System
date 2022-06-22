package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1,b2;

    CustomerInfo(){

            t1 = new JTable();
            t1.setBounds(0, 30, 1200, 400);
            //t1.setFont(new Font("Tahoma",Font.BOLD,11));
            add(t1);

            JLabel l1 = new JLabel("Document Type");
            l1.setBounds(20, 0, 120, 20);
            l1.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(l1);

            JLabel l2 = new JLabel("Number");
            l2.setBounds(200, 0, 70, 20);
            l2.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(l2);

            JLabel l3 = new JLabel("Name");
            l3.setBounds(350, 0, 70, 20);
            l3.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(l3);

            JLabel l4 = new JLabel("Gender");
            l4.setBounds(500, 0, 90, 20);
            l4.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(l4);

            JLabel l5 = new JLabel("Country");
            l5.setBounds(650, 0, 70, 20);
            l5.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(l5);

            JLabel l6 = new JLabel("Room No");
            l6.setBounds(790, 0, 70, 20);
            l6.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(l6);

            JLabel l7 = new JLabel("Check In");
            l7.setBounds(950, 0, 70, 20);
            l7.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(l7);

            JLabel l8 = new JLabel("Deposit");
            l8.setBounds(1100, 0, 70, 20);
            l8.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(l8);

            b1 = new JButton("Load Data");
            b1.setBackground(Color.black);
            b1.setForeground(Color.white);
            b1.setBounds(400, 460, 150, 30);
            b1.setFont(new Font("Tahoma", Font.BOLD, 15));
            b1.addActionListener(this);
            add(b1);

            b2 = new JButton("Back");
            b2.setBackground(Color.black);
            b2.setForeground(Color.white);
            b2.setBounds(650, 460, 150, 30);
            b2.setFont(new Font("Tahoma", Font.BOLD, 15));
            b2.addActionListener(this);
            add(b2);

            getContentPane().setBackground(Color.white);

            setLayout(null);
            setBounds(75, 150, 1218, 570);
            setVisible(true);

        }


    public static void main(String[] args) {
     new CustomerInfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1){
                    try {
                            Conn c = new Conn();
                            String str = "select * from customer ";
                            ResultSet rs = c.s.executeQuery(str);

                            t1.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch (Exception e1){

                    }
            }else if(e.getSource()==b2){
                    new Reception().setVisible(true);
                    this.setVisible(false);
            }

    }
}
