import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public static List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            ResultSet result = CommonDao.get("select * from employee");
            while (result.next()) {
                Employee employee = new Employee();
                Gender gender = new Gender();
                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setMobile(result.getString("mobile"));
                employee.setAddress(result.getString("address"));
                employee.setDesignation(DesignationDao.getById(result.getInt("designation_id")));
                employee.setEmployeeststus(EmployeeStatusDao.getById(result.getInt("employeestatus_id")));

                employee.setGender(GenderDao.getById(result.getInt("gender_id")));
                
                employees.add(employee);
            }
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());

        }
        return employees;

    }
}
    
    

