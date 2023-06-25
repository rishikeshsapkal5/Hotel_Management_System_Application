
package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.Color.white;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField  tfroomno,tfprice;
    JComboBox availablecb,cleaningcb,bedcb;
    JButton addroom,cancel;
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBounds(165,40,200,18);
        setBounds(330,200,940,470);
        setVisible(true);
        add(heading);
        
        
        
          JLabel roomno=new JLabel("Room Number");
     roomno.setBounds(80,80,120,30);
     roomno.setForeground(Color.BLACK); 
     roomno.setFont(new Font("serif",Font.PLAIN,20));
     add(roomno);
     
      tfroomno=new JTextField();
       tfroomno.setBounds(215,85,160,25);
       add(tfroomno);
       
         JLabel available=new JLabel("Available");
    available.setBounds(80,130,120,30);
     available.setForeground(Color.BLACK); 
    available.setFont(new Font("serif",Font.PLAIN,20));
     add(available);
     
      String availableOptions[]={"Available","Occupied"};
              availablecb =new JComboBox(availableOptions);
             availablecb.setBounds(215,135,160,30);
             availablecb.setBackground(Color.WHITE);
             add(availablecb);
       
       JLabel cleaningstats=new JLabel("Cleaning Status");
     cleaningstats.setBounds(80,180,130,30);
    cleaningstats.setForeground(Color.BLACK); 
     cleaningstats.setFont(new Font("serif",Font.PLAIN,20));
     add(cleaningstats);
     
     String cleanOptions[]={"Cleaned","Dirty"};
              cleaningcb =new JComboBox(cleanOptions);
             cleaningcb.setBounds(215,185,160,30);
             cleaningcb.setBackground(Color.WHITE);
             add(cleaningcb);
       
        JLabel price=new JLabel("Price");
     price.setBounds(80,230,120,30);
     price.setForeground(Color.BLACK); 
    price.setFont(new Font("serif",Font.PLAIN,20));
     add(price);
     
      tfprice=new JTextField();
       tfprice.setBounds(215,235,160,25);
       add(tfprice);
       
         JLabel bedtype=new JLabel("Bed Type");
     bedtype.setBounds(80,280,120,30);
     bedtype.setForeground(Color.BLACK); 
    bedtype.setFont(new Font("serif",Font.PLAIN,20));
     add(bedtype);
     
      String bedOptions[]={"Single Bed","Double Bed"};
              bedcb =new JComboBox(bedOptions);
             bedcb.setBounds(215,285,160,30);
             bedcb.setBackground(Color.WHITE);
             add( bedcb);
       
       addroom=new JButton("ADD ROOM");
     addroom.setBackground(BLACK);
      addroom.setForeground(WHITE);
      addroom.setBounds(60, 340, 150, 30);
      addroom.addActionListener(this);
      add(addroom);
     
      cancel=new JButton("CANCEL");
      cancel.setBackground(BLACK);
      cancel.setForeground(WHITE);
      cancel.setBounds(220, 340, 150, 30);
      cancel.addActionListener(this);
      add(cancel);
      
      JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\resizeinterior.jpg"));
      label.setBounds(380,0 , 1600, 400);
        add(label);
       
       
       
       
       
      getContentPane().setBackground(white);
        setBounds(350,160,800,450);
        setVisible(true);
    }
        
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addroom){
            String roomnumber=tfroomno.getText();
            String availability=(String) availablecb.getSelectedItem();
            String status=(String) cleaningcb.getSelectedItem();
            String price= tfprice.getText();
            String type=(String) bedcb.getSelectedItem();
            try{
                Conn conn=new Conn();
                String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
            
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    
    else{
              setVisible(false);
}
    }
public static void main(String[] args){
       new AddRooms();
}
}