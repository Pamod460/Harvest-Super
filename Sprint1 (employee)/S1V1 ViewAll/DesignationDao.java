import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesignationDao {

    public static List<Designation> getAll() {
        List<Designation> designations = new ArrayList<>();
        try {
            ResultSet result = CommonDao.get("select * from designation");
            while (result.next()) {
                Designation designation = new Designation();
                designation.setId(result.getInt("id"));
                designation.setName(result.getString("name"));
                designations.add(designation);
            }
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());

        }
        
        return designations;

    }
    public static Designation getById(int id) {
        Designation designation = new Designation();
        try {
            ResultSet result = CommonDao.get("select * from designation where id = "+id);
            result.next();
            designation.setId(result.getInt("id"));
            designation.setName(result.getString("name"));
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());

        }
        return designation;

    }
}
