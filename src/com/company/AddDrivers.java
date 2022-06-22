package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4;
    JComboBox c1,c2;
    JRadioButton r1,r2;
    JButton b1,b2;

    AddDrivers(){

        JLabel title = new JLabel("Add Drivers");
        title.setBounds(140,15,150,20);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        add(title);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.BOLD,15));
        name.setBounds(60,50,120,30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(210,50,150,30);
        t1.setFont(new Font("Monospaced",Font.BOLD,16));
        add(t1);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.BOLD,15));
        age.setBounds(60,90,120,30);
        add(age);

        c1 = new JComboBox(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100"});
        c1.setBounds(210,90,150,30);
        c1.setFont(new Font("Monospaced",Font.BOLD,16));
        c1.setBackground(Color.white);
        add(c1);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.BOLD,15));
        gender.setBounds(60,130,120,30);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setBounds(210,130,70,30);
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(285,130,75,30);
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setBackground(Color.white);
        add(r2);

        JLabel car = new JLabel("Car Company");
        car.setFont(new Font("Tahoma",Font.BOLD,15));
        car.setBounds(60,170,120,30);
        add(car);

        t2 = new JTextField();
        t2.setBounds(210,170,150,30);
        t2.setFont(new Font("Monospaced",Font.BOLD,16));
        add(t2);

        JLabel model = new JLabel("Car Model");
        model.setFont(new Font("Tahoma",Font.BOLD,15));
        model.setBounds(60,210,120,30);
        add(model);

        t3 = new JTextField();
        t3.setBounds(210,210,150,30);
        t3.setFont(new Font("Monospaced",Font.BOLD,16));
        add(t3);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.BOLD,15));
        available.setBounds(60,250,120,30);
        add(available);

        c2 = new JComboBox(new String[] {"Available","Busy"});
        c2.setBounds(210,250,150,30);
        c2.setFont(new Font("Monospaced",Font.BOLD,16));
        c2.setBackground(Color.white);
        add(c2);

        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.BOLD,15));
        location.setBounds(60,290,120,30);
        add(location);

        t4 = new JTextField();
        t4.setBounds(210,290,150,30);
        t4.setFont(new Font("Monospaced",Font.BOLD,16));
        add(t4);

        b1 = new JButton("Add Driver");
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60,350,140,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220,350,140,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(420,270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(370,50,420,270);
        add(l1);

        getContentPane().setBackground(Color.white);

        setBounds(290,160,820,450);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            String name = t1.getText();
            String age = (String)c1.getSelectedItem();
            String car = t2.getText();
            String model = t3.getText();
            String available = (String)c2.getSelectedItem();
            String location = t4.getText();

            String gender = null;
            if(r1.isSelected()){
                gender = "Male";
            }else if(r2.isSelected()){
                gender = "Female";
            }

            Conn c = new Conn();
            String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+available+"','"+location+"')";
            try {
                c.s.executeUpdate(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null,"Driver was successfully added!");
            this.setVisible(false);

        }else if(e.getSource() == b2){
            this.setVisible(false);
        }

    }
}
