package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2;

    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;
    private ActionEvent e;

    Login() {
        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        l2.setFont(new Font("Serif", Font.BOLD, 18));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        t1.setFont(new Font("monospaced", Font.BOLD, 15));
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        t2.setFont(new Font("monospaced", Font.BOLD, 15));
        add(t2);

        b1 = new JButton("Login");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(40, 150, 120, 30);
        b1.setFont(new Font("Serif", Font.BOLD, 15));
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(180, 150, 120, 30);
        b2.setFont(new Font("Serif", Font.BOLD, 15));
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 0, 200, 200);
        add(l3);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(400, 200, 600, 250);
        setVisible(true);
    }


    public static void main(String args[]) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String username = t1.getText();
            String password = t2.getText();
            Conn c = new Conn();

            String str = "select * from login where username = '"+username+"' and password = '"+password+"'";

            try {
                ResultSet rs = c.s.executeQuery(str);
                if(rs.next()){
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username & Password");
                }

            } catch (Exception ex) {

            }

        }else if(e.getSource()==b2){
            System.exit(0);
        }
    }
}

