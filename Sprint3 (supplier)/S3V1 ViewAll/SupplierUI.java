import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;
import java.util.Vector;

public class SupplierUI extends JFrame {
    JTable tblSupplier;

    public SupplierUI()  {
        setTitle("Supplier View");
        setLocation(200, 300);
        setSize(900, 400);


        Container conn = getContentPane();
        conn.setBackground(Color.LIGHT_GRAY);
        conn.setLayout(null);

        Vector titles = new Vector();
        titles.add("ID");
        titles.add("Name");
        titles.add("Mobile");
        titles.add("Land");
        titles.add("Reg. No.");
        titles.add("Address");
        titles.add("Docommenced");
        titles.add("Dostrared");
        titles.add("ContactPerson");
        titles.add("SupplierType");
        titles.add("SupplierStatus");


        Vector data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblSupplier = new JTable();
        tblSupplier.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setViewportView(tblSupplier);
        jspTable.setBounds(10,10,870,200);
        conn.add(jspTable);
        intitialize();
    }

    public void intitialize() {
        loadView();
    }

    public void loadView() {

        List<Supplier> supplierList = SupplierController.get();
        fillTable(supplierList);

    }

    public void fillTable(List<Supplier> suppliers) {

        DefaultTableModel model = (DefaultTableModel) tblSupplier.getModel();

        for (Supplier supplier : suppliers) {
            Vector rows = new Vector();
            rows.add(supplier.getId());
            rows.add(supplier.getName());
            rows.add(supplier.getTpMobile());
            rows.add(supplier.getTpLand());
            rows.add(supplier.getRegNo());
            rows.add(supplier.getAddress());
            rows.add(supplier.getDocommenced());
            rows.add(supplier.getDostrared());
            rows.add(supplier.getContactPerson());
            rows.add(supplier.getSupplierType().getName());
            rows.add(supplier.getSupplierStatus().getName());

            model.addRow(rows);
        }

    }
}
