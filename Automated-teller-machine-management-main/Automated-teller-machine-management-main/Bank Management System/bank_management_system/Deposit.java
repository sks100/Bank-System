package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit,back;
    String pin_number;

    Deposit(String pin_number){

        this.pin_number = pin_number;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/atm.jpg"));
        Image i2  = i1.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 700);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(170, 120, 600, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD  , 22));
        amount.setBounds(165, 170, 300, 30);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(335, 325, 150, 30);
        deposit.setFont(new Font("System", Font.BOLD, 14));
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(335, 360, 150, 30);
        back.setFont(new Font("System", Font.BOLD, 14));
        back.addActionListener(this);
        image.add(back);

        setSize(850, 700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            String value = amount.getText();
            double doubleValue = Double.parseDouble(value);
            String transaction_type = "Deposit";
            //Date date = new Date();

            try {
                if(value.equals("")){
                JOptionPane.showMessageDialog(null, "! Please enter the amount you want to deposit");
            }
            else{
                Conn conn = new Conn();
                String query = "INSERT INTO bank (pin_number, transaction_type, value, balance) " +
                                "VALUES ('" + pin_number + "', '" + transaction_type + "', " + doubleValue + ", " +
                                "IFNULL((SELECT balance FROM bank b1 WHERE b1.Transaction_id = " +
                                "(SELECT MAX(b2.Transaction_id) FROM bank b2 WHERE b2.pin_number = b1.pin_number) " +
                                "AND b1.pin_number = '" + pin_number + "'), 0) + " + doubleValue + ")";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+value+" Credited Successfully");
                setVisible(false);
                new Transaction(pin_number).setVisible(true);
            }
            } catch (Exception ae) {
                System.out.println(ae);
            }
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Transaction(pin_number).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
