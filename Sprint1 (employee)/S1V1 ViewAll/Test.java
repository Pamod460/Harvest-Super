import java.util.List;

public class Test {
    public static void main(String[] args) {
<<<<<<< Updated upstream
        List<Gender> genders = GenderController.get();
        for (Gender gender:genders){
            System.out.println(gender.getId());
            System.out.println(gender.getName());
        }
=======
//        List<Gender> genders = GenderDao.getAll();
//        for (Gender gender : genders) {
//            System.out.println(gender.getId());
//            System.out.println(gender.getName());
//
//        }
//
//        List<EmployeeStatus> employeeStatuss = EmployeeStatusDao.getAll();
//        for (EmployeeStatus employeeStatus : employeeStatuss) {
//            System.out.println(employeeStatus.getId());
//            System.out.println(employeeStatus.getName());
//        }
//
//        List<Designation> designations = DesignationDao.getAll();
//        for (Designation designation : designations) {
//            System.out.println(designation.getId());
//            System.out.println(designation.getName());
//        }
        List<Employee> employees = EmployeeDao.getAll();
        for (Employee employee : employees) {
            System.out.println("Id = "+employee.getId());
            System.out.println("Name = "+employee.getName());
            System.out.println("Mobile = "+employee.getMobile());
            System.out.println("Address = "+employee.getAddress());
            System.out.println("Dssig = "+employee.getDesignation_id());
            System.out.println("EmpSts = "+employee.getEmployeeststus_id());
            System.out.println("Gender = "+employee.getGender_id().getName());

        }

//        Gender gender = GenderDao.getById(1);
//            System.out.println(gender.getId());
//            System.out.println(gender.getName());



>>>>>>> Stashed changes
    }
}
