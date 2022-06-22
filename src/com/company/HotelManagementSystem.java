package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
        setBounds(0,85,1366,603);
        //setSize() & setLocation() instead of setBounds();
        //setSize(400,400); size of frame
        //setLocation(300,300); where to view the frame

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1366,565);
        add(l1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(20,471,1000,90);
        l2.setForeground(Color.white);
        l2.setFont(new Font("serif",Font.BOLD,70));
        l1.add(l2);

        JButton b1 = new JButton("Next");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(1150, 502,150,43);
        b1.setFont(new Font("serif",Font.BOLD,35));
        b1.addActionListener(this);
        l1.add(b1);

        setLayout(null);
        setVisible(true); // this method was false as default

        while (true){
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e){}
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){}
        }
    }

    public static void main(String[] args) {
	// write your code here
        new HotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Login().setVisible(true);
        this.setVisible(false);
    }
}
