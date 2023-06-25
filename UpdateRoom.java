
package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice cid;
    JTextField tfroom,tfavailability,tfcheckin,tfpaid,tfpending,tfcs;
    JButton check,update,back;
    
    UpdateRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        
        
        
        
        
        
        JLabel lblid=new JLabel("Customer Id");
       lblid.setBounds(30,130,100,20);
        add(lblid);
        
        cid=new Choice();
        cid.setBounds(200,130,150,25);
        add(cid);
        
        
        try{
           Conn c =new Conn();
           ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                cid.add(rs.getString("document_UID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblroom=new JLabel("Room No.");
       lblroom.setBounds(30,180,100,20);
        add(lblroom);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,180,150,25);
        add(tfroom);
        
        JLabel lblavailability=new JLabel("Availability");
       lblavailability.setBounds(30,230,100,20);
        add(lblavailability);
        
         tfavailability=new JTextField();
        tfavailability.setBounds(200,230,150,25);
        add(tfavailability);
        
        
        JLabel lblcs=new JLabel("Cleaning Status");
       lblcs.setBounds(30,280,100,20);
        add(lblcs);
        
         tfcs=new JTextField();
        tfcs.setBounds(200,280,150,25);
        add(tfcs);
        
        
        
        
        check=new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,330,100,30);
        check.addActionListener(this);
        add(check);
        
        update=new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,330,100,30);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,330,100,30);
        back.addActionListener(this);
        add(back);
        
        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\imgonline-com-ua-resize-rWbi2kimm3.jpg"));
      label.setBounds(400,60 , 1300, 300);
        add(label);
        
        
        setBounds(300,200,980,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            
            String id=cid.getSelectedItem();
            String query ="select * from customer where document_UID = '"+id+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                   
                    
                    
                }
                
                 ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailability.setText(rs2.getString("availability"));
                    tfcs.setText(rs2.getString("cleaning_status"));
                    
                }
                
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
            
        } else if(ae.getSource()==update){
            String number=cid.getSelectedItem();
            String room =tfroom.getText();
            String available=tfavailability.getText();
            String status =tfcs.getText();
            
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set availability='"+available+"',cleaning_status='"+status+"' where roomnumber='"+room+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else{
            setVisible(false);
                new Reception();
        }
    }
    
    public static void main(String[] args){
        new UpdateRoom();
    }
    
}
