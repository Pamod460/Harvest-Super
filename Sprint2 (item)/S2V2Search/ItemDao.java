import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {


    public static  List<Item> get(ResultSet result){
        List<Item> items = new ArrayList<>();
        try {

            while (result.next()) {
                Item Item = new Item();
                Item.setId(result.getInt("id"));
                Item.setCode(result.getString("code"));
                Item.setName(result.getString("name"));
                Item.setQuentity(result.getInt("quentity"));
                Item.setSaleprice(result.getDouble("saleprice"));
                Item.setPurcheseprice(result.getDouble("purchaseprice"));
                Item.setSubcategory(SubCategoryDao.getById(result.getInt("subcategory_id")));
//                Item.setCategory(CategoryDao.getById(result.getInt("category_id")));
                Item.setItemStatus(ItemStatusDao.getById(result.getInt("itemstatus_id")));
                items.add(Item);

            }
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());

        }

        return items;
    }


    public static List<Item> getAll() {
        ResultSet result = CommonDao.get("select * from item");
        List<Item> items = get(result);
        return items;

    }

    public static List<Item> getByName(String name) {
        ResultSet result = CommonDao.get("select * from item where name like'" +name+"%'");
        List<Item> items = get(result);
        return items;

    }

    public static List<Item> getByItemStatus(ItemStatus itemstatus) {
        ResultSet result = CommonDao.get("select * from item where itemstatus_id=" + itemstatus.getId());
        List<Item> items = get(result);
        return items;
    }

    public static List<Item> getBySubCategory(SubCategory subCategory) {
        ResultSet result = CommonDao.get("select * from item where subcategory_id=" + subCategory.getId());
        List<Item> items = get(result);
        return items;
    }

}
