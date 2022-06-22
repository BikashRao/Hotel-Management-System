package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateRoom extends JFrame implements ActionListener{

    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;

    UpdateRoom(){
        JLabel l1 = new JLabel("Update Room Status");
        l1.setBounds(80,0,250,30);
        l1.setForeground(Color.blue);
        l1.setFont(new Font(Font.SERIF,Font.BOLD,27));
        add(l1);

        JLabel l2 = new JLabel("Guest ID");
        l2.setBounds(50,60,120,30);
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l2);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch (Exception e){}
        c1.setBounds(200,60,150,30);
        c1.setFont(new Font("Monospaced",Font.BOLD,15));
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(50,120,120,30);
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,120,150,30);
        t1.setFont(new Font("Monospaced",Font.BOLD,15));
        add(t1);

        JLabel l4 = new JLabel("Availability");
        l4.setBounds(50,180,120,30);
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,180,150,30);
        t2.setFont(new Font("Monospaced",Font.BOLD,15));
        add(t2);

        JLabel l5 = new JLabel("Clean Status");
        l5.setBounds(50,240,120,30);
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200,240,150,30);
        t3.setFont(new Font("Monospaced",Font.BOLD,15));
        add(t3);

        b1 = new JButton("Check");
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(125,300,150,30);
        b1.addActionListener( this);
        add(b1);

        b2 = new JButton("Update");
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(50,360,120,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setFont(new Font("Tahoma",Font.BOLD,15));
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(230,360,120,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(410,390,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(360,0,410,390);
        add(i4);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(300,150,800,453);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){

            String room = null;
            String s1 = c1.getSelectedItem();
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from customer where number ='"+s1+"'");
                while (rs.next()){
                    t1.setText(rs.getString("room"));
                    room = rs.getString("room");
                }

                ResultSet rs1 = c.s.executeQuery("select * from room where room_no = '"+room+"'");
                while(rs1.next()) {
                    t2.setText(rs1.getString("available"));
                    t3.setText(rs1.getString("status"));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }else if(e.getSource() == b2){
            try {
                Conn c = new Conn();
                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();

                String str = "update room set available = '"+available+"',status = '"+status+"' where room_no = '"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Room Updated Successfully");
                new Reception().setVisible(true);
                this.setVisible(false);

            }catch (Exception ex) {
                System.out.println(ex);
            }
        }else if(e.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
