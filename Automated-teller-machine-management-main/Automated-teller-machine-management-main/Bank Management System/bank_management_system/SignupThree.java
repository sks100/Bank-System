package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener{


    JRadioButton r1,r2,r3,r4;
    JCheckBox c1, c2, c3, c4, c5, c6,c7;
    JButton submit,cancel;
    long ran1,ran2;
    String formno;

    SignupThree(String formno){

        this.formno = formno;

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        setLayout(null);

        Random random = new Random();
        ran1 = Math.abs(random.nextLong() % 90000000L) + 4480604300000000L;
        ran2 = Math.abs(random.nextLong() % 9000L)+ 1000L;

        JLabel accountDetails = new JLabel("Page 3:  Account Deatils");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        accountDetails.setBounds(280, 40,  400, 30);
        add(accountDetails);

        JLabel AccountType = new JLabel("Account Type:");
        AccountType.setFont(new Font("Raleway", Font.BOLD, 20));
        AccountType.setBounds(150, 110,  200, 30);
        add(AccountType);

        r1 = new JRadioButton("Savings Account");
        r1.setBounds(320, 110, 160, 30);
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(500, 110, 200, 30);
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.white);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(320, 160, 160, 30);
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.white);
        add(r3);


        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(500, 160, 300, 30);
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNo.setBounds(150, 240,  200, 30);
        add(cardNo);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-1428");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(320, 240,  300, 30);
        add(number);

        JLabel carddetail = new JLabel("(Your 16 Digit Card Number)");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 14));
        carddetail.setBounds(560, 240,  200, 30);
        add(carddetail);

        JLabel PIN = new JLabel("PIN No:");
        PIN.setFont(new Font("Raleway", Font.BOLD, 20));
        PIN.setBounds(150, 300,  200, 30);
        add(PIN);

        
        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pinnumber.setBounds(320, 300,  200, 30);
        add(pinnumber);
        
        JLabel PINDetails = new JLabel("(Your 4 Digit PIN Number)");
        PINDetails.setFont(new Font("Raleway", Font.BOLD, 14));
        PINDetails.setBounds(560, 300,  200, 30);
        add(PINDetails);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(150, 370,  200, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(180, 420, 200, 30);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(400, 420, 200, 30);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.white);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(180, 460, 200, 30);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.white);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBounds(400, 460, 200, 30);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.white);
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setBounds(620, 420, 150, 30);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.white);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(620, 460, 200, 30);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.white);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBounds(150, 520, 550, 30);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.white);
        add(c7);


        submit = new JButton("Submit");
        submit.setBounds(300, 580, 100, 30);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 580, 100, 30);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.WHITE);

        setSize(880,700);
        setLocation(350, 10);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){ accountType = "Saving Account";}
            else if(r2.isSelected()){ accountType="Fixed Deposit Account";}
            else if(r3.isSelected()){ accountType="Current Account";}
            else if(r4.isSelected()){ accountType="Recurring Deposit Account";}

            String cardNumber = ""+ran1;
            String pinNumber = ""+ran2;

            String services ="";
            if(c1.isSelected()){ services += "ATM Card, ";}
            if(c2.isSelected()){ services += "Internet Banking, ";}
            if(c3.isSelected()){ services += "Mobile Banking, ";}
            if(c4.isSelected()){ services += "Email & SMS Alert, ";}
            if(c5.isSelected()){ services += "Check Book, ";}
            if(c6.isSelected()){ services += "E-Statement, ";}

            try {
                if(accountType.equals(""))
                    JOptionPane.showMessageDialog(null, " ! Select Account Type");
                else{
                    Conn c = new Conn();
                    String query = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+services+"')";
                    String query1 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);

                    JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber+"\n Pin Number: "+pinNumber);

                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }


    
}
