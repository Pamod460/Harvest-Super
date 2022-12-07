public class Employee {
    private int id;
    private String staffnumber;
    private String name;
    private String dob;
    private String nic;
    private String mobile;
    private String address;
    private EmployeeStatus employeeststus;
    private int designation_id;
    private Gender gender;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffnumber() {
        return staffnumber;
    }

    public void setStaffnumber(String staffnumber) {
        this.staffnumber = staffnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getEmployeeststus() {
        return employeeststus;
    }

    public void setEmployeeststus(EmployeeStatus employeeststus) {
        this.employeeststus = employeeststus;
    }

    public int getDesignation_id() {
        return designation_id;
    }

    public void setDesignation_id(int designation_id) {
        this.designation_id = designation_id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
