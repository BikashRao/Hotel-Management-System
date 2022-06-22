package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dashboard extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    Dashboard(){

        mb = new JMenuBar();
        add(mb);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/third.jpg"));
        Image ic1 = ic.getImage().getScaledInstance(1370,700,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(ic1);
        JLabel l1 = new JLabel(ic2);
        l1.setBounds(0,0,1370,700);
        add(l1);

        m1 = new JMenu("HOTEL MANAGEMENT");
        mb.add(m1);
        m1.setForeground(Color.red);

        m2 = new JMenu("ADMIN");
        mb.add(m2);
        m2.setForeground(Color.blue);

        i1 = new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);

        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);

        i4 = new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);

        mb.setBounds(0,0,1370,20);

        JLabel l2 = new JLabel("THE TAJ GROUP WELCOMES YOU");
        l2.setBounds(270,60,1000,70);
        l2.setFont(new Font(Font.SERIF,Font.BOLD,50));
        l2.setForeground(Color.red);
        l1.add(l2);

        setLayout(null);
        setBounds(0,0,1370,800);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Dashboard();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("RECEPTION")) {
            new Reception().setVisible(true);
        } else if (e.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee().setVisible(true);
        } else if (e.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms().setVisible(true);
        } else if (e.getActionCommand().equals("ADD DRIVERS")) {
            new AddDrivers().setVisible(true);
        }
    }
}
