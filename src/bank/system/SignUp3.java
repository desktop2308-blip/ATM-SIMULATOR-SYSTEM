
package bank.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUp3 extends JFrame implements ActionListener {
    JRadioButton saving,fixeddeposit,current,recurring;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignUp3(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,40);
        add(type);
        
        saving=new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway",Font.BOLD,16));
        saving.setBackground(Color.WHITE);
        saving.setBounds(100,180,150,20);
        add(saving);
        
        fixeddeposit=new JRadioButton("Fixed Deposit Account");
        fixeddeposit.setFont(new Font("Raleway",Font.BOLD,16));
        fixeddeposit.setBackground(Color.WHITE);
        fixeddeposit.setBounds(350,180,250,20);
        add(fixeddeposit);
        
        
        current=new JRadioButton("Current Account");
        current.setFont(new Font("Raleway",Font.BOLD,16));
        current.setBackground(Color.WHITE);
        current.setBounds(100,220,250,20);
        add(current);
        
        recurring=new JRadioButton("Recurring Saving Account");
        recurring.setFont(new Font("Raleway",Font.BOLD,16));
        recurring.setBackground(Color.WHITE);
        recurring.setBounds(350,220,250,20);
        add(recurring);
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(saving);
        groupaccount.add(fixeddeposit);
        groupaccount.add(current);
        groupaccount.add(recurring);
        
        JLabel card=new JLabel("Card No:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-2308");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel cardDetails=new JLabel("Your 16 digit card number");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,330,300,20);
        add(cardDetails);
        
        JLabel pin=new JLabel("Pin No.:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        
        JLabel pinDetails=new JLabel("Your 4 digit password");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetails.setBounds(100,400,300,20);
        add(pinDetails);
        
        JLabel servicesRequired=new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Raleway",Font.BOLD,18));
        servicesRequired.setBounds(100,450,200,30);
        add(servicesRequired);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,150,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4=new JCheckBox("EMAIL & SMS ALERT");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6=new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7=new JCheckBox("I here by declare that the above entered details are correct  to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,650,600,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(150,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(350,720,100,30);
        cancel.addActionListener(this); 
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType="";
            if(saving.isSelected()){
                accountType="Saving Account";
            }else if(fixeddeposit.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(current.isSelected()){
                accountType="Current Account";
            }
            else if(recurring.isSelected()){
                accountType="Reccuring Deposit Account";
            }
            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong() % 90000000L))+ 23082006L;//initial card no. always 230820060906 
            String pinnumber=""+Math.abs((random.nextLong() %9000L)+ 1000L);  
            
            String facility="";
            if(c1.isSelected()){
                facility = facility + "ATM Card";
            }else if(c2.isSelected()){
                facility = facility + " Internet Banking ";
                
            }else if(c3.isSelected()){
                facility = facility + " Mobile Banking ";
            }else if(c4.isSelected()){
                facility = facility + " Email & SMS Alert ";
            }else if(c5.isSelected()){
                facility = facility + " ChequeBook ";
            }else if(c6.isSelected()){
                facility = facility + " E-Statement ";
            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required ");
                }else if(c7.isSelected()==false){
                    JOptionPane.showMessageDialog(null,"Please tick the consent option");
                }
                
                else{
                    Conn conn=new Conn();
                    String query1="insert into SignUpThree values('"+formno+"','"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2="insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    System.out.println(query2);
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null," Card Number "+cardnumber+"\n PIN:- "+pinnumber);
                    setVisible(false);
                    new Login().setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==cancel){
          setVisible(false);
          new Login().setVisible(true);
        }
        
    }
    
    
    public static void main(String args[]){
        new SignUp3("");
    }
}
