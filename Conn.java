
package javaimageinframe;
import java.sql.*;

public class Conn {
    Connection c; 
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","12345678969");
            s=c.createStatement(); 
        }
      catch(Exception e){
       e.printStackTrace();
      }
    }
}


