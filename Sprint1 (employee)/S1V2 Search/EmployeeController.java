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
            Gender gender = (Gender) employeeHt.get("gender");
            EmployeeStatus employeeStatus = (EmployeeStatus) employeeHt.get("employeestatus");

            if (designation == null && gender == null && name != null && employeeStatus == null) {

                employees = EmployeeDao.getByName(name);

            } else if (designation != null && gender == null && name == null && employeeStatus == null) {

                employees = EmployeeDao.getByDesignation(designation);

            } else if (designation == null && gender != null && name == null && employeeStatus == null) {
                employees = EmployeeDao.getByGender(gender);
            }else if (designation == null && gender == null && name == null && employeeStatus != null) {
                employees = EmployeeDao.getByStatus(employeeStatus);
            } else if (designation == null && gender != null && name != null && employeeStatus == null) {
                employees = EmployeeDao.getByNameAndGender(name,gender);
            }else if (designation != null && gender == null && name != null && employeeStatus == null) {
                employees = EmployeeDao.getByNameAndDesignation(name,designation);
            }else if (designation == null && gender == null && name != null && employeeStatus != null) {
                employees = EmployeeDao.getByNameAndEmployeeStatus(name,employeeStatus);
            }else if (designation != null && gender != null && name == null && employeeStatus == null) {
                employees = EmployeeDao.getByGenderAndDesignation(gender,designation);
            }else if (designation == null && gender != null && name == null && employeeStatus != null) {
                employees = EmployeeDao.getByGenderAndStatus(gender,employeeStatus);
            }else if (designation != null && gender == null && name == null && employeeStatus != null) {
                employees = EmployeeDao.getByDesignationAndStatus(designation,employeeStatus);
            }else if (designation != null && gender != null && name != null && employeeStatus == null) {
                employees = EmployeeDao.getByNameGenderDesignation(name,gender,designation);
            }else if (designation == null && gender != null && name != null && employeeStatus != null) {
                employees = EmployeeDao.getByNameGenderStatus(name,gender,employeeStatus);
            }else if (designation != null && gender == null && name != null && employeeStatus != null) {
                employees = EmployeeDao.getByNameDesignationStatus(name,designation,employeeStatus);
            }else if (designation != null && gender != null && name == null && employeeStatus != null) {
                employees = EmployeeDao.getByGenderDesignationStatus(gender,designation,employeeStatus);
            }
            else if (designation != null && gender != null && name != null && employeeStatus != null) {
                employees = EmployeeDao.getByAll(name,gender,designation,employeeStatus);
            }

        }


        return employees;

    }


}
