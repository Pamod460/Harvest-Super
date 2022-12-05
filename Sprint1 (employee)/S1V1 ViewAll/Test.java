import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Gender> genders = GenderDao.getAll();
        for (Gender gender : genders) {
            System.out.println(gender.getId());
            System.out.println(gender.getName());

        }

        List<EmployeeStatus> employeeStatuss = EmployeeStatusDao.getAll();
        for (EmployeeStatus employeeStatus : employeeStatuss) {
            System.out.println(employeeStatus.getId());
            System.out.println(employeeStatus.getName());
        }
    }
}
