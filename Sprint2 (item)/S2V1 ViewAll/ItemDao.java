import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {

    public static List<Item> getAll() {
        List<Item> items = new ArrayList<>();
        try {
            ResultSet result = CommonDao.get("select * from item");
            while (result.next()) {
                Item Item = new Item();
                Item.setId(result.getInt("id"));
                Item.setCode(result.getString("code"));
                Item.setName(result.getString("name"));
                Item.setQuentity(result.getInt("quentity"));
                Item.setSaleprice(result.getDouble("saleprice"));
                Item.setPurcheseprice(result.getDouble("purchaseprice"));
                Item.setSubcategory_id(result.getInt("subcategory_id"));
                Item.setCategory_id(result.getInt("category_id"));
                items.add(Item);
            }
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());

        }

        return items;

    }

}
