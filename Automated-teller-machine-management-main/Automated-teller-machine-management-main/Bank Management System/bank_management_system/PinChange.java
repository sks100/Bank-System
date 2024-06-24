package bank_management_system;

import java.awt.*;
import java.awt.event.*;
// import java.sql.*;
import javax.swing.*;


public class PinChange extends JFrame implements ActionListener {

    String pin_number;
    JPasswordField pin, repin;
    JButton change , back;

    PinChange(String pin_number){

        setLayout(null);

        this.pin_number = pin_number;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/atm.jpg"));
        Image i2  = i1.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 700);
        add(image);


        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(230, 120, 600, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel new_pin = new JLabel("NEW PIN:");
        new_pin.setBounds(160, 200, 100, 25);
        new_pin.setForeground(Color.WHITE);
        new_pin.setFont(new Font("System", Font.BOLD, 16));
        image.add(new_pin);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(370, 200, 100, 25);
        image.add(pin);

        JLabel re_pin = new JLabel("RE-ENTER NEW PIN:");
        re_pin.setBounds(160, 250, 180, 25);
        re_pin.setForeground(Color.WHITE);
        re_pin.setFont(new Font("System", Font.BOLD, 16));
        image.add(re_pin);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(370, 250, 100, 25);
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(335, 325, 150, 30);
        change.setFont(new Font("System", Font.BOLD, 14));
        change.addActionListener(this);
        image.add(change);

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
        if(e.getSource() == back){
            setVisible(false);
            new Transaction(pin_number).setVisible(true);
        }
        else if(e.getSource() == change){
            try {
                char[] nnpin = pin.getPassword();
                String npin = new String(nnpin);
                char[] rrpin = pin.getPassword();
                String rpin = new String(rrpin);

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Enterd Pin Doesn't Match Or Pin must be of 4 digits only");
                    return;
                }
                if(npin.length() != 4 || rpin.length() != 4){
                    JOptionPane.showMessageDialog(null, "Pin must be of 4 digits only");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "UPDATE bank SET pin_number = '"+rpin+"' WHERE pin_number = '"+pin_number+"'";
                String query2 = "UPDATE login SET PIN_Number = '"+rpin+"' WHERE PIN_Number = '"+pin_number+"'";
                String query3 = "UPDATE signupthree SET PIN_Number = '"+rpin+"' WHERE PIN_Number = '"+pin_number+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Change Successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } 
            catch (Exception ae) {
                System.out.println(ae);
            }
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
