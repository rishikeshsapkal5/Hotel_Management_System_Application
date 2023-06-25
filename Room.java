
package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.WHITE;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Room(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\imgonline-com-ua-resize-XOLEwZ2jlOn9fcDi.jpg"));
      label.setBounds(530,0 , 1600, 300);
        add(label);

        JLabel i1 =new JLabel("Room Number");
        i1.setBounds(10,10,100,20);
        add(i1);
        
        JLabel i2 =new JLabel("Availability");
        i2.setBounds(130,10,100,20);
        add(i2);
        
        JLabel i3 =new JLabel("Status");
        i3.setBounds(220,10,100,20);
        add(i3);
        
        JLabel i4 =new JLabel("Price");
        i4.setBounds(340,10,100,20);
        add(i4);
        
        JLabel i5 =new JLabel("Bed Type");
        i5.setBounds(450,10,100,20);
        add(i5);
        
        
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
        
        table =new JTable();
        table.setBounds(0,30,530,400);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
        
        
        
       setBounds(150,100,1050,600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new Room();
    }
    
}
