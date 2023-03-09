import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public static List<Employee> setData(ResultSet result) {
        List<Employee> employees = new ArrayList<>();
        try {
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

    public static List<Employee> getAll() {
        ResultSet result = CommonDao.get("select * from employee");
        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByName(String name) {
        ResultSet result = CommonDao.get("select * from employee where name like '" + name + "%'");
        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByDesignation(Designation designation) {
        ResultSet result = CommonDao.get("select * from employee where designation_id=" + designation.getId());
        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByGender(Gender gender) {
        ResultSet result = CommonDao.get("select * from employee where gender_id=" + gender.getId());

        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByStatus(EmployeeStatus employeeStatus) {
        ResultSet result = CommonDao.get("select * from employee where employeestatus_id=" + employeeStatus.getId());
        List<Employee> employees = setData(result);
        return employees;
    }
    public static List<Employee> getByNameAndGender(String name, Gender gender) {
        ResultSet result = CommonDao.get("select * from employee where name like '"+name+"%' and  gender_id="+gender.getId());
        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByNameAndDesignation(String name, Designation designation) {
        ResultSet result = CommonDao.get("select * from employee where name like '"+name+"%' and designation_id="+designation.getId());
        List<Employee> employees = setData(result);
        return employees;

    }

    public static List<Employee> getByNameAndEmployeeStatus(String name, EmployeeStatus employeeStatus) {
        ResultSet result = CommonDao.get("select * from employee where name like '"+name+"%' and employeestatus_id="+employeeStatus.getId() );
        List<Employee> employees = setData(result);
        return employees;

    }
    public  static  List<Employee> getByAll(String name,Gender gender,Designation designation,EmployeeStatus employeeStatus){
        ResultSet result = CommonDao.get("select * from employee where name like '"+name+"%' and  gender_id="+gender.getId()+" and designation_id="+designation.getId()+" and employeestatus_id="+employeeStatus.getId() );
        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByGenderAndDesignation(Gender gender, Designation designation) {
        ResultSet result = CommonDao.get("select * from employee where gender_id="+gender.getId()+" and designation_id="+designation.getId());
        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByGenderAndStatus(Gender gender, EmployeeStatus employeeStatus) {
        ResultSet result = CommonDao.get("select * from employee where gender_id="+gender.getId()+" and employeestatus_id="+employeeStatus.getId() );
        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByDesignationAndStatus(Designation designation, EmployeeStatus employeeStatus) {
        ResultSet result = CommonDao.get("select * from employee where designation_id="+designation.getId()+" and employeestatus_id="+employeeStatus.getId() );
        List<Employee> employees = setData(result);
        return employees;
    }


    public static List<Employee> getByNameGenderDesignation(String name, Gender gender, Designation designation) {
        ResultSet result = CommonDao.get("select * from employee where name like '"+name+"%' and  gender_id="+gender.getId()+" and designation_id="+designation.getId() );
        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByNameGenderStatus(String name, Gender gender, EmployeeStatus employeeStatus) {
        ResultSet result = CommonDao.get("select * from employee where name like '"+name+"%' and  gender_id="+gender.getId()+" and employeestatus_id="+employeeStatus.getId() );
        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByNameDesignationStatus(String name, Designation designation, EmployeeStatus employeeStatus) {
        ResultSet result = CommonDao.get("select * from employee where name like '"+name+"%' and designation_id="+designation.getId()+" and employeestatus_id="+employeeStatus.getId() );
        List<Employee> employees = setData(result);
        return employees;
    }

    public static List<Employee> getByGenderDesignationStatus(Gender gender, Designation designation, EmployeeStatus employeeStatus) {
        ResultSet result = CommonDao.get("select * from employee where gender_id="+gender.getId()+" and designation_id="+designation.getId()+" and employeestatus_id="+employeeStatus.getId() );
        List<Employee> employees = setData(result);
        return employees;
    }
}
