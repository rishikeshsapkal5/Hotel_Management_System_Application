package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.WHITE;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel text=new JLabel("Search for Room");
         text.setFont(new Font("Tahoma",Font.PLAIN,20));
         text.setBounds(400,30,200,30);
         add(text);
         
         JLabel lblbed =new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
         
     
     String str[]={"Single Bed","Double Bed"};
              bedType =new JComboBox(str);
             bedType.setBounds(150,100,150,25);
             bedType.setBackground(Color.WHITE);
             add(bedType);
        
        
        
        
        
        
        
        
       
        
        available=new JCheckBox("Only display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        

        JLabel i1 =new JLabel("Room Number");
        i1.setBounds(50,160,100,20);
        add(i1);
        
        JLabel i2 =new JLabel("Availability");
        i2.setBounds(270,160,100,20);
        add(i2);
        
        JLabel i3 =new JLabel("Status");
        i3.setBounds(450,160,100,20);
        add(i3);
        
        JLabel i4 =new JLabel("Price");
        i4.setBounds(670,160,100,20);
        add(i4);
        
        JLabel i5 =new JLabel("Bed Type");
        i5.setBounds(570,160,100,20);
        add(i5);
        
        
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
        
        table =new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        submit=new JButton("Submit");
       submit.setBackground(Color.BLACK);
       submit.setForeground(WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(WHITE);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        
        
       setBounds(150,100,1000,600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                String query1="select * from room where bed_type ='"+bedType.getSelectedItem()+"'";
                String query2="select * from room where availability='Available' AND bed_type ='"+bedType.getSelectedItem()+"'";
                
                Conn conn=new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    
                    rs=conn.s.executeQuery(query2);
                    
                }else{
                    rs=conn.s.executeQuery(query1);
                    
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        else{
            {setVisible(false);
        
        new Reception();
            }}
                }
    public static void main(String[] args){
        new SearchRoom();
    }
    
}
