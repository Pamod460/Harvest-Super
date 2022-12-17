import java.util.Hashtable;
import java.util.List;

public class EmployeeController {

    public static List<Employee> get(Hashtable<String, Object> employeeHt) {
        List<Employee> employees = null;
        if (employeeHt==null){
            employees = EmployeeDao.getAll();
        }
        else {
            String name = employeeHt.get("name").toString();
            employees= EmployeeDao.getByName(name);
        }



        return employees;

    }
}
