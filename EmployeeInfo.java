
package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.WHITE;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class EmployeeInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
   EmployeeInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         
        JLabel i1 =new JLabel("Name");
        i1.setBounds(40,10,100,20);
        add(i1);
        
        JLabel i2 =new JLabel("Age");
        i2.setBounds(170,10,100,20);
        add(i2);
        
        JLabel i3 =new JLabel("Gender");
        i3.setBounds(290,10,100,20);
        add(i3);
        
        JLabel i4 =new JLabel("Job");
        i4.setBounds(400,10,100,20);
        add(i4);
        
        JLabel i5 =new JLabel("Salary");
        i5.setBounds(540,10,100,20);
        add(i5);
        
        JLabel i6 =new JLabel("Phone");
        i6.setBounds(670,10,100,20);
        add(i6);
        
        JLabel i7 =new JLabel("Email");
        i7.setBounds(790,10,100,20);
        add(i7);
        
        JLabel i8 =new JLabel("Aadhar");
        i8.setBounds(910,10,100,20);
        add(i8);
        
        
        
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
        
        table =new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
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
        new EmployeeInfo();
    }
    
}