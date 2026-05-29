
package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JButton m1,m2,m3,m4,m5,m6,exit;
    String pinnumber;
     FastCash(String pinnumber){
         this.pinnumber=pinnumber;
         setLayout(null);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
         
         JLabel text= new JLabel("SELECT WITHDRAW AMOUNT");
         text.setBounds(220,300,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text);
         
         m1=new JButton("Rs 100");
         m1.setBounds(170,415,150,30);
         m1.addActionListener(this);
         image.add(m1);
         
         m2=new JButton("Rs 500");
         m2.setBounds(355,415,150,30);
         m2.addActionListener(this); 
         image.add(m2);
         
         m3=new JButton("Rs 1000");
         m3.setBounds(170,450,150,30);
         m3.addActionListener(this);
         image.add(m3);
         
         m4=new JButton("Rs 2000");
         m4.setBounds(355,450,150,30);
         m4.addActionListener(this);
         image.add(m4);
         
         m5=new JButton("Rs 5000");
         m5.setBounds(170,485,150,30);
         m5.addActionListener(this);
         image.add(m5);
         
         
         m6=new JButton("Rs 10000");
         m6.setBounds(355,485,150,30);
         m6.addActionListener(this);
         image.add(m6);
         
         exit=new JButton("Exit");
         exit.setBounds(355,520,150,30);
         exit.addActionListener(this);
         image.add(exit);
         
         setSize(900,900);
         setUndecorated(true);
         setLocation(300,0);
         setVisible(true);
         
     }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == exit){
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }else{
             String amount =  ( (JButton)ae.getSource()).getText().substring(3); //Rs 500 as a text then trim Rs from text 
             Conn c = new Conn();
             try{
                 ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                 int balance = 0;
                 while(rs.next()){
                     if(rs.getString("type").equals("Deposit")){
                         balance += Integer.parseInt(rs.getString("amount"));
                     }else{
                         balance -= Integer.parseInt(rs.getString("amount"));
                     }
                 }
                 
                 if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                     return;
                 }
                 Date date =new Date();
                 String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
             }
                catch(Exception e){
                System.out.println(e);
             }
         }
    }
     public static void main(String args[]){
         new FastCash("");
     }
}
