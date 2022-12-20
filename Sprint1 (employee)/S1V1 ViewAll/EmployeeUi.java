import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class EmployeeUi extends JFrame {
    JTable tblEmployee;

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
        jspTable.setBounds(10,10,750,200);
        conn.add(jspTable);
        intitialize();
    }

    public void intitialize() {
        loadView();
    }

    public void loadView() {

        List<Employee> employeeList = EmployeeController.get();
        fillTable(employeeList);

    }

    public void fillTable(List<Employee> employees) {

        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();

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
