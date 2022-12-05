import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeStatusDao {

    public static List<EmployeeStatus> getAll() {
        List<EmployeeStatus> employeeStatuss = new ArrayList<>();
        try {
            ResultSet result = CommonDao.get("select * from employeeStatus");
            while (result.next()) {
                EmployeeStatus employeeStatus = new EmployeeStatus();
                employeeStatus.setId(result.getInt("id"));
                employeeStatus.setName(result.getString("name"));
                employeeStatuss.add(employeeStatus);
            }
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());

        }
        return employeeStatuss;

    }
}
    
    

