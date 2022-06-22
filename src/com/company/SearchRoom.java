package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    SearchRoom(){

        JLabel l1 = new JLabel("Search for Room");
        l1.setFont(new Font("Serif",Font.BOLD,30));
        l1.setForeground(Color.blue);
        l1.setBounds(400,0,300,30);
        add(l1);

        JLabel l2 = new JLabel("Room Bed Type");
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        l2.setBounds(50,50,120,30);
        add(l2);

        c1 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        c1.setBounds(200,50,150,30);
        c1.setFont(new Font("Monospaced",Font.BOLD,16));
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JCheckBox("Only Display Available");
        c2.setBounds(700,50,250,30);
        c2.setFont(new Font("Tahoma",Font.BOLD,15));
        c2.setBackground(Color.white);
        add(c2);

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


        JLabel l3 = new JLabel("Room No");
        l3.setBounds(60, 120, 70, 20);
        l3.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l3);

        JLabel l4 = new JLabel("Available");
        l4.setBounds(260, 120, 70, 20);
        l4.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l4);

        JLabel l5 = new JLabel("Status");
        l5.setBounds(460, 120, 70, 20);
        l5.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setBounds(660, 120, 90, 20);
        l6.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l6);

        JLabel l7 = new JLabel("Bed Type");
        l7.setBounds(840, 120, 70, 20);
        l7.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l7);


        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(180,150,1000,550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try {
                String str = "select * from room where bed_type = '" + c1.getSelectedItem() + "'";
                String str1 = "select * from room where available = 'Available' AND bed_type = '" + c1.getSelectedItem() + "'";
                Conn c = new Conn();
                ResultSet rs;

                if (c2.isSelected()) {
                    rs = c.s.executeQuery(str1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }else{
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }catch (Exception ex){}
        }else if(e.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
