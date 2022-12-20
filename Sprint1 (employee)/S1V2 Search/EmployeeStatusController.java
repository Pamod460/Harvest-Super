import java.util.List;

public class EmployeeStatusController {

    public static List<EmployeeStatus> get(){
        List<EmployeeStatus> employeeStatuses = null;
        employeeStatuses = EmployeeStatusDao.getAll();
        return employeeStatuses;
    }

}
