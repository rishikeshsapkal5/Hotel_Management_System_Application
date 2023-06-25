
package javaimageinframe;

import java.awt.Choice;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class AddCustomer extends JFrame implements ActionListener{
    
    JRadioButton rbmale,rbfemale;
    JTextField tfphone,tfname,tfcountry,tfdeposit;
    JComboBox idcb,gendercb;
    Choice croom;
    JLabel checkintime;
    JButton addcustomer,back;
           
    
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("New Customer Form");
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBounds(165,20,250,18);
        setBounds(330,200,940,470);
        setVisible(true);
        add(heading);
        
        JLabel id=new JLabel("ID");
     id.setBounds(40,75,120,30);
     id.setForeground(Color.BLACK); 
    id.setFont(new Font("serif",Font.PLAIN,20));
     add(id);
        
        
         String idtype[]={"Aadhar Card","Passport","Driving License","Voter-id Card","Ration Card"};
              idcb =new JComboBox(idtype);
             idcb.setBounds(200,75,160,30);
             idcb.setBackground(Color.WHITE);
              idcb.setFont(new Font("serif",Font.PLAIN,15));
             add(idcb);
             
             
             JLabel phone=new JLabel("Phone No.");
     phone.setBounds(40,115,120,30);
     phone.setForeground(Color.BLACK); 
    phone.setFont(new Font("serif",Font.PLAIN,20));
     add(phone);
     
      tfphone=new JTextField();
       tfphone.setBounds(200,115,160,30);
       add(tfphone);
       
       
             JLabel name=new JLabel("Name");
     name.setBounds(40,155,120,30);
     name.setForeground(Color.BLACK); 
    name.setFont(new Font("serif",Font.PLAIN,20));
     add(name);
     
        tfname = new JTextField();
       tfname.setBounds(200,155,160,30);
       add(tfname);
       
       JLabel gender=new JLabel("Gender");
     gender.setBounds(40,195,120,30);
     gender.setForeground(Color.BLACK); 
    gender.setFont(new Font("serif",Font.PLAIN,20));
     add(gender);
     
      rbmale=new JRadioButton("Male");
     rbmale.setBounds(200,195,70,30);
     rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
     rbmale.setBackground(Color.WHITE);
     add(rbmale);
     
     rbfemale=new JRadioButton("Female");
     rbfemale.setBounds(300,195,70,30);
     rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
     rbfemale.setBackground(Color.WHITE);
     add(rbfemale);
     
      ButtonGroup bg=new ButtonGroup();
     bg.add(rbmale);
     bg.add(rbfemale);
     
             
               JLabel country=new JLabel("Country");
     country.setBounds(40,235,120,30);
     country.setForeground(Color.BLACK); 
    country.setFont(new Font("serif",Font.PLAIN,20));
     add(country);
     
        tfcountry = new JTextField();
       tfcountry.setBounds(200,235,160,30);
       add(tfcountry);
       
        JLabel roomno=new JLabel("Room No.");
     roomno.setBounds(40,275,120,30);
     roomno.setForeground(Color.BLACK); 
    roomno.setFont(new Font("serif",Font.PLAIN,20));
     add(roomno);
             
       ////////
       croom=new Choice();
       
       try{
           Conn conn=new Conn();
           String query="select * from room where availability='Available'";
           ResultSet rs=conn.s.executeQuery(query);
           while(rs.next()){
               croom.add(rs.getString("roomnumber"));
           }
       } catch(Exception e){
           e.printStackTrace();
       }
       croom.setBounds(200,275,160,30);
       add(croom);
       
       
       
       
       
       
       
       JLabel checktime=new JLabel("Check Time");
     checktime.setBounds(40,315,120,30);
     checktime.setForeground(Color.BLACK); 
    checktime.setFont(new Font("serif",Font.PLAIN,20));
     add(checktime);
     
     Date date=new Date();
     checkintime=new JLabel(""+date);
     checkintime.setBounds(200,320,200,25);
     checkintime.setFont(new Font("Raleway",Font.PLAIN,14));
     add(checkintime);
     
     //////////
     
     JLabel deposit=new JLabel("Deposit");
     deposit.setBounds(40,355,120,30);
     deposit.setForeground(Color.BLACK); 
    deposit.setFont(new Font("serif",Font.PLAIN,20));
     add(deposit);
     
     tfdeposit = new JTextField();
       tfdeposit.setBounds(200,355,160,30);
       add(tfdeposit);
       
       
        addcustomer=new JButton("Add");
     addcustomer.setBackground(BLACK);
      addcustomer.setForeground(WHITE);
      addcustomer.setBounds(60, 430, 150, 30);
      addcustomer.addActionListener(this);
      add(addcustomer);
     
      back=new JButton("Back");
      back.setBackground(BLACK);
      back.setForeground(WHITE);
      back.setBounds(220, 430, 150, 30);
      back.addActionListener(this);
      add(back);
      
       JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\resizeaddcustomer.png"));
      label.setBounds(400,10 , 1600, 500);
        add(label);
     
     
     
       
             
        
        
        
        
        setBounds(250,150,1000,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addcustomer){
            String id=(String) idcb.getSelectedItem();
            String number=tfphone.getText();
            String name=tfname.getText();
            String gender=null;
            
            if(rbmale.isSelected()){
                gender="Male";
            } else{
                gender="Female";
            }
        
        String country=tfcountry.getText();
        String room=croom.getSelectedItem();
        String time=checkintime.getText();
        String deposit=tfdeposit.getText();
        
        try{
           String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
           String query2="update room set availability='Occupied' where roomnumber='"+room+"'";
           Conn conn=new Conn();
           conn.s.executeUpdate(query);
           conn.s.executeUpdate(query2);
           
           JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
           setVisible(false);
           new Reception();
        }catch (Exception e){
            e.printStackTrace();
        }
        }
         else if(ae.getSource()== back){
    setVisible(false);
           new Reception();
         }
    }  
    
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
