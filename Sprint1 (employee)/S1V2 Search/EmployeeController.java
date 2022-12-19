import java.util.Hashtable;
import java.util.List;

public class EmployeeController {

    public static List<Employee> get(Hashtable<String, Object> employeeHt) {
        List<Employee> employees = null;
        if (employeeHt == null) {
            employees = EmployeeDao.getAll();
        } else {
            String name = (String) employeeHt.get("name");
            Designation designation = (Designation) employeeHt.get("designation");

            if (designation == null) {
                employees = EmployeeDao.getByName(name);
            } else if (name == null) {
                employees = EmployeeDao.getByDesignation(designation);
            }
        }


        return employees;

    }
}
