import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeDao.getAll();
        for (Employee employee : employees) {
            System.out.println("Id = "+employee.getId());
            System.out.println("Name = "+employee.getName());
            System.out.println("Mobile = "+employee.getMobile());
            System.out.println("Address = "+employee.getAddress());
            System.out.println("Dssig = "+employee.getDesignation_id());
            System.out.println("EmpSts = "+employee.getEmployeeststus().getName());
            System.out.println("Gender = "+employee.getGender().getName());

        }
    }
}
