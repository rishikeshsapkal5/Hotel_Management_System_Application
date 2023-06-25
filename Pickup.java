package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.WHITE;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    Pickup(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel text=new JLabel("Pickup Service");
         text.setFont(new Font("Tahoma",Font.PLAIN,20));
         text.setBounds(400,30,200,30);
         add(text);
         
         JLabel carmodel =new JLabel("Car Model");
       carmodel.setBounds(50,100,100,20);
        add(carmodel);
        
        typeofcar=new Choice();
        typeofcar.setBounds(150,100,200,25);
         add(typeofcar);
     
    try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from driver");
        while(rs.next()){
            typeofcar.add(rs.getString("carmodel"));
                    
        }
    }   catch(Exception e){
        e.printStackTrace();
    }
        
        
        
        
        
        
        
        
       
        
     
        

        JLabel i1 =new JLabel("Name");
        i1.setBounds(30,160,100,20);
        add(i1);
        
        JLabel i2 =new JLabel("Age");
        i2.setBounds(200,160,100,20);
        add(i2);
        
        JLabel i3 =new JLabel("Status");
        i3.setBounds(330,160,100,20);
        add(i3);
        
        JLabel i4 =new JLabel("Company");
        i4.setBounds(460,160,100,20);
        add(i4);
        
        JLabel i5 =new JLabel("Model");
        i5.setBounds(630,160,100,20);
        add(i5);
        
         JLabel i6 =new JLabel("Availability");
        i6.setBounds(740,160,100,20);
        add(i6);
        
        JLabel i7 =new JLabel("Location");
        i7.setBounds(890,160,100,20);
        add(i7);
        
        
        
        
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
        
        table =new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
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
                String query="select * from driver where carmodel ='"+typeofcar.getSelectedItem()+"'";
                
                
                Conn conn=new Conn();
                ResultSet rs;
                rs=conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
                catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        else{
            setVisible(false);
        
        new Reception();
            }}
                
    public static void main(String[] args){
        new Pickup();
    }
    
}

