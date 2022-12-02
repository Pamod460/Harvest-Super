import java.sql.*;

public class CommonDao {
    public  static ResultSet get(String qry){
        ResultSet result=null;
        try{
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/harvestsuper","admin","12345");
            Statement stm =conn.createStatement();
            result=stm.executeQuery(qry);

        }catch (SQLException Ex){
            System.out.println("Can't get Result As"+ Ex.getMessage());
        }
        return result;
    }
}
