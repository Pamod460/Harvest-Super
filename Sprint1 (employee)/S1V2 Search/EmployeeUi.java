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
    JComboBox<Designation> cmbSearchDesignation;
    JComboBox<Gender> cmbSearchGender;

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

        JLabel lblSearchName = new JLabel("Name");
        JLabel lblSearchGender = new JLabel("Gender");
        JLabel lblSearchDesignation = new JLabel("Designation");
        txtSearchName = new JTextField();
        btnSearch = new JButton("Search");
        btnSearchClear = new JButton("Clear Search");
        cmbSearchDesignation = new JComboBox();
        cmbSearchGender = new JComboBox();


        lblSearchName.setBounds(10, 70, 75, 30);
        lblSearchGender.setBounds(223, 70, 75, 30);
        lblSearchDesignation.setBounds(382, 70, 75, 30);
        txtSearchName.setBounds(12, 100, 200, 30);
        cmbSearchGender.setBounds(222, 100, 150, 30);
        cmbSearchDesignation.setBounds(382,100,150,30);
        btnSearch.setBounds(420, 140, 100, 30);
        btnSearchClear.setBounds(530, 140, 150, 30);


        conn.add(lblSearchName);
        conn.add(lblSearchGender);
        conn.add(lblSearchDesignation);
        conn.add(txtSearchName);
        conn.add(btnSearch);
        conn.add(btnSearchClear);
        conn.add(cmbSearchDesignation);
        conn.add(cmbSearchGender);




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

        for (Gender gender : genderList){
            genders.add(gender);
        }

        DefaultComboBoxModel<Gender> genderModel = new DefaultComboBoxModel(genders);
        cmbSearchGender.setModel(genderModel);



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
        employeeList = EmployeeController.get(null);
        fillTable(employeeList);

    }

    private void btnSearchAp(ActionEvent e) {
        String name = txtSearchName.getText();
        Object selectedDesig = cmbSearchDesignation.getSelectedItem();
        Designation designation = null;

        Object selectedGender = cmbSearchGender.getSelectedItem();
        Gender gender = null;


        if (!selectedDesig.equals("Select a Designation")) {
            designation = (Designation) selectedDesig;

        }
        if (!selectedGender.equals("Select a Gender")) {
            gender = (Gender) selectedGender;

        }
        Hashtable<String, Object> employeeHt = new Hashtable<>();
        if (!name.equals("")) {
            employeeHt.put("name", name);
        } else if (designation != null) {

            employeeHt.put("designation", designation);
        } else if (gender != null) {
            employeeHt.put("gender",gender);
        }

        employeeList = EmployeeController.get(employeeHt);
        fillTable(employeeList);



    }
}


