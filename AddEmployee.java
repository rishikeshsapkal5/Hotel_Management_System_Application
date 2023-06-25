
package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.Color.white;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField  tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
    JRadioButton rbmale,rbfemale; 
    JButton submit;
    JComboBox cbjob;
    
   
    AddEmployee(){
        setLayout(null);
        
          JLabel name=new JLabel("NAME");
     name.setBounds(60,30,120,30);
     name.setForeground(Color.BLACK); 
     name.setFont(new Font("serif",Font.PLAIN,20));
     add(name);
     
      tfname=new JTextField();
       tfname.setBounds(170,35,160,25);
       add(tfname);
     
            JLabel age=new JLabel("AGE");
     age.setBounds(60,80,120,30);
     age.setForeground(Color.BLACK); 
     age.setFont(new Font("serif",Font.PLAIN,20));
     add(age);
     
      tfage=new JTextField();
       tfage.setBounds(170,85,160,25);
       add(tfage);
       
              JLabel gender=new JLabel("GENDER");
     gender.setBounds(60,130,120,30);
     gender.setForeground(Color.BLACK); 
     gender.setFont(new Font("serif",Font.PLAIN,20));
     add(gender);
     
     rbmale=new JRadioButton("Male");
     rbmale.setBounds(170,133,70,30);
     rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
     rbmale.setBackground(Color.WHITE);
     add(rbmale);
     
     rbfemale=new JRadioButton("Female");
     rbfemale.setBounds(270,133,70,30);
     rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
     rbfemale.setBackground(Color.WHITE);
     add(rbfemale);
     
      ButtonGroup bg=new ButtonGroup();
     bg.add(rbmale);
     bg.add(rbfemale);
     
     JLabel job=new JLabel("JOB");
     job.setBounds(60,180,120,30);
     job.setForeground(Color.BLACK); 
     job.setFont(new Font("serif",Font.PLAIN,20));
     add(job);
     
     String str[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
              cbjob =new JComboBox(str);
             cbjob.setBounds(170,180,160,30);
             cbjob.setBackground(Color.WHITE);
             add(cbjob);
             
             JLabel salary=new JLabel("SALARY");
     salary.setBounds(60,230,120,30);
     salary.setForeground(Color.BLACK); 
     salary.setFont(new Font("serif",Font.PLAIN,20));
     add(salary);
     
      tfsalary=new JTextField();
       tfsalary.setBounds(170,235,160,25);
       add(tfsalary);
       
           JLabel phone=new JLabel("PHONE");
     phone.setBounds(60,280,120,30);
     phone.setForeground(Color.BLACK); 
     phone.setFont(new Font("serif",Font.PLAIN,20));
     add(phone);
     
      tfphone=new JTextField();
       tfphone.setBounds(170,285,160,25);
       add(tfphone);
       
         JLabel email=new JLabel("EMAIL");
     email.setBounds(60,330,120,30);
     email.setForeground(Color.BLACK); 
     email.setFont(new Font("serif",Font.PLAIN,20));
     add(email);
     
      tfemail=new JTextField();
        tfemail.setBounds(170,335,160,25);
       add( tfemail);
     
        JLabel aadhar=new JLabel("AADHAR");
     aadhar.setBounds(60,380,120,30);
     aadhar.setForeground(Color.BLACK); 
     aadhar.setFont(new Font("serif",Font.PLAIN,20));
     add(aadhar);
     
      tfaadhar=new JTextField();
        tfaadhar.setBounds(170,385,160,25);
       add( tfaadhar);
       
       
       
       submit=new JButton("SUBMIT");
      submit.setBackground(BLACK);
      submit.setForeground(WHITE);
      submit.setBounds(200, 430, 150, 30);
      submit.addActionListener(this);
      add(submit);
     
      JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\hse.jpg")); //Sets the image to be displayed as an icon
        
        label.setBounds(370,0 , 1600, 400);
        add(label);
     
     
     
     
     
     
     
     
     
     
     
        getContentPane().setBackground(white);
        setBounds(350,160,850,540);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        String name=tfname.getText();
         String age=tfage.getText();
          String salary=tfsalary.getText();
           String phone=tfphone.getText();
            String email=tfemail.getText();
             String aadhar=tfaadhar.getText();
               String gender=null;
               
               if(rbmale.isSelected()){
                   gender="Male";
                   
               }else if(rbfemale.isSelected()){
                   gender="Female";                                     
               }
               String job=(String) cbjob.getSelectedItem();
               try{
           
                   Conn conn=new Conn();
                   new Conn();
                 String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Employee added succesfully.");
               setVisible(false);
               
               }catch(Exception e){
                   e.printStackTrace();
               }
        
        
    }
    public static void main(String[] args){
        new AddEmployee();
    }
}
