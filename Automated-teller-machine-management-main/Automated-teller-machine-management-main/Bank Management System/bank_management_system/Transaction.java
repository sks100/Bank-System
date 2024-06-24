package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{

    JButton deposit,withdrawl,balance_enquiry,Exit,fastcash,miniState,pin;
    String pin_number;
    Transaction(String pin_number){

        setLayout(null);

        this.pin_number = pin_number;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/atm.jpg"));
        Image i2  = i1.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 700);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction Option");
        text.setBounds(170, 120, 600, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(150, 255, 150, 30);
        deposit.setFont(new Font("System", Font.BOLD, 14));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(335, 255, 150, 30);
        withdrawl.setFont(new Font("System", Font.BOLD, 14));
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150, 290, 150, 30);
        fastcash.setFont(new Font("System", Font.BOLD, 14));
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniState = new JButton("Mini Statement");
        miniState.setBounds(335, 290, 150, 30);
        miniState.setFont(new Font("System", Font.BOLD, 14));
        miniState.addActionListener(this);
        image.add(miniState);

        pin = new JButton("Pin Change");
        pin.setBounds(150, 325, 150, 30);
        pin.setFont(new Font("System", Font.BOLD, 14));
        pin.addActionListener(this);
        image.add(pin);

        balance_enquiry = new JButton("Balance Enquiry");
        balance_enquiry.setBounds(335, 325, 150, 30);
        balance_enquiry.setFont(new Font("System", Font.BOLD, 14));
        balance_enquiry.addActionListener(this);
        image.add(balance_enquiry);

        Exit = new JButton("Exit");
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
            System.exit(0);
        }
        else if(e.getSource() == deposit){
            setVisible(false);
            new Deposit(pin_number).setVisible(true);
        }
        else if(e.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pin_number).setVisible(true);
        }
        else if(e.getSource() == fastcash){
            setVisible(false);
            new FastCash(pin_number).setVisible(true);
        }
        else if(e.getSource() == pin){
            setVisible(false);
            new PinChange(pin_number).setVisible(true);
        }
        else if(e.getSource() == balance_enquiry){
            setVisible(false);
            new BalanceEnquiry(pin_number).setVisible(true);
        }
        else if(e.getSource() == miniState){
            new MiniStatement(pin_number).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
