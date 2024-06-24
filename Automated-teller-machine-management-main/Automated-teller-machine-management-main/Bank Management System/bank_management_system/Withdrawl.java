package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdrawl,back;
    String pin_number;

    Withdrawl(String pin_number){

        this.pin_number = pin_number;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/atm.jpg"));
        Image i2  = i1.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 700);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(170, 120, 600, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD  , 22));
        amount.setBounds(165, 170, 300, 30);
        image.add(amount);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(335, 325, 150, 30);
        withdrawl.setFont(new Font("System", Font.BOLD, 14));
        withdrawl.addActionListener(this);
        image.add(withdrawl);

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
        if(e.getSource() == withdrawl){
            String value = amount.getText();
            double doubleValue = Double.parseDouble(value);
            String transaction_type = "Withdraw";

            try {
                if (value.equals("")) {
                    JOptionPane.showMessageDialog(null, "! Please enter the amount you want to withdraw");
                } else {
                    Conn conn = new Conn();
                    
                    // Check if the withdrawal amount is valid (not greater than the balance)
                    String balanceQuery = "SELECT IFNULL(balance, 0) AS balance " +
                                        "FROM bank b1 " +
                                        "WHERE b1.Transaction_id = (SELECT MAX(b2.Transaction_id) FROM bank b2 WHERE b2.pin_number = b1.pin_number) " +
                                        "AND b1.pin_number = ?";
                    
                    PreparedStatement balanceStatement = conn.c.prepareStatement(balanceQuery);
                    balanceStatement.setString(1, pin_number);
                    
                    ResultSet balanceResult = balanceStatement.executeQuery();
                    
                    if (balanceResult.next()) {
                        double balance = balanceResult.getDouble("balance");
                        
                        if (doubleValue > balance) {
                            JOptionPane.showMessageDialog(null, "Insufficient balance. You cannot withdraw more than your balance.");
                            // You can choose to exit the transaction here or handle it accordingly.
                        } else {
                            // Proceed with the withdrawal
                            String query = "INSERT INTO bank (pin_number, transaction_type, value, balance) " +
                                        "VALUES ('" + pin_number + "', '" + transaction_type + "', " + doubleValue + ", " + (balance - doubleValue) + ")";
                            
                            conn.s.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Rs. " + value + " Withdrawn Successfully");
                            setVisible(false);
                            new Transaction(pin_number).setVisible(true);
                        }
                    }
                    
                    balanceResult.close();
                    balanceStatement.close();
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
        new Withdrawl("");
    }
}
