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
    List<Employee> employeeList=null;

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
        jspTable.setBounds(10, 150, 750, 200);
        conn.add(jspTable);
        intitialize();

        /**  Search area*/

        JLabel lblSearchName = new JLabel("Name");
        txtSearchName = new JTextField();
        btnSearch = new JButton("Search");
        btnSearchClear = new JButton("Clear Search");

        lblSearchName.setBounds(10, 100, 100, 30);
        txtSearchName.setBounds(110, 100, 150, 30);
        btnSearch.setBounds(420, 100, 100, 30);
        btnSearchClear.setBounds(530, 100, 150, 30);
        conn.add(lblSearchName);
        conn.add(txtSearchName);
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


    }

    private void btnSearchClearAp(ActionEvent e) {
        txtSearchName.setText("");
        employeeList = EmployeeController.get(null);
        fillTable(employeeList);

    }

    private void btnSearchAp(ActionEvent e) {
        String name = txtSearchName.getText();
        Hashtable<String, Object> employeeHt = new Hashtable<>();
        employeeHt.put("name", name);
        employeeList = EmployeeController.get(employeeHt);
        fillTable(employeeList);
    }

    public void intitialize() {
        loadView();
    }

    public void loadView() {
        employeeList = EmployeeController.get(null);
        fillTable(employeeList);

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
}
