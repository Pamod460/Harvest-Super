import java.awt.Container;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ItemUi extends JFrame {

    JTable tblItem;

    ItemUi() {
        setTitle("Item View");
        setLocation(200, 300);
        setSize(850, 400);

        Container con = getContentPane();
        con.setLayout(null);

        Vector titles = new Vector();
        titles.add("ID");
        titles.add("Code");
        titles.add("Name");
        titles.add("Quantity");
        titles.add("Sale Price");
        titles.add("Purchase Price");
        titles.add("Category");
        titles.add("Subcategory");
        titles.add("Item Status");

        Vector data = new Vector();
        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblItem = new JTable();
        tblItem.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setViewportView(tblItem);
        jspTable.setBounds(10, 10, 750, 200);
        con.add(jspTable);

        initialize();

    }

    private void initialize() {
        loadView();
    }

    public void loadView() {
        List<Item> itemList = ItemController.get();
        fillTable(itemList);
    }

    public void fillTable(List<Item> items) {
        DefaultTableModel model = (DefaultTableModel) tblItem.getModel();

        for (Item item : items) {
            Vector rows = new Vector<>();
            rows.add(item.getId());
            rows.add(item.getCode());
            rows.add(item.getName());
            rows.add(item.getQuentity());
            rows.add(item.getSaleprice());
            rows.add(item.getPurcheseprice());
            rows.add(item.getCategory().getName());
            rows.add(item.getSubcategory().getName());
            rows.add(item.getItemStatus().getName());

            model.addRow(rows);
        }
    }
}
