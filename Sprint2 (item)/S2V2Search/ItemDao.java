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

        String sql = "select * from item";
        ResultSet result = CommonDao.get(sql);
        List<Item> items = get(result);
        return items;

    }

    public static List<Item> getByName(String name) {

        String sql = "select * from item where name like'" +name+"%'";
        ResultSet result = CommonDao.get(sql);
        List<Item> items = get(result);
        return items;

    }

    public static List<Item> getByItemStatus(ItemStatus itemstatus) {
        String sql =  "select * from item where itemstatus_id=" + itemstatus.getId();
        ResultSet result = CommonDao.get(sql);
        List<Item> items = get(result);
        return items;
    }

    public static List<Item> getBySubCategory(SubCategory subCategory) {

        String sql = "select * from item where subcategory_id=" + subCategory.getId();
        ResultSet result = CommonDao.get(sql);
        List<Item> items = get(result);
        return items;
    }

    public static List<Item> getByNameAndItemStatus(String name, ItemStatus itemStatus){

        String sql = "select * from item where name like'"+name+"%' and itemstatus_id=" + itemStatus.getId();
        ResultSet result = CommonDao.get(sql);
        List<Item> items = get(result);
        return items;
    }

    public static List<Item> getByNameAndSubCategory(String name, SubCategory subCategory) {

        String sql = "select * from item where name like '"+name+"%' and subcategory_id=" + subCategory.getId();
        ResultSet result = CommonDao.get(sql);
        List<Item> items = get(result);
        return items;
    }

    public static List<Item> getBySubCategoryAndItemStatus(SubCategory subCategory, ItemStatus itemStatus) {

        String sql = "select * from item where itemstatus_id=" + itemStatus.getId()+" and subcategory_id=" + subCategory.getId();
        ResultSet result = CommonDao.get(sql);
        List<Item> items = get(result);
        return items;
    }

    public static List<Item> getByAll(String name, ItemStatus itemStatus, SubCategory subCategory) {

        String sql = "select * from item where name like '"+name+"%' and itemstatus_id=" + itemStatus.getId()+" and subcategory_id=" + subCategory.getId();
        System.out.println(sql);
        ResultSet result = CommonDao.get(sql);
        List<Item> items = get(result);
        return items;
    }
}
