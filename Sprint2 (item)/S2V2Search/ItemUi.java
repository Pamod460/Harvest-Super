import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ItemUi extends JFrame {

    JTable tblItem;

    JComboBox cmbSearchItemStatus;
    JComboBox cmbSearchSubCategory;

    List<Item> itemList = null;

    List<SubCategory> SubCategoryList = null;

    List<ItemStatus> itemStatusList = null;

    JTextField txtSearchName;
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
        titles.add("Subcategory");
        titles.add("Item Status");

        Vector data = new Vector();
        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblItem = new JTable();
        tblItem.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setViewportView(tblItem);
        jspTable.setBounds(10, 175, 800, 200);
        con.add(jspTable);


        //===========Search=============

        JLabel lblSearchName = new JLabel("NAME :");
        JLabel lblSearchItemStatus = new JLabel("STATUS :");
        JLabel lblSearchSubCategory = new JLabel("CATEGORY :");
        cmbSearchItemStatus = new JComboBox();
        cmbSearchSubCategory = new JComboBox();


        JButton btnSearch = new JButton("Search");
        JButton btnSearchClear  = new JButton("Clear Search");
        txtSearchName = new JTextField();


        lblSearchName.setBounds(10, 70, 75, 30);
        lblSearchItemStatus.setBounds(223, 70, 75, 30);
        lblSearchSubCategory.setBounds(382, 70, 75, 30);
        txtSearchName.setBounds(12, 100, 200, 30);
        cmbSearchItemStatus.setBounds(222, 100, 150, 30);
        cmbSearchSubCategory.setBounds(382,100,150,30);
        btnSearch.setBounds(420, 140, 100, 30);
        btnSearchClear.setBounds(530, 140, 150, 30);

        con.add(lblSearchName);
        con.add(btnSearch);
        con.add(btnSearchClear);
        con.add(txtSearchName);
        con.add(lblSearchItemStatus);
        con.add(lblSearchSubCategory);
        con.add(cmbSearchItemStatus);
        con.add(cmbSearchSubCategory);

        btnSearch.addActionListener(e -> {btnSearchAp(e);});
        btnSearchClear.addActionListener(e -> {btnSearchClearAp(e);});

        initialize();
    }
    private void initialize() {
        loadView();
    }

    public void loadView() {

        itemList = ItemController.get(null);
        fillTable(itemList);

        itemStatusList = ItemStatusController.get();
        Vector<Object> itemstatuses = new Vector();
        itemstatuses.add("Select a Status");

        for (ItemStatus itemstatus : itemStatusList){
            itemstatuses.add(itemstatus);
        }
        DefaultComboBoxModel<ItemStatus> ItemStatusModel = new DefaultComboBoxModel(itemstatuses);
        cmbSearchItemStatus.setModel(ItemStatusModel);


        SubCategoryList = SubCategoryController.get();
        Vector<Object> subcatogry = new Vector();
        subcatogry.add("Select a Category");

        for (SubCategory subCategories : SubCategoryList){
            subcatogry.add(subCategories);
        }
        DefaultComboBoxModel<SubCategory> SubCategoryModel = new DefaultComboBoxModel(subcatogry);
        cmbSearchSubCategory.setModel(SubCategoryModel);

    }

    public void fillTable(List<Item> items) {
        DefaultTableModel model = (DefaultTableModel) tblItem.getModel();
        model.setRowCount(0);

        for(Item item : items) {

            Vector rows = new Vector<>();
            rows.add(item.getId());
            rows.add(item.getCode());
            rows.add(item.getName());
            rows.add(item.getQuentity());
            rows.add(item.getSaleprice());
            rows.add(item.getPurcheseprice());
            rows.add(item.getSubcategory().getName());
            rows.add(item.getItemStatus().getName());

            model.addRow(rows);
        }
    }

    private void btnSearchAp(ActionEvent e){

        String name = txtSearchName.getText();

        Object selectedItemStatus = cmbSearchItemStatus.getSelectedItem();
        ItemStatus itemstatus = null;

        Object selectedSubCategory = cmbSearchSubCategory.getSelectedItem();
        SubCategory subcatogory = null;

        if (!selectedItemStatus.equals("Select a Status")) {
            itemstatus = (ItemStatus) selectedItemStatus;
        }
        if (!selectedSubCategory.equals("Select a Category")) {
            subcatogory = (SubCategory) selectedSubCategory;
        }

        Hashtable <String , Object> itemHt = new Hashtable<>();
        if (!name.equals("")) {
            itemHt.put("name" , name);
        } else if (itemstatus != null) {
            itemHt.put("status" , itemstatus);
        } else if (subcatogory != null) {
            itemHt.put("subcategory" , subcatogory);
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter Value");
            itemHt = null;
        }
        itemList = ItemController.get(itemHt);
        fillTable(itemList);
    }

    private void btnSearchClearAp(ActionEvent e) {
        txtSearchName.setText("");
        cmbSearchItemStatus.setSelectedItem(0);
        cmbSearchSubCategory.setSelectedItem(0);
        loadView();
    }
}



