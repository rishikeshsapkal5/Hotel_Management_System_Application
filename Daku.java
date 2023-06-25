package javaimageinframe;
import java.awt.*;  
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.lang.model.SourceVersion;



public class Daku extends JFrame implements ActionListener{
    Daku(){
        setSize(1366,748);
        setLocation(0,100);
       // Container c = getContentPane(); //Gets the content layer

        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\cropped.png")); //Sets the image to be displayed as an icon
        //Dimension size = label.getPreferredSize(); //Gets the size of the image
        label.setBounds(0, 0, 1366, 748); //Sets the location of the image
 
    add(label); //Adds objects to the container
     //   add(image);
     JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
     text.setBounds(20,600,1000,90);
     text.setForeground(Color.ORANGE);
     text.setFont(new Font("serif",Font.PLAIN,50));
     label.add(text);
     
    
    //for JButton
     JPanel panel = new JPanel();
      getContentPane();
      JButton next = new JButton("NEXT");
      Dimension size = next.getPreferredSize();
      next.setBounds(1200, 630,65,35);
      panel.setLayout(null);
      next.addActionListener(this);
      panel.add(next);
     panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      add(panel);
      
       setExtendedState(MAXIMIZED_BOTH);
      setVisible(true);
      while(true){
          text.setVisible(false);
          try{
              Thread.sleep(500);
          }
          catch(Exception e){
              e.printStackTrace();
          }
          text.setVisible(true);
          try{
              Thread.sleep(500);
          }
          catch(Exception e){
              e.printStackTrace();
          }
      }
     
       // setVisible(true);
       
        
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
       
        
    }
    public static void main(String args[]){
        new Daku();
    }

    
    
}
