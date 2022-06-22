package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {

    JButton b1,b2,b3;
    JTextField t1;
    Choice c1 = new Choice();
    CheckOut(){
        JLabel l1 = new JLabel("Check Out");
        l1.setBounds(115,0,300,30);
        l1.setForeground(Color.blue);
        l1.setFont(new Font(Font.SERIF,Font.BOLD,30));
        add(l1);

        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(40,50,120,30);
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
        c1.setBounds(190,50,150,30);
        c1.setFont(new Font("Monospaced",Font.BOLD,15));
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(40,90,120,30);
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l3);

        t1 = new JTextField();
        t1.setBounds(190,90,150,30);
        t1.setFont(new Font("Monospaced",Font.BOLD,15));
        add(t1);

        b1 = new JButton("Check Out");
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(40,150,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220,150,120,30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,25,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(350,50,20,25);
        b3.addActionListener(this);
        add(b3);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/sixth.jpg"));
        Image i4 = icon.getImage().getScaledInstance(395,180,Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(i4);
        JLabel i6 = new JLabel(i5);
        i6.setBounds(380,0,395,180);
        add(i6);

        setLayout(null);
        setBounds(300,155,800,240);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1){

            String id = c1.getSelectedItem();
            String room = t1.getText();
            Conn c = new Conn();
            String str = "delete from customer where number = '"+id+"'";
            String str1 = "update room set available = 'Available' where room_no = '"+room+"'";
            try{

                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Check Out Done");
                new Reception().setVisible(true);
                this.setVisible(false);

            }catch (Exception e1){}

        }else if (e.getSource() == b2){

            new Reception().setVisible(true);
            this.setVisible(false);

        }else if(e.getSource() == b3){

            Conn c = new Conn();
            String id = c1.getSelectedItem();
            try{

                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
                while (rs.next()){
                    t1.setText(rs.getString("room"));
                }
            }catch (Exception ex){}
        }
    }
}
