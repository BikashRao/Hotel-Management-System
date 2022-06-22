package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AddRooms extends JFrame implements ActionListener {

    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;

    AddRooms(){
        JLabel l1 = new JLabel("Add Rooms");
        l1.setBounds(140,15,150,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);

        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("Tahoma",Font.BOLD,15));
        room.setBounds(60,50,120,30);
        add(room);

        t1 = new JTextField();
        t1.setBounds(210,50,150,30);
        t1.setFont(new Font("Monospaced",Font.BOLD,16));
        add(t1);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.BOLD,15));
        available.setBounds(60,90,120,30);
        add(available);

        c1 = new JComboBox(new String[] {"Available","Occupied"});
        c1.setBounds(210,90,150,30);
        c1.setFont(new Font("Monospaced",Font.BOLD,16));
        c1.setBackground(Color.white);
        add(c1);

        JLabel clean = new JLabel("Cleaning Status");
        clean.setFont(new Font("Tahoma",Font.BOLD,15));
        clean.setBounds(60,130,120,30);
        add(clean);

        c2 = new JComboBox(new String[] {"Cleaned","Dirty"});
        c2.setBounds(210,130,150,30);
        c2.setFont(new Font("Monospaced",Font.BOLD,16));
        c2.setBackground(Color.white);
        add(c2);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.BOLD,15));
        price.setBounds(60,170,120,30);
        add(price);

        t2 = new JTextField();
        t2.setBounds(210,170,150,30);
        t2.setFont(new Font("Monospaced",Font.BOLD,16));
        add(t2);

        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma",Font.BOLD,15));
        type.setBounds(60,210,120,30);
        add(type);

        c3 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        c3.setBounds(210,210,150,30);
        c3.setBackground(Color.white);
        c3.setFont(new Font("Monospaced",Font.BOLD,16));
        add(c3);

        b1 = new JButton("Add Room");
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60,270,140,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setBounds(220,270,140,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/twelve.jpg"));
        JLabel l2 = new JLabel(i1);
        l2.setBounds(370,50,500,250);
        add(l2);

        setBounds(250,160,900,370);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){

            String room = t1.getText();
            String available = (String)c1.getSelectedItem();
            String status = (String) c2.getSelectedItem();
            String price = t2.getText();
            String type = (String) c3.getSelectedItem();

            Conn c = new Conn();
            try{
                String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added");
                this.setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }else if(e.getSource() == b2){
            this.setVisible(false);
        }
    }
}
