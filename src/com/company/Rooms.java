package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Rooms extends JFrame implements ActionListener {

    JTable t1;
    JButton b1,b2;

    Rooms() {
        t1 = new JTable();
        t1.setBounds(0, 30, 800, 400);
        t1.setFont(new Font("Monospaced",Font.BOLD,15));
        add(t1);

        JLabel l1 = new JLabel("Room No");
        l1.setBounds(40, 0, 70, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l1);

        JLabel l2 = new JLabel("Available");
        l2.setBounds(210, 0, 70, 20);
        l2.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(380, 0, 70, 20);
        l3.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(540, 0, 90, 20);
        l4.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(690, 0, 70, 20);
        l5.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l5);

        b1 = new JButton("Load Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(250, 460, 120, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(430, 460, 120, 30);
        b2.setFont(new Font("Tahoma", Font.BOLD, 15));
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(380,510,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(810,0,380,510);
        add(l6);

        setLayout(null);
        setBounds(75, 150, 1218, 570);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Rooms().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try {
                Conn c = new Conn();
                String str = "select * from room";
                ResultSet rs = c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception ex){
                System.out.println(ex);
            }

        }else if(e.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
