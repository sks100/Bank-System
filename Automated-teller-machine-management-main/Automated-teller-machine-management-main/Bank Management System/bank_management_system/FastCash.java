package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{

    JButton deposit,withdrawl,balance_enquiry,Exit,fastcash,miniState,pin;
    String pin_number;
    FastCash(String pin_number){

        setLayout(null);

        this.pin_number = pin_number;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/atm.jpg"));
        Image i2  = i1.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 700);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAW AMOUNT");
        text.setBounds(170, 120, 600, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Rs. 100");
        deposit.setBounds(150, 255, 150, 30);
        deposit.setFont(new Font("System", Font.BOLD, 14));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs. 500");
        withdrawl.setBounds(335, 255, 150, 30);
        withdrawl.setFont(new Font("System", Font.BOLD, 14));
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs. 1000");
        fastcash.setBounds(150, 290, 150, 30);
        fastcash.setFont(new Font("System", Font.BOLD, 14));
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniState = new JButton("Rs. 2000");
        miniState.setBounds(335, 290, 150, 30);
        miniState.setFont(new Font("System", Font.BOLD, 14));
        miniState.addActionListener(this);
        image.add(miniState);

        pin = new JButton("Rs. 5000");
        pin.setBounds(150, 325, 150, 30);
        pin.setFont(new Font("System", Font.BOLD, 14));
        pin.addActionListener(this);
        image.add(pin);

        balance_enquiry = new JButton("Rs. 10000");
        balance_enquiry.setBounds(335, 325, 150, 30);
        balance_enquiry.setFont(new Font("System", Font.BOLD, 14));
        balance_enquiry.addActionListener(this);
        image.add(balance_enquiry);

        Exit = new JButton("Back");
        Exit.setBounds(335, 360, 150, 30);
        Exit.setFont(new Font("System", Font.BOLD, 14));
        Exit.addActionListener(this);
        image.add(Exit);

        setSize(850, 700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Exit){
            setVisible(false);
            new Transaction(pin_number).setVisible(true);
        }
        else{
            String amount = ((JButton)e.getSource()).getText().substring(4);//Rs. 100
            double doubleValue = Double.parseDouble(amount);
            String transaction_type = "Withdraw";
            try {
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
                            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawn Successfully");
                            
                            setVisible(false);
                            new Transaction(pin_number).setVisible(true);
                        }
                    }
                    
                    balanceResult.close();
                    balanceStatement.close();
            } catch (Exception ee) {
                System.out.println(ee);
            }
        }

    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
