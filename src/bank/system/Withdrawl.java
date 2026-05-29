
package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;



public class Withdrawl extends JFrame implements ActionListener {
    JButton withdraw,back;
    JTextField amount;
    String cardnumber,pinnumber;
    Withdrawl(String pinnumber,String cardnumber){
        
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount to Withdraw:- ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Ralway", Font.BOLD,16));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Amount cannot be null");
            }else{
                try{
                    Conn conn = new Conn();
                    int balance = 0; 
                    ResultSet rs = conn.s.executeQuery("select * from bank where cardnumber = '"+cardnumber+"'");
            
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance>=Integer.parseInt(number)){
                        String query="insert into bank values('"+cardnumber+"','"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");  
                        setVisible(false);
                        new Transactions(pinnumber,cardnumber).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        setVisible(false);
                        new Transactions(pinnumber,cardnumber).setVisible(true);
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber,cardnumber).setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        new Withdrawl("","");
    }
}
