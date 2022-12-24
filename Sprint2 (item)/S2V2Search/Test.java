import java.util.List;

import javax.swing.JFrame;

public class Test {
    public static void main(String[] args) {

        List<Item> items = ItemDao.getAll();
        for (Item item : items) {

            System.out.println("Id = "+item.getId());
            System.out.println("Code = "+item.getCode());
            System.out.println("Name = "+item.getName());
            System.out.println("Quentity = "+item.getQuentity());
            System.out.println("Saleprice = "+item.getSaleprice());
            System.out.println("Purcheseprice = "+item.getPurcheseprice());
            System.out.println("Subcategory = "+item.getSubcategory().getName());
//            System.out.println("Category = "+item.getCategory().getName());
            System.out.println("itemstatus = " + item.getItemStatus().getName());

        }

        ItemUi itemUi = new ItemUi();
        itemUi.setVisible(true);
        itemUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
/// ui