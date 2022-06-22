package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JRadioButton r1, r2;
    JComboBox c1;
    JButton b1;

    AddEmployee(){
        JLabel name = new JLabel("Name");
        name.setBounds(60,30,100,30);
        name.setFont(new Font("Tahoma",Font.BOLD,17));
        add(name);

        t1 =new JTextField();
        t1.setBounds(200,30,150,30);
        t1.setFont(new Font("monospaced",Font.BOLD,17));
        add(t1);

        JLabel age = new JLabel("Age");
        age.setBounds(60,70,100,30);
        age.setFont(new Font("Tahoma",Font.BOLD,17));
        add(age);

        t2 =new JTextField();
        t2.setBounds(200,70,150,30);
        t2.setFont(new Font("monospaced",Font.BOLD,17));
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(60,110,100,30);
        gender.setFont(new Font("Tahoma",Font.BOLD,17));
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setBounds(200,110,60,30);
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(273,110,75,30);
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setBackground(Color.white);
        add(r2);

        JLabel job = new JLabel("Job");
        job.setBounds(60,150,100,30);
        job.setFont(new Font("Tahoma",Font.BOLD,17));
        add(job);

        JLabel sal = new JLabel("Salary");
        sal.setBounds(60,190,100,30);
        sal.setFont(new Font("Tahoma",Font.BOLD,17));
        add(sal);

        t3 =new JTextField();
        t3.setBounds(200,190,150,30);
        t3.setFont(new Font("monospaced",Font.BOLD,17));
        add(t3);

        String str[] = {"Front Desk Clerk","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1 =new JComboBox(str);
        c1.setBounds(200,150,150,30);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setBackground(Color.white);
        add(c1);

        JLabel ph = new JLabel("Phone");
        ph.setBounds(60,230,100,30);
        ph.setFont(new Font("Tahoma",Font.BOLD,17));
        add(ph);

        t5 =new JTextField();
        t5.setBounds(200,230,150,30);
        t5.setFont(new Font("monospaced",Font.BOLD,17));
        add(t5);

        JLabel adhar = new JLabel("Aadhar");
        adhar.setBounds(60,270,100,30);
        adhar.setFont(new Font("Tahoma",Font.BOLD,17));
        add(adhar);

        t6 =new JTextField();
        t6.setBounds(200,270,150,30);
        t6.setFont(new Font("monospaced",Font.BOLD,17));
        add(t6);

        JLabel email = new JLabel("Email");
        email.setBounds(60,310,100,30);
        email.setFont(new Font("Tahoma",Font.BOLD,17));
        add(email);

        t7 =new JTextField();
        t7.setBounds(200,310,150,30);
        t7.setFont(new Font("monospaced",Font.BOLD,17));
        add(t7);

        b1 = new JButton("Submit");
        b1.setBounds(200,350,150,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(330, 40,500,470);
        add(l1);

        JLabel l2 = new JLabel("Add Employee Details");
        l2.setForeground(Color.blue);
        l2.setBounds(400,0,400,60);
        l2.setFont(new Font("Serif",Font.ITALIC,40));
        add(l2);

        setLayout(null);
        setBounds(290,160,820,460);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
       new  AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = t1.getText();
        String age = t2.getText();
        String sal = t3.getText();
        String ph = t5.getText();
        String adhar = t6.getText();
        String email = t7.getText();

        String gender = null;

        if(r1.isSelected()){
            gender = "Male";
        }else if (r2.isSelected()){
            gender = "Female";
        }

        String job = (String)c1.getSelectedItem();
        Conn c = new Conn();
        String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+sal+"','"+ph+"','"+adhar+"','"+email+"')";
        try {
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
