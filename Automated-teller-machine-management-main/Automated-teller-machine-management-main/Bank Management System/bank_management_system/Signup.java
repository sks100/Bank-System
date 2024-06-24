package bank_management_system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener{

    JTextField nameTextField,addressTextField,fnameTextField,emailTextField,pincodeTextField,cityTextField,stateTextField;
    JDateChooser dateChooser;
    JRadioButton maleButton, femaleButton,otherButton,married, unmarried,other;
    JButton next;
    long random;

    Signup(){

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");

        setLayout(null);

        Random ran = new Random();
        random =  Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FROM NO. " +random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20,  600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1:  Personal Deatils");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        personalDetails.setBounds(280, 80,  400, 30);
        add(personalDetails);

        JLabel Name = new JLabel("Name:");
        Name.setFont(new Font("Raleway", Font.BOLD, 20));
        Name.setBounds(100, 140,  200, 30);
        add(Name);

        nameTextField = new JTextField();
        nameTextField.setBounds(320, 141,  300, 30);
        nameTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(nameTextField);

        JLabel F_name = new JLabel("Father's Name:");
        F_name.setFont(new Font("Raleway", Font.BOLD, 20));
        F_name.setBounds(100, 190,  200, 30);
        add(F_name);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(320, 191,  300, 30);
        fnameTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240,  200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(320, 241, 300, 30);
        dateChooser.setFont(new Font("Arial", Font.BOLD, 14));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290,  200, 30);
        add(gender);

        maleButton = new JRadioButton("Male");
        maleButton.setBounds(320, 290, 100, 30);
        maleButton.setBackground(Color.white);
        add(maleButton);
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(440, 290, 100, 30);
        femaleButton.setBackground(Color.white);
        add(femaleButton);
        otherButton = new JRadioButton("Others");
        otherButton.setBounds(560, 290, 100, 30);
        otherButton.setBackground(Color.white);
        add(otherButton);

        ButtonGroup gender_Group = new ButtonGroup();
        gender_Group.add(maleButton);
        gender_Group.add(femaleButton);
        gender_Group.add(otherButton);

        JLabel email = new JLabel("Email address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340,  200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(320, 341,  300, 30);
        emailTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390,  200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(320, 390, 100, 30);
        married.setBackground(Color.white);
        add(married);
        unmarried = new JRadioButton("Un-married");
        unmarried.setBounds(440, 390, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(560, 390, 100, 30);
        other.setBackground(Color.white);
        add(other);
        

        ButtonGroup marital_Group = new ButtonGroup();
        marital_Group.add(married);
        marital_Group.add(unmarried);
        marital_Group.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440,  200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setBounds(320, 441,  300, 30);
        addressTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(addressTextField);

        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490,  200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(320, 491,  300, 30);
        cityTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cityTextField);

        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540,  200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(320, 541,  300, 30);
        stateTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(stateTextField);

        JLabel pincode = new JLabel("Pincode");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590,  200, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(320, 591,  300, 30);
        pincodeTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pincodeTextField);

        next = new JButton("Next >> ");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBounds(650, 630, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,730);
        setLocation(350, 10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       String formno = ""+random;
       String name = nameTextField.getText();
       String fname = fnameTextField.getText();
       String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
       String gender = null;
       if(maleButton.isSelected()){
        gender = "Male";
       }
       else if(femaleButton.isSelected()){
        gender = "Female";
       }
       else if(otherButton.isSelected()){
        gender = "Others";
       }

       String email = emailTextField.getText();
       String marital = null;
       if(married.isSelected()){
        marital = "Married";
       }
       else if(unmarried.isSelected()){
        marital = "Un-Married";
       }
       else if(other.isSelected()){
        marital = "Other";
       }
       String address = addressTextField.getText();
       String city = cityTextField.getText();
       String state = stateTextField.getText();
       String pincode = pincodeTextField.getText();

       try {
        if(name.equals("") || fname.equals("") || dob.equals("") || gender.equals("") || email.equals("") || marital.equals("") || address.equals("") || city.equals("") || state.equals("") || pincode.equals(""))
            JOptionPane.showMessageDialog(null, " ! All Credentials Required");
        else{
            Conn c = new Conn();
            String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
            c.s.executeUpdate(query);

            //signup two object
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
        }
       } catch (Exception ee) {
        System.out.println(ee);
       }

    }
    public static void main(String[] args) {
        new Signup();
    }
}
