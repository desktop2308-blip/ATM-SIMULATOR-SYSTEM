
package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SignUp2 extends JFrame implements ActionListener{
    
    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,income,education;
    String formno;
    JButton next;
    SignUp2(String formno){
        this.formno=formno;
        setLayout(null);
        

        setTitle("NEW APPLICATION FORM - PAGE 2");

        getContentPane().setBackground(Color.WHITE);


        JLabel additionalDetails=new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Ralway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Ralway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String varReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(varReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Ralway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String varCategory[]={"OBC","General","SC","ST","Other"};
        category=new JComboBox(varCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);



        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Ralway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String varIncome[]={"Null","< 1,00,000","< 2,50,000","< 50,000","Up to 10Lac"};
        income=new JComboBox(varIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender=new JLabel("Educational:");
        gender.setFont(new Font("Ralway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);


        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Ralway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);

        

        String educationValues[]={"Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
        education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel mstatus=new JLabel("Occupation:");
        mstatus.setFont(new Font("Ralway",Font.BOLD,20));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);
        
        String occupationValues[]={"Salaried","Self-Employed","Businessman","Retired","Others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        
       
        
        JLabel Address=new JLabel("PAN No.:");
        Address.setFont(new Font("Ralway",Font.BOLD,20));
        Address.setBounds(100,440,200,30);
        add(Address);

        pan=new JTextField();
        pan.setBounds(300,440,400,30);
        pan.setFont(new Font("Arial",Font.BOLD,20));
        add(pan);

        JLabel city=new JLabel("Aadhar No.:");
        city.setFont(new Font("Ralway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        aadhar=new JTextField();
        aadhar.setBounds(300,490,400,30);
        aadhar.setFont(new Font("Arial",Font.BOLD,20));
        add(aadhar);

        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Ralway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes=new JRadioButton("YES");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno=new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup senior=new ButtonGroup();
        senior.add(syes);
        senior.add(sno);
        
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Ralway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes=new JRadioButton("YES");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("NO");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existing=new ButtonGroup();
        existing.add(eyes);
        existing.add(eno);
        
        next=new JButton("NEXT");
        next.setBounds(620,660,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        


        getContentPane().setBackground(Color.LIGHT_GRAY);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setTitle("Registration Form");


    }
    @Override
    public void actionPerformed(ActionEvent e){
        String sformno=formno;
        String sreligion=(String) religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String scitizen=null;
        if(syes.isSelected()){
            scitizen="Yes";
        }
        else if(sno.isSelected()){
            scitizen="No";
        }
        String existingAccount=null;
        if(eyes.isSelected()){
            existingAccount="Yes";
        }
        else if(eno.isSelected()){
            existingAccount="No";
        }
        String span=pan.getText();
        String saadhar=aadhar.getText();
        try{
            Conn c=new Conn();
            String squery="insert into SignUptwo values('"+sformno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+scitizen+"','"+existingAccount+"')";
            c.s.executeUpdate(squery);
            
            setVisible(false);
            new SignUp3(formno).setVisible(true);
                
        }
        catch(Exception p){ 
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignUp2("");    
    }
}

