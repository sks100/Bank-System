package bank_management_system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SignupTwo extends JFrame implements ActionListener{

    JTextField incomeTextField,panTextField,aadharTextField,ExistingTextField;
    JComboBox<String> catag,religion,income,eduaction,occupation;
    JRadioButton Yes, No,eYes,eNo;
    JButton next;
    String[] valRel = {"Hindu","Muslim","Sikh","Christian","Others"}; 
    String[] valCat = {"General","OBC","SC","ST","Others"}; 
    String[] valincome = {"NULL","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"}; 
    String[] educval = {"Under-Graduate","Graduate","Post-Graduate","Docrate","Others"}; 
    String[] occval = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"}; 
    String formno;

    SignupTwo(String formno){

        this.formno = formno;

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        setLayout(null);

        JLabel additionalDetails = new JLabel("Page 2:  Additional Deatils");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        additionalDetails.setBounds(280, 40,  400, 30);
        add(additionalDetails);

        JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Raleway", Font.BOLD, 20));
        Religion.setBounds(150, 110,  200, 30);
        add(Religion);

        religion = new JComboBox<String>(valRel);
        religion.setBounds(370, 111,  300, 30);
        religion.setFont(new Font("Arial",Font.BOLD,14));
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(150, 160,  200, 30);
        add(category);

        catag = new JComboBox<String>(valCat);
        catag.setBounds(370, 161,  300, 30);
        catag.setFont(new Font("Arial",Font.BOLD,14));
        catag.setBackground(Color.WHITE);
        add(catag);

        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Raleway", Font.BOLD, 20));
        Income.setBounds(150, 210,  200, 30);
        add(Income);

        income = new JComboBox<String>(valincome);
        income.setBounds(370, 211,  300, 30);
        income.setFont(new Font("Arial",Font.BOLD,14));
        income.setBackground(Color.WHITE);
        add(income);

        JLabel Educational = new JLabel("Educational");
        Educational.setFont(new Font("Raleway", Font.BOLD, 20));
        Educational.setBounds(150, 260,  200, 30);
        add(Educational);

        JLabel Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        Qualification.setBounds(150, 280,  200, 30);
        add(Qualification);

        eduaction = new JComboBox<String>(educval);
        eduaction.setBounds(370, 271,  300, 30);
        eduaction.setFont(new Font("Arial",Font.BOLD,14));
        eduaction.setBackground(Color.WHITE);
        add(eduaction);

        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        Occupation.setBounds(150, 330,  200, 30);
        add(Occupation);

        occupation = new JComboBox<String>(occval);
        occupation.setBounds(370, 331,  300, 30);
        occupation.setFont(new Font("Arial",Font.BOLD,14));
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel Pan_no = new JLabel("PAN Number:");
        Pan_no.setFont(new Font("Raleway", Font.BOLD, 20));
        Pan_no.setBounds(150, 390,  200, 30);
        add(Pan_no);
        
        panTextField = new JTextField();
        panTextField.setBounds(370, 391,  300, 30);
        panTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(panTextField);

        JLabel Aadhar_no = new JLabel("Aadhar Number:");
        Aadhar_no.setFont(new Font("Raleway", Font.BOLD, 20));
        Aadhar_no.setBounds(150, 440,  200, 30);
        add(Aadhar_no);

        aadharTextField = new JTextField();
        aadharTextField.setBounds(370, 441,  300, 30);
        aadharTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(aadharTextField);

        JLabel Senior = new JLabel("Senior Citizen:");
        Senior.setFont(new Font("Raleway", Font.BOLD, 20));
        Senior.setBounds(150, 490,  200, 30);
        add(Senior);

        Yes = new JRadioButton("YES");
        Yes.setBounds(370, 491, 100, 30);
        Yes.setBackground(Color.white);
        add(Yes);
        No = new JRadioButton("No");
        No.setBounds(490, 490, 100, 30);
        No.setBackground(Color.white);
        add(No);

        ButtonGroup Senior_citizen = new ButtonGroup();
        Senior_citizen.add(Yes);
        Senior_citizen.add(No);

        JLabel Exist_acc = new JLabel("Existing Account:");
        Exist_acc.setFont(new Font("Raleway", Font.BOLD, 20));
        Exist_acc.setBounds(150, 540,  200, 30);
        add(Exist_acc);

        eYes = new JRadioButton("YES");
        eYes.setBounds(370, 541, 100, 30);
        eYes.setBackground(Color.white);
        add(eYes);
        eNo = new JRadioButton("No");
        eNo.setBounds(490, 541, 100, 30);
        eNo.setBackground(Color.white);
        add(eNo);

        ButtonGroup existing = new ButtonGroup();
        existing.add(Yes);
        existing.add(No);

        next = new JButton("Next >> ");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBounds(650, 600, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350, 10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

       String sreligion = (String) religion.getSelectedItem();
       String catagory = (String) catag.getSelectedItem();
       String Income = (String) income.getSelectedItem();
       String Eduaction = (String) eduaction.getSelectedItem();
       String Occupation = (String) occupation.getSelectedItem();
       String Aadhar_no = aadharTextField.getText();
       String pan_no = panTextField.getText();
       String senior = null;
       if(Yes.isSelected()){
        senior = "Yes";
       }
       else if(No.isSelected()){
        senior = "No";
       }
       String Existing = null;
       if(eYes.isSelected()){
        Existing = "Yes";
       }
       else if(eNo.isSelected()){
        Existing = "No";
       }

       try {
        if(sreligion.equals("") || catagory.equals("") || Income.equals("") || Eduaction.equals("") || Occupation.equals("") || Aadhar_no.equals("") || pan_no.equals("") || senior.equals("") || Existing.equals(""))
            JOptionPane.showMessageDialog(null, " ! All Credentials Required");
        else{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+catagory+"', '"+Income+"', '"+Eduaction+"', '"+Occupation+"', '"+Aadhar_no+"', '"+pan_no+"', '"+senior+"', '"+Existing+"')";
            c.s.executeUpdate(query);

            //signup three object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
       } catch (Exception ee) {
        System.out.println(ee);
       }

    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
    
}
