package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    JComboBox c1,c2;
    Choice c3;
    JRadioButton r1,r2;

    AddCustomer(){
        JLabel l1 = new JLabel("New Customer Form");
        l1.setBounds(150,0,300,30);
        l1.setFont(new Font("Serif",Font.BOLD,30));
        l1.setForeground(Color.blue);
        add(l1);

        JLabel l2 = new JLabel("ID");
        l2.setBounds(40,50,100,30);
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l2);

        c1 = new JComboBox(new String[]{"Passport","Voter ID","Driving Licence","Aadhar Card"});
        c1.setBounds(200,50,320,30);
        c1.setBackground(Color.white);
        c1.setFont(new Font("Monospaced",Font.BOLD,15));
        add(c1);

        JLabel l3 = new JLabel("Number");
        l3.setBounds(40,90,100,30);
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,90,320,30);
        t1.setFont(new Font("Monospaced",Font.BOLD,15));
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(40,130,100,30);
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,130,320,30);
        t2.setFont(new Font("Monospaced",Font.BOLD,15));
        add(t2);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(40,170,100,30);
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l5);

        r1 = new JRadioButton("Male");
        r1.setBounds(200,170,150,30);
        r1.setFont(new Font("Tahoma",Font.BOLD,15));
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(440,170,80,30);
        r2.setFont(new Font("Tahoma",Font.BOLD,15));
        r2.setBackground(Color.white);
        add(r2);

        JLabel l6 = new JLabel("Country");
        l6.setBounds(40,210,100,30);
        l6.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l6);

        c2 = new JComboBox(new String[]{"Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda","Argentina",
                "Armenia",
                "Australia",
                "Austria",
                "Azerbaijan",
                "Bahamas",
                "Bahrain",
                "Bangladesh",
                "Barbados",
                "Belarus",
                "Belgium",
                "Belize",
                "Benin",
                "Bhutan",
                "Bolivia",
                "Bosnia and Herzegovina",
                "Botswana",
                "Brazil",
                "Brunei",
                "Bulgaria",
                "Burkina Faso",
                "Burundi",
                "Cabo Verde",
                "Cambodia",
                "Cameroon",
                "Canada",
                "Central African Republic (CAR)",
                "Chad",
                "Chile",
                "China",
                "Colombia",
                "Comoros",
                "Congo",
                "Costa Rica",
                "Cote d'Ivoire",
                "Croatia",
                "Cuba",
                "Cyprus",
                "Czechia",
                "Denmark",
                "Djibouti",
                "Dominica",
                "Dominican Republic",
                "Ecuador",
                "Egypt",
                "El Salvador",
                "Equatorial Guinea",
                "Eritrea",
                "Estonia",
                "Eswatini",
                "Ethiopia",
                "Fiji",
                "Finland",
                "France",
                "Gabon",
                "Gambia",
                "Georgia",
                "Germany",
                "Ghana",
                "Greece",
                "Grenada",
                "Guatemala",
                "Guinea",
                "Guinea-Bissau",
                "Guyana",
                "Haiti",
                "Honduras",
                "Hungary",
                "Iceland",
                "India",
                "Indonesia",
                "Iran",
                "Iraq",
                "Ireland",
                "Israel",
                "Italy",
                "Jamaica",
                "Japan",
                "Jordan",
                "Kazakhstan",
                "Kenya",
                "Kiribati",
                "Kosovo",
                "Kuwait",
                "Kyrgyzstan",
                "Laos",
                "Latvia",
                "Lebanon",
                "Lesotho",
                "Liberia",
                "Libya",
                "Liechtenstein",
                "Lithuania",
                "Luxembourg",
                "Madagascar",
                "Malawi",
                "Malaysia",
                "Maldives",
                "Mali",
                "Malta",
                "Marshall Islands",
                "Mauritania",
                "Mauritius",
                "Mexico",
                "Micronesia",
                "Moldova",
                "Monaco",
                "Mongolia",
                "Montenegro",
                "Morocco",
                "Mozambique",
                "Myanmar",
                "Namibia",
                "Nauru",
                "Nepal",
                "Netherlands",
                "New Zealand",
                "Nicaragua",
                "Niger",
                "Nigeria",
                "North Korea",
                "North Macedonia",
                "Norway",
                "Oman",
                "Pakistan",
                "Palau",
                "Palestine",
                "Panama",
                "Papua New Guinea",
                "Paraguay",
                "Peru",
                "Philippines",
                "Poland",
                "Portugal",
                "Qatar",
                "Romania",
                "Russia",
                "Rwanda",
                "Saint Kitts and Nevis",
                "Saint Lucia",
                "Saint Vincent and the Grenadines",
                "Samoa",
                "San Marino",
                "Sao Tome and Principe",
                "Saudi Arabia",
                "Senegal",
                "Serbia",
                "Seychelles",
                "Sierra Leone",
                "Singapore",
                "Slovakia",
                "Slovenia",
                "Solomon Islands",
                "Somalia",
                "South Africa",
                "South Korea",
                "South Sudan",
                "Spain",
                "Sri Lanka",
                "Sudan",
                "Suriname",
                "Sweden",
                "Switzerland",
                "Syria",
                "Taiwan",
                "Tajikistan",
                "Tanzania",
                "Thailand",
                "Timor-Leste",
                "Togo",
                "Tonga",
                "Trinidad and Tobago",
                "Tunisia",
                "Turkey",
                "Turkmenistan",
                "Tuvalu",
                "Uganda",
                "Ukraine",
                "United Arab Emirates (UAE)",
                "United Kingdom (UK)",
                "United States of America (USA)",
                "Uruguay",
                "Uzbekistan",
                "Vanuatu",
                "Vatican City (Holy See)",
                "Venezuela",
                "Vietnam",
                "Yemen",
                "Zambia",
                "Zimbabwe"});
        c2.setBounds(200,210,320,30);
        c2.setBackground(Color.white);
        c2.setFont(new Font("Monospaced",Font.BOLD,15));
        add(c2);

        JLabel l7 = new JLabel("Room Number");
        l7.setBounds(40,250,150,30);
        l7.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l7);

        c3 = new Choice();
        try {
            Conn c = new Conn();
            String str = "select * from room";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()){
                c3.add(rs.getString("room_no"));
            }
        }catch (Exception e){}
        c3.setBounds(200,250,320,30);
        c3.setBackground(Color.white);
        c3.setFont(new Font("Monospaced",Font.BOLD,15));
        add(c3);

        JLabel l8 = new JLabel("Checked In");
        l8.setBounds(40,290,100,30);
        l8.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l8);

        t3 = new JTextField();
        t3.setBounds(200,290,320,30);
        t3.setBackground(Color.white);
        t3.setFont(new Font("Monospaced",Font.BOLD,15));
        add(t3);

        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(40,330,100,30);
        l9.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l9);

        t4 = new JTextField();
        t4.setBounds(200,330,320,30);
        t4.setBackground(Color.white);
        t4.setFont(new Font("Monospaced",Font.BOLD,15));
        add(t4);

        b1 = new JButton("Add Customer");
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60,400,200,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(300,400,200,30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(370,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(530,50,370,350);
        add(icon);

        setLayout(null);
        setBounds(230,150,930,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1){
            String id = (String) c1.getSelectedItem();
            String number = t1.getText();
            String name = t2.getText();
            String gender = null;
            if(r1.isSelected()){
                gender = "Male";
            }else if(r2.isSelected()){
                gender = "Female";
            }
            String country = (String)c2.getSelectedItem();
            String room = c3.getSelectedItem();
            String checkedin = t3.getText();
            String deposit = t4.getText();

            String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+checkedin+"','"+deposit+"')";
            String str1 = "update room set available = 'Occupied' where room_no ='"+room+"' ";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {}
        }else if(e.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
