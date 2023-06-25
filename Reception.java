
package javaimageinframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Reception extends JFrame implements ActionListener{
   
    JButton logout,checkout,newCustomer,pickupservice,rooms,department,allemployees,managerinfo,customerinfo,searchroom,updatestatus, updateroomstatus;
    
    
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         newCustomer=new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
         rooms=new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
       rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
         department=new JButton("Department");
       department.setBounds(10,110,200,30);
       department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
         allemployees=new JButton("All Employees");
       allemployees.setBounds(10,150,200,30);
      allemployees.setBackground(Color.BLACK);
        allemployees.setForeground(Color.WHITE);
        allemployees.addActionListener(this);
        add(allemployees);
        
        customerinfo=new JButton("Customer Info");
       customerinfo.setBounds(10,190,200,30);
      customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.addActionListener(this);
        add(customerinfo);
        
         managerinfo=new JButton("Manager Info");
       managerinfo.setBounds(10,230,200,30);
      managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo);
        
        
          checkout=new JButton("Checkout");
      checkout.setBounds(10,270,200,30);
      checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        updatestatus=new JButton("Update Status");
      updatestatus.setBounds(10,310,200,30);
      updatestatus.setBackground(Color.BLACK);
        updatestatus.setForeground(Color.WHITE);
        updatestatus.addActionListener(this);
        add(updatestatus);
        
        updateroomstatus=new JButton("Update Room Status");
      updateroomstatus.setBounds(10,350,200,30);
      updateroomstatus.setBackground(Color.BLACK);
        updateroomstatus.setForeground(Color.WHITE);
        updateroomstatus.addActionListener(this);
        add(updateroomstatus);
        
         pickupservice=new JButton("Pickup Service");
      pickupservice.setBounds(10,390,200,30);
      pickupservice.setBackground(Color.BLACK);
        pickupservice.setForeground(Color.WHITE);
        pickupservice.addActionListener(this);
        add(pickupservice);
        
         searchroom=new JButton("Search Room");
      searchroom.setBounds(10,430,200,30);
      searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout=new JButton("Logout");
      logout.setBounds(10,470,200,30);
      logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
         
        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\imgonline-com-ua-resize-tJqZcHxRazt.png"));
      label.setBounds(250,70 , 1600, 400);
        add(label);
        
        
        
        
        setBounds(350,110,890,590);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        } else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==department){
            setVisible(false);
            new Department();
        }
       
        else if(ae.getSource()==allemployees){
            setVisible(false);
            new EmployeeInfo();
        }
         else if(ae.getSource()==managerinfo){
            setVisible(false);
            new ManagerInfo();
        }
         else if(ae.getSource()==customerinfo){
            setVisible(false);
            new CustomerInfo();
        }
         else if(ae.getSource()==searchroom){
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource()==updatestatus){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource()==updateroomstatus){
            setVisible(false);
            new UpdateRoom();
        }
        
         else if(ae.getSource()==pickupservice){
            setVisible(false);
            new Pickup();
        }
         else if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }  else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
        
        
        
        
        
    }
    public static void main(String[] args){
        new Reception();
        
    }
}
