package bank_management_system;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    String pin_number;
    JButton back;

    BalanceEnquiry(String pin_number){
        setLayout(null);

        this.pin_number = pin_number;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/atm.jpg"));
        Image i2  = i1.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 700);
        add(image);

        back = new JButton("Back");
        back.setBounds(335, 360, 150, 30);
        back.setFont(new Font("System", Font.BOLD, 14));
        back.addActionListener(this);
        image.add(back);

        Conn conn = new Conn();
        double balance =0;
        try {
            String balanceQuery = "SELECT IFNULL(balance, 0) AS balance FROM bank WHERE pin_number = '"+pin_number+"' AND Transaction_id = (SELECT MAX(Transaction_id) FROM bank WHERE pin_number = '"+pin_number+"')";
            
            ResultSet rs = conn.s.executeQuery(balanceQuery);
            
            if (rs.next()) {
                String bal = rs.getString("balance");
                balance = Double.parseDouble(bal);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        text.setBounds(180, 200, 400, 25);
        image.add(text);
        JLabel text2 = new JLabel(" is Rs. "+ String.format("%.2f", balance));
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("Raleway", Font.BOLD, 20));
        text2.setBounds(250, 230, 400, 25);
        image.add(text2);

        setSize(850, 700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pin_number).setVisible(true);
        
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
    
}
