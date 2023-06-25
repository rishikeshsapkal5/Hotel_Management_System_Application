package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.WHITE;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
   CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         
        JLabel i1 =new JLabel("Document Type");
        i1.setBounds(10,10,100,20);
        add(i1);
        
        JLabel i2 =new JLabel("Document UID");
        i2.setBounds(140,10,100,20);
        add(i2);
        
        JLabel i3 =new JLabel("Name");
        i3.setBounds(260,10,100,20);
        add(i3);
        
        JLabel i4 =new JLabel("Gender");
        i4.setBounds(380,10,100,20);
        add(i4);
        
        JLabel i5 =new JLabel("Country");
        i5.setBounds(510,10,100,20);
        add(i5);
        
        JLabel i6 =new JLabel("Room No.");
        i6.setBounds(640,10,100,20);
        add(i6);
        
        JLabel i7 =new JLabel("Check-In Time");
        i7.setBounds(760,10,100,20);
        add(i7);
        
        JLabel i8 =new JLabel("Deposit");
        i8.setBounds(890,10,100,20);
        add(i8);
        
        
        
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
        
        table =new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(WHITE);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);
        
        
        
       setBounds(150,100,1000,600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new CustomerInfo();
    }
    
}

