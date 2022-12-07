import java.util.List;

public class EmployeeController {

    public static List<Employee> get() {

        List<Employee> employees = null;

        employees = EmployeeDao.getAll();

        return employees;

    }
}
