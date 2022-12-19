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
                employee.setId(result.getInt("id"));
                employee.setStaffnumber(result.getString("staffnumber"));
                employee.setName(result.getString("name"));
                employee.setDob(result.getString("dob"));
                employee.setNic(result.getString("nic"));
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

    public static List<Employee> getByName(String name) {
        List<Employee> employees = new ArrayList<>();
        try {
            ResultSet result = CommonDao.get("select * from employee where name like '" + name + "%'");
            while (result.next()) {
                Employee employee = new Employee();
                employee.setId(result.getInt("id"));
                employee.setStaffnumber(result.getString("staffnumber"));
                employee.setName(result.getString("name"));
                employee.setDob(result.getString("dob"));
                employee.setNic(result.getString("nic"));
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

    public static List<Employee> getByDesignation(Designation designation) {
        List<Employee> employees = new ArrayList<>();
        try {
            ResultSet result = CommonDao.get("select * from employee where designation_id=" + designation.getId());
            while (result.next()) {
                Employee employee = new Employee();
                employee.setId(result.getInt("id"));
                employee.setStaffnumber(result.getString("staffnumber"));
                employee.setName(result.getString("name"));
                employee.setDob(result.getString("dob"));
                employee.setNic(result.getString("nic"));
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

    public static List<Employee> getByGender(Gender gender) {
        List<Employee> employees = new ArrayList<>();
        try {
            ResultSet result = CommonDao.get("select * from employee where gender_id=" + gender.getId());
            while (result.next()) {
                Employee employee = new Employee();
                employee.setId(result.getInt("id"));
                employee.setStaffnumber(result.getString("staffnumber"));
                employee.setName(result.getString("name"));
                employee.setDob(result.getString("dob"));
                employee.setNic(result.getString("nic"));
                employee.setMobile(result.getString("mobile"));
                employee.setAddress(result.getString("address"));
                employee.setGender(GenderDao.getById(result.getInt("gender_id")));
                employee.setEmployeeststus(EmployeeStatusDao.getById(result.getInt("employeestatus_id")));
                employee.setDesignation(DesignationDao.getById(result.getInt("designation_id")));

                employees.add(employee);
            }
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());

        }
        return employees;
    }

}
    
    

