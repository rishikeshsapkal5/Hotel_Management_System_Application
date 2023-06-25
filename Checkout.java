
package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfname,tfpaid,tfpending;
    JButton check,checkout,back;
    JLabel  tfroom,lblcheckouttime,tfcheckin;
    
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel text=new JLabel("Checkout");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        
        
        
        
        
        
        JLabel lblid=new JLabel("Customer Id");
       lblid.setBounds(30,80,100,20);
        add(lblid);
        
        ccustomer=new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);
        
        
        try{
           Conn c =new Conn();
           ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("document_UID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblroom=new JLabel("Room No.");
       lblroom.setBounds(30,120,100,20);
        add(lblroom);
        
        tfroom=new JLabel();
        tfroom.setBounds(150,120,150,25);
        add(tfroom);
        
        
        
        
        JLabel lblcheckin=new JLabel("Check-In Time");
       lblcheckin.setBounds(30,160,100,20);
        add(lblcheckin);
        
         tfcheckin=new JLabel();
        tfcheckin.setBounds(150,160,170,30);
        add(tfcheckin);
        
        JLabel lblcheckout=new JLabel("Checkout Time");
     lblcheckout.setBounds(30,200,100,30);
      add(lblcheckout); 
      
      
    Date date=new Date();
        lblcheckouttime=new JLabel(""+date);
     lblcheckouttime.setBounds(150,200,170,30);
      add(lblcheckouttime); 
        
        
        
        
        
        
        
        
        check=new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(20,245,100,30);
        check.addActionListener(this);
        add(check);
        
        checkout=new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(140,245,100,30);
        checkout.addActionListener(this);
        add(checkout);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(260,245,100,30);
        back.addActionListener(this);
        add(back);
        
        JLabel label2 = new JLabel(); //JLabel Creation
        label2.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\imgonline-com-ua-resize-Yh8H8aYbNp6JFdEB.jpg"));
      label2.setBounds(390,10 , 900, 310);
        add(label2);
        
        
        setBounds(300,120,850,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            
            String id=ccustomer.getSelectedItem();
            String query ="select * from customer where document_UID = '"+id+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    
                    tfcheckin.setText(rs.getString("time"));
                    
                    
                }
                
               /*  ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price =rs2.getString("price");
                    int amountPaid=Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+amountPaid);
                    
                }*/
                
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
            
        } else if(ae.getSource()==checkout){
             String query1="delete from customer where room='"+tfroom.getText()+"'";
              String query2="update room set availability = 'Available' where roomnumber = '"+tfroom.getText()+"'";
              
              try{
                  Conn c=new Conn();
                  c.s.executeUpdate(query1);
                  c.s.executeUpdate(query2);
                  
                  JOptionPane.showMessageDialog(null,"Checkout Done");
                  setVisible(false);
              new Reception();
                  
              }  catch(Exception e){
                  e.printStackTrace();
              }
            
            
        }else{
            setVisible(false);
                new Reception();
        }
    }
    
    public static void main(String[] args){
        new Checkout();
    }
    
}
