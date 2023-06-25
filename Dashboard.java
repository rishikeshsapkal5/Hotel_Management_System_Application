
package javaimageinframe;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
         setSize(1366,748);
        setLocation(0,0);
      JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\imgonline-com-ua-resize-XEHL0hwdVrP.jpg")); //Sets the image to be displayed as an icon
        label.setBounds(0, 0, 1366, 748); 
        add(label); 
     setVisible(true);
     JLabel text=new JLabel("WELCOME TO RADISSON HOTEL GROUP");
     text.setBounds(200,100,1000,90);
     text.setForeground(Color.YELLOW);
     text.setFont(new Font("SERIF",Font.ITALIC,50));
     label.add(text);
     
     JMenuBar mb=new JMenuBar();
     mb.setBounds(0,0,1366,15);
     label.add(mb);
     
     JMenu hotel=new JMenu("HOTEL MANAGEMENT");
     hotel.setForeground(Color.RED);
     mb.add(hotel);
     JMenu admin=new JMenu("ADMIN");
     admin.setForeground(Color.BLUE);
     mb.add(admin);
     
     JMenuItem reception=new JMenuItem("RECEPTION");
     reception.addActionListener(this);
     hotel.add(reception);
      JMenuItem addemp=new JMenuItem("ADD EMPLOYEE");
       addemp.addActionListener(this);
     admin.add(addemp);
     JMenuItem rooms=new JMenuItem("ADD ROOMS");
     rooms.addActionListener(this);
     admin.add(rooms);
     JMenuItem drivers=new JMenuItem("ADD DRIVERS");
     drivers.addActionListener(this);
     admin.add(drivers);
     
     
     
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }
        
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        }
        
        else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    

public static void main(String args[]){
     new Dashboard();
}
}