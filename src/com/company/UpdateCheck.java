package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

        JButton b1,b2,b3;
        Choice c1;
        JTextField t1,t2,t3,t4,t5;

        UpdateCheck(){

            JLabel l1 = new JLabel("Check-in Details");
            l1.setBounds(80,0,250,30);
            l1.setForeground(Color.blue);
            l1.setFont(new Font(Font.SERIF,Font.ITALIC,35));
            add(l1);

            JLabel l2 = new JLabel("Customer ID");
            l2.setBounds(50,60,120,30);
            l2.setFont(new Font("Tahoma",Font.BOLD,15));
            add(l2);

            c1 = new Choice();
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from customer");
                while(rs.next()){
                    c1.add(rs.getString("number"));
                }
            }catch (Exception e){}
            c1.setBounds(200,60,150,30);
            c1.setFont(new Font("Monospaced",Font.BOLD,15));
            add(c1);

            JLabel l3 = new JLabel("Room Number");
            l3.setBounds(50,100,120,30);
            l3.setFont(new Font("Tahoma",Font.BOLD,15));
            add(l3);

            t1 = new JTextField();
            t1.setBounds(200,100,150,30);
            t1.setFont(new Font("Monospaced",Font.BOLD,15));
            add(t1);

            JLabel l4 = new JLabel("Name");
            l4.setBounds(50,140,120,30);
            l4.setFont(new Font("Tahoma",Font.BOLD,15));
            add(l4);

            t2 = new JTextField();
            t2.setBounds(200,140,150,30);
            t2.setFont(new Font("Monospaced",Font.BOLD,15));
            add(t2);

            JLabel l5 = new JLabel("Check In");
            l5.setBounds(50,180,120,30);
            l5.setFont(new Font("Tahoma",Font.BOLD,15));
            add(l5);

            t3 = new JTextField();
            t3.setBounds(200,180,150,30);
            t3.setFont(new Font("Monospaced",Font.BOLD,15));
            add(t3);

            JLabel l6 = new JLabel("Amount Paid");
            l6.setBounds(50,220,120,30);
            l6.setFont(new Font("Tahoma",Font.BOLD,15));
            add(l6);

            t4 = new JTextField();
            t4.setBounds(200,220,150,30);
            t4.setFont(new Font("Monospaced",Font.BOLD,15));
            add(t4);

            JLabel l7 = new JLabel("Pending Amount");
            l7.setBounds(50,260,120,30);
            l7.setFont(new Font("Tahoma",Font.BOLD,15));
            add(l7);

            t5 = new JTextField();
            t5.setBounds(200,260,150,30);
            t5.setFont(new Font("Monospaced",Font.BOLD,15));
            add(t5);

            b1 = new JButton("Check");
            b1.setFont(new Font("Tahoma",Font.BOLD,15));
            b1.setBackground(Color.black);
            b1.setForeground(Color.white);
            b1.setBounds(125,320,150,30);
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

            getContentPane().setBackground(Color.white);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/nine.jpg"));
            Image i2 = i1.getImage().getScaledInstance(400,260,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel i4 = new JLabel(i3);
            i4.setBounds(365,45,400,260);
            add(i4);

            setLayout(null);
            setBounds(300,150,800,453);
            setVisible(true);
        }
    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1){
            String deposit = null;
            String room = null;
            int paid = 0;
            String price = null;
            String id = c1.getSelectedItem();
            try{
                Conn c = new Conn();
                String str = "select * from customer where number = '"+id+"'";
                ResultSet rs = c.s.executeQuery(str);

                while(rs.next()){
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    room = rs.getString("room");
                    deposit = rs.getString("deposit");
                }

                ResultSet rs1 = c.s.executeQuery("select * from room where room_no = '"+room+"'");
                while (rs1.next()){
                    price = rs1.getString("price");
                    paid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(paid));

                }

            }catch (Exception ex){}

        }else if(e.getSource() == b2){
            try{
                Conn c = new Conn();
                String room = t1.getText();
                String name = t2.getText();
                String check = t3.getText();
                String pending = t5.getText();
                String id = c1.getSelectedItem();
                String deposit = t4.getText();

                String str = "update customer set deposit = '"+deposit+"' where number = '"+id+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Check-In Updated Successfully");
                new Reception().setVisible(true);
                this.setVisible(false);

            }catch (Exception ex){}
        }else if(e.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
