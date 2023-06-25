
package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.Color.white;


public class AddDriver extends JFrame implements ActionListener {
   
    JTextField tfname,tfage,tfcc,tfc,tflocation,tfcm;
    JComboBox gendercb,availablecb;
    JButton adddriver,cancel;
    
    AddDriver(){
   getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBounds(165,30,200,18);
        setBounds(330,200,940,470);
        setVisible(true);
        add(heading);
        
        
        
           JLabel name=new JLabel("Name");
     name.setBounds(80,80,120,30);
     name.setForeground(Color.BLACK); 
     name.setFont(new Font("serif",Font.PLAIN,20));
     add(name);
     
      tfname=new JTextField();
       tfname.setBounds(215,85,160,25);
       add(tfname);
       
       
         JLabel age=new JLabel("Age");
     age.setBounds(80,130,120,30);
     age.setForeground(Color.BLACK); 
     age.setFont(new Font("serif",Font.PLAIN,20));
     add(age);
     
      tfage=new JTextField();
       tfage.setBounds(215,135,160,25);
       add(tfage);
       
       
       JLabel gender=new JLabel("Gender");
     gender.setBounds(80,180,120,30);
     gender.setForeground(Color.BLACK); 
     gender.setFont(new Font("serif",Font.PLAIN,20));
     add(gender);
     
      String genderOptions[]={"Male","Female"};
              gendercb =new JComboBox(genderOptions);
             gendercb.setBounds(215,185,160,30);
             gendercb.setBackground(Color.WHITE);
             add(gendercb);
             
        
       JLabel carcompany=new JLabel("Car Company");
     carcompany.setBounds(80,230,120,30);
     carcompany.setForeground(Color.BLACK); 
     carcompany.setFont(new Font("serif",Font.PLAIN,20));
     add(carcompany);       
        
        tfcc=new JTextField();
       tfcc.setBounds(215,235,160,25);
       add(tfcc);
       
       
        JLabel carmodel=new JLabel("Car Model");
     carmodel.setBounds(80,280,120,30);
     carmodel.setForeground(Color.BLACK); 
     carmodel.setFont(new Font("serif",Font.PLAIN,20));
     add(carmodel);       
        
        tfcm=new JTextField();
       tfcm.setBounds(215,285,160,25);
       add(tfcm);
       
        JLabel available=new JLabel("Available");
     available.setBounds(80,330,120,30);
     available.setForeground(Color.BLACK); 
     available.setFont(new Font("serif",Font.PLAIN,20));
     add(available);  
     
     String availableOptions[]={"Available","Busy"};
              availablecb =new JComboBox(availableOptions);
             availablecb.setBounds(215,335,160,30);
             availablecb.setBackground(Color.WHITE);
             add(availablecb);
     
             
     JLabel location=new JLabel("Location");
     location.setBounds(80,380,120,30);
     location.setForeground(Color.BLACK); 
    location.setFont(new Font("serif",Font.PLAIN,20));
     add(location);
     
      tflocation=new JTextField();
       tflocation.setBounds(215,385,160,25);
       add(tflocation);
       
       
       adddriver=new JButton("ADD DRIVER");
     adddriver.setBackground(BLACK);
      adddriver.setForeground(WHITE);
      adddriver.setBounds(60, 430, 150, 30);
      adddriver.addActionListener(this);
      add(adddriver);
     
      cancel=new JButton("CANCEL");
      cancel.setBackground(BLACK);
      cancel.setForeground(WHITE);
      cancel.setBounds(220, 430, 150, 30);
      cancel.addActionListener(this);
      add(cancel);
     
        
        
        
        getContentPane().setBackground(white);
        setBounds(350,160,800,550);
        setVisible(true);
        
        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\resizedriver.png"));
      label.setBounds(380,70 , 1600, 400);
        add(label);
        
}
    
    
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==adddriver){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender =(String) gendercb.getSelectedItem();
            String carcompany=tfcc.getText();
            String carmodel= tfcm.getText();
            String availabledriver =(String) availablecb.getSelectedItem();
            String location=tflocation.getText();
            try{
                Conn conn=new Conn();
                String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+carcompany+"','"+carmodel+"','"+availabledriver+"','"+location+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
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
        new AddDriver();
    }

    
}
