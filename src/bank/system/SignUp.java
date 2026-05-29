
package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class SignUp extends JFrame implements ActionListener{
    long random;
    JTextField n1,f1,e1,a1,c1,s1,p1,dob;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser date;
    JButton next;

    SignUp(){
        setLayout(null);
        

        Random ran=new Random();
        random=(Math.abs(ran.nextLong() % 9000L)+1000L);

        getContentPane().setBackground(Color.WHITE);

        JLabel formno=new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Ralway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personDetails=new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Ralway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Ralway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        n1=new JTextField();
        n1.setBounds(300,140,400,30);
        n1.setFont(new Font("Arial",Font.BOLD,20));
        add(n1);

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Ralway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        f1=new JTextField();
        f1.setBounds(300,190,400,30);
        f1.setFont(new Font("Arial",Font.BOLD,20));
        add(f1);


        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Ralway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        date=new JDateChooser();
        date.setBounds(300,240,200,30);
        add(date);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Ralway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(450,290,70,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Ralway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        e1=new JTextField();
        e1.setBounds(300,340,400,30);
        e1.setFont(new Font("Arial",Font.BOLD,20));
        add(e1);


        JLabel mstatus=new JLabel("Marital Status:");
        mstatus.setFont(new Font("Ralway",Font.BOLD,20));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);

        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried=new JRadioButton("Unmaried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other=new JRadioButton("Others");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup marrygroup=new ButtonGroup();
        marrygroup.add(married);
        marrygroup.add(unmarried);
        marrygroup.add(other);
        
        JLabel Address=new JLabel("Address:");
        Address.setFont(new Font("Ralway",Font.BOLD,20));
        Address.setBounds(100,440,200,30);
        add(Address);

        a1=new JTextField();
        a1.setBounds(300,440,400,30);
        a1.setFont(new Font("Arial",Font.BOLD,20));
        add(a1);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Ralway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        c1=new JTextField();
        c1.setBounds(300,490,400,30);
        c1.setFont(new Font("Arial",Font.BOLD,20));
        add(c1);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Ralway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        s1=new JTextField();
        s1.setBounds(300,540,400,30);
        s1.setFont(new Font("Arial",Font.BOLD,20));
        add(s1);

        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Ralway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        p1=new JTextField();
        p1.setBounds(300,590,400,30);
        p1.setFont(new Font("Arial",Font.BOLD,20));
        add(p1);

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
        String formno=""+random;
        String name=n1.getText();
        String fname=f1.getText();
        String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();//getUIComponet get the TextField so convert
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        String email=e1.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }
        else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        else if(other.isSelected()){
            marital="Other";
        }
        String address=a1.getText();
        String city=c1.getText();
        String state=s1.getText();
        String pin=p1.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name cannot be empty");//name text must not empty
            }
            else{
                Conn c=new Conn();
                String query="insert into SignUp values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUp2(formno).setVisible(true);
                
                }
        }
        catch(Exception p){
            System.out.println(e);
        }
    }
    

    public static void main(String[] args) {
        new SignUp();
    }
}
