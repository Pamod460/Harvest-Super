import java.util.List;

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
            System.out.println("Subcategory_id = "+item.getSubcategory_id());
            System.out.println("Category_id = "+item.getCategory_id());

        }
    }
}
