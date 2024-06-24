package bank_management_system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame{

    String pin_number;

    MiniStatement(String pin_number){
        
        setLayout(null);

        this.pin_number = pin_number;


        setTitle("Mini Statement");

        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(190, 20, 120, 20);
        bank.setFont(new Font("Raleway", Font.BOLD, 18));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(120, 80, 250, 20);
        card.setFont(new Font("Raleway", Font.BOLD, 14));
        add(card);

        JLabel text = new JLabel("     DATE & TIME     TRANS-TYPE    TRANSACTION      BALANCE");
        text.setBounds(20, 140, 520, 20); // Adjusted Y-coordinate
        text.setFont(new Font("Monospaced", Font.BOLD, 12));
        text.setFocusable(false);
        add(text);

        JTextArea mini = new JTextArea();
        mini.setBounds(20, 160, 520, 250); // Adjusted Y-coordinate
        mini.setFont(new Font("Monospaced", Font.BOLD, 12));
        mini.setEditable(false);
        add(mini);

        
        double bal =0;
        try {
            Conn conn = new Conn();
            String balanceQuery = "SELECT IFNULL(balance, 0) AS balance FROM bank WHERE pin_number = '"+pin_number+"' AND Transaction_id = (SELECT MAX(Transaction_id) FROM bank WHERE pin_number = '"+pin_number+"')";
            
            ResultSet rs = conn.s.executeQuery(balanceQuery);
            
            if (rs.next()) {
                String balc = rs.getString("balance");
                bal = Double.parseDouble(balc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel cuur = new JLabel("Your Current Account Balance"+" is Rs. "+ String.format("%.2f", bal));
        cuur.setFont(new Font("Raleway", Font.BOLD, 14));
        cuur.setBounds(50, 420, 400, 25);
        add(cuur);


        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE PIN_Number = '"+pin_number+"'");
            while(rs.next()){
                String set = "Card Number: "+rs.getString("Card_Number").substring(0, 4) + "XXXXXXXX" +rs.getString("Card_Number").substring(12) ;
                card.setText(set);
            }
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin_number = '"+pin_number+"'");
            while(rs.next()){
                String date = rs.getString("date").trim();
                String transactionType = rs.getString("transaction_type").trim();
                String value = rs.getString("value").trim();
                String balance = rs.getString("balance").trim();

                String formattedOutput = String.format("%-20s  %-15s%-15s%-15s\n", date, transactionType, value, balance);

                mini.append(formattedOutput);
            }
        } catch (Exception ee) {
            System.out.println(ee);
        }

        setSize(520, 500);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
