package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {

    JButton b1,b2;
    JTable t1;
    Department(){

        t1 = new JTable();
        t1.setFont(new Font("Monospaced",Font.BOLD,15));
        t1.setBounds(0,40,482,380);
        add(t1);

        b1 = new JButton("Submit");
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(50,440,150,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(290,440,150,30);
        b2.addActionListener(this);
        add(b2);


        JLabel l3 = new JLabel("Department");
        l3.setBounds(80, 0, 100, 20);
        l3.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l3);

        JLabel l4 = new JLabel("Budget");
        l4.setBounds(330, 0, 70, 20);
        l4.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l4);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(450,150,500,550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try {
                String str = "select * from department";
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
