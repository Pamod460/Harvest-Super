import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplyDao {
    public static Supply getById(int id) {

        Supply supply = new Supply();
        try {
            ResultSet result = CommonDao.get("select * from supply where id = "+id);
            result.next();
            supply.setId(result.getInt("id"));
            supply.setSupplier(SupplierDao.getById( result.getInt("subcategory_id")));
            supply.setSubcategory(result.getInt("subcategory_id"));
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());
        }
        return supply;

    }
}
