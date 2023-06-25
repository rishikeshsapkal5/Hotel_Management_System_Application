
package javaimageinframe;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;
import  static javax.print.attribute.standard.Chromaticity.COLOR;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
     
    JTextField username;
    JPasswordField  password;
    JButton login,cancel;
    Login(){
        ///1.Frame
        setSize(1366,748);
        setLocation(0,0);
       
        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\Dell\\AppData\\Local\\Temp\\Temp1_vecteezy_fingerprint-identity-sensor-data-protection-system-podium_7164537_177.zip\\bestbg.jpg")); //Sets the image to be displayed as an icon
        
        label.setBounds(0, 0, 1366, 748);
        add(label);
        
      JLabel lusername=new JLabel("Username");
     lusername.setBounds(480,287,320,50);
     lusername.setForeground(Color.WHITE);
  
     label.setBackground(Color.WHITE);
     lusername.setFont(new Font("serif",Font.BOLD,30));
     label.add(lusername);
       
       username=new JTextField("USERNAME");
       username.setBounds(720,300,150,30);
       add(username);
       username.addFocusListener(new FocusListener() {
    public void focusGained(FocusEvent e) {
        username.setText("");
    }

    public void focusLost(FocusEvent e) {
        
    }
});
       
       
     JLabel lpassword=new JLabel("Password");
     lpassword.setBounds(480,367,320,50);
     lpassword.setForeground(Color.WHITE);
     lpassword.setFont(new Font("serif",Font.BOLD,30));
     label.add(lpassword);
       
         
        password=new JPasswordField("PASSWORD");
       password.setBounds(720,380,150,30);
       add(password);
       
       password.addFocusListener(new FocusListener() {
    public void focusGained(FocusEvent e) {
        password.setText("");
    }

    public void focusLost(FocusEvent e) {
        
    }
});
       
        
        
        //First Button-Login Button
        JPanel panel = new JPanel();
      getContentPane();
       login = new JButton("LOGIN");
  login.setForeground(Color.BLACK);
     login.setBounds(500, 450,90,35);
     
      panel.setLayout(null);
      login.addActionListener(this);
     panel.add(login);
     panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    add(panel);
    panel.setVisible(true);
       //  Second Button-Cancel Button(Not )
    getContentPane();
    
    
    
       cancel = new JButton("CANCEL");
  cancel.setForeground(Color.BLACK);
     cancel.setBounds(705, 450,90,35);
      panel.setLayout(null);
      cancel.addActionListener(this);
     panel.add(cancel);
      panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     add(panel);
   panel.setVisible(true);
    setExtendedState(MAXIMIZED_BOTH);
    
    setVisible(true);
    //add(label);
     revalidate();
    repaint();
        }   //End of Construtor 
    
 public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==login){
         String user=username.getText();
         String pass=password.getText();
         try{
             Conn c=new Conn();
             String query="select * from login where username='"+user+"' and password='"+pass+"'";
             ResultSet rs=c.s.executeQuery(query);
             
             if(rs.next()){
                 setVisible(false);
                 new Dashboard();
             }
             else{
                 JOptionPane.showMessageDialog(null,"invalid username or password");
                 setVisible(false);
             }
         }
         catch(Exception e){
             e.printStackTrace();
         }
     }
     else if(ae.getSource()==cancel){
         setVisible(false);
     }
 }
       
   
    
    public static void main(String args[]){
        new Login();
    }

   
}