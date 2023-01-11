import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class EmployeeUi extends JFrame {
    JTable tblEmployee;
    JTextField txtSearchName;
    JButton btnSearch;
    JButton btnSearchClear;
    List<Employee> employeeList = null;
    List<Designation> designationList = null;
    List<Gender> genderList = null;
    List<EmployeeStatus> employeeStatusList = null;
    JComboBox<Designation> cmbSearchDesignation;
    JComboBox<Gender> cmbSearchGender;
    JComboBox<EmployeeStatus> cmbSearchEmployeeStatus;

    EmployeeUi() {
        setTitle("Employee View");
        setLocation(200, 300);
        setSize(850, 400);


        Container conn = getContentPane();
        conn.setBackground(Color.LIGHT_GRAY);
        conn.setLayout(null);

        Vector titles = new Vector();
        titles.add("ID");
        titles.add("Staff Number");
        titles.add("Name");
        titles.add("DOB");
        titles.add("NIC");
        titles.add("Mobile");
        titles.add("Address");
        titles.add("Gender");
        titles.add("Status");
        titles.add("Designation");


        Vector data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblEmployee = new JTable();
        tblEmployee.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setViewportView(tblEmployee);
        jspTable.setBounds(10, 175, 800, 200);
        conn.add(jspTable);

        /**  Search area*/

        JLabel lblSearchName = new JLabel("Name :");
        JLabel lblSearchGender = new JLabel("Gender :");
        JLabel lblSearchDesignation = new JLabel("Designation :");
        JLabel lblSearchEmployeeStatus = new JLabel("Status :");
        txtSearchName = new JTextField();
        btnSearch = new JButton("Search");
        btnSearchClear = new JButton("Clear Search");
        cmbSearchDesignation = new JComboBox();
        cmbSearchGender = new JComboBox();
        cmbSearchEmployeeStatus = new JComboBox();


        lblSearchName.setBounds(10, 70, 75, 30);
        lblSearchGender.setBounds(223, 70, 75, 30);
        lblSearchDesignation.setBounds(382, 70, 75, 30);
        lblSearchEmployeeStatus.setBounds(541, 70, 75, 30);

        txtSearchName.setBounds(12, 100, 200, 30);
        cmbSearchGender.setBounds(222, 100, 150, 30);
        cmbSearchDesignation.setBounds(382, 100, 150, 30);
        cmbSearchEmployeeStatus.setBounds(542, 100, 150, 30);
        btnSearch.setBounds(420, 140, 100, 30);
        btnSearchClear.setBounds(530, 140, 150, 30);


        conn.add(lblSearchName);
        conn.add(lblSearchGender);
        conn.add(lblSearchDesignation);
        conn.add(lblSearchEmployeeStatus);
        conn.add(txtSearchName);
        conn.add(cmbSearchDesignation);
        conn.add(cmbSearchGender);
        conn.add(cmbSearchEmployeeStatus);
        conn.add(btnSearch);
        conn.add(btnSearchClear);


        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchAp(e);
            }
        });
        btnSearchClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchClearAp(e);
            }
        });

        intitialize();
    }

    public void intitialize() {
        loadView();
    }

    public void loadView() {
        employeeList = EmployeeController.get(null);
        fillTable(employeeList);

        designationList = DesignationController.get();
        Vector<Object> designations = new Vector();
        designations.add("Select a Designation");

        for (Designation designation : designationList) {
            designations.add(designation);
        }

        DefaultComboBoxModel<Designation> designationModel = new DefaultComboBoxModel(designations);
        cmbSearchDesignation.setModel(designationModel);

        genderList = GenderController.get();
        Vector<Object> genders = new Vector();
        genders.add("Select a Gender");

        for (Gender gender : genderList) {
            genders.add(gender);
        }

        DefaultComboBoxModel<Gender> genderModel = new DefaultComboBoxModel(genders);
        cmbSearchGender.setModel(genderModel);

        employeeStatusList = EmployeeStatusController.get();
        Vector<Object> employeeStatuses = new Vector<>();
        employeeStatuses.add("Select a Status");

        for (EmployeeStatus sts : employeeStatusList) {
            employeeStatuses.add(sts);
        }

        DefaultComboBoxModel<EmployeeStatus> stsModel = new DefaultComboBoxModel(employeeStatuses);
        cmbSearchEmployeeStatus.setModel(stsModel);

    }

    public void fillTable(List<Employee> employees) {

        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        model.setRowCount(0);
        for (Employee employee : employees) {

            Vector rows = new Vector();
            rows.add(employee.getId());
            rows.add(employee.getStaffnumber());
            rows.add(employee.getName());
            rows.add(employee.getDob());
            rows.add(employee.getNic());
            rows.add(employee.getMobile());
            rows.add(employee.getAddress());
            rows.add(employee.getGender().getName());
            rows.add(employee.getEmployeeststus().getName());
            rows.add(employee.getDesignation().getName());
            model.addRow(rows);
        }

    }

    private void btnSearchClearAp(ActionEvent e) {
        txtSearchName.setText("");
        cmbSearchDesignation.setSelectedIndex(0);
        cmbSearchGender.setSelectedIndex(0);
        cmbSearchEmployeeStatus.setSelectedIndex(0);
        employeeList = EmployeeController.get(null);
        fillTable(employeeList);

    }

    private void btnSearchAp(ActionEvent e) {
        String name = txtSearchName.getText();
        Object selectedDesig = cmbSearchDesignation.getSelectedItem();
        Designation designation = null;

        Object selectedGender = cmbSearchGender.getSelectedItem();
        Gender gender = null;

        Object selectedStatus = cmbSearchEmployeeStatus.getSelectedItem();
        EmployeeStatus status = null;


        assert selectedDesig != null;
        if (!selectedDesig.equals("Select a Designation")) {
            designation = (Designation) selectedDesig;

        }
        assert selectedGender != null;
        if (!selectedGender.equals("Select a Gender")) {
            gender = (Gender) selectedGender;

        }
        assert selectedStatus != null;
        if (!selectedStatus.equals("Select a Status")) {
            status = (EmployeeStatus) selectedStatus;

        }
        Hashtable<String, Object> employeeHt = new Hashtable<>();
        if (!name.equals("") && designation == null && gender == null && status == null) {
            employeeHt.put("name", name);
        } else if (name.equals("") && designation != null && gender == null && status == null) {
            employeeHt.put("designation", designation);
        } else if (name.equals("") && designation == null && gender != null && status == null) {
            employeeHt.put("gender", gender);
        } else if (name.equals("") && designation == null && gender == null && status != null) {
            employeeHt.put("employeestatus", status);
        } else if (!name.equals("") && designation == null && gender != null && status == null) {
            employeeHt.put("name", name);
            employeeHt.put("gender", gender);
        } else if (!name.equals("") && designation != null && gender == null && status == null) {
            employeeHt.put("name", name);
            employeeHt.put("designation", designation);
        } else if (!name.equals("") && designation == null && gender == null && status != null) {
            employeeHt.put("name", name);
            employeeHt.put("employeestatus", status);
        } else if (!name.equals("") && designation != null && gender != null && status != null) {
            employeeHt.put("name", name);
            employeeHt.put("designation", designation);
            employeeHt.put("gender", gender);
            employeeHt.put("employeestatus", status);
        } else {
            employeeHt = null;
        }

        employeeList = EmployeeController.get(employeeHt);
        fillTable(employeeList);

    }

}


