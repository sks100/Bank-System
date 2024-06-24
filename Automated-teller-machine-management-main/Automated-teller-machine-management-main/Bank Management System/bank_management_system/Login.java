package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, Reset, sign_up;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){

        setTitle("Automated Teller Machine");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/logo.jpg"));
        Image i2  = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to Indian Bank");
        text.setFont(new Font("Oswald", Font.BOLD, 38));
        text.setBounds(200, 40, 500, 40);
        add(text);

        JLabel cardno = new JLabel("Card Number :");
        cardno.setFont(new Font("Raleway", Font.BOLD, 24));
        cardno.setBounds(120, 150, 180, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(310 , 151 , 240, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        pin.setBounds(120, 220, 500, 30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(310 , 221 , 240, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(320, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        Reset = new JButton("RESET");
        Reset.setBounds(440, 300, 100, 30);
        Reset.setBackground(Color.BLACK);
        Reset.setForeground(Color.WHITE);
        Reset.addActionListener(this);
        add(Reset);

        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(320, 350, 220, 30);
        sign_up.setBackground(Color.BLACK);
        sign_up.setForeground(Color.WHITE);
        sign_up.addActionListener(this);
        add(sign_up);

        getContentPane().setBackground(Color.WHITE);


        setSize(800, 480);
        setVisible(true);
        setLocation(250, 150);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Reset){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(e.getSource() == login){
            Conn conn = new Conn();
            String card_number = cardTextField.getText();
            char[] passwordChar = pinTextField.getPassword();
            String pin_number = new String(passwordChar);
            String query = "select * from login where Card_Number = '"+card_number+"'and PIN_Number ='"+pin_number+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin_number).setVisible(true);;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } 
            catch (Exception ee) {
                System.out.println(ee);
            }
        }
        else if(e.getSource() == sign_up){
            setVisible(false);
            new Signup().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
