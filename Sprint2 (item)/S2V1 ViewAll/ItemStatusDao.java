import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemStatusDao {

    public static ItemStatus getById(int id) {
        ItemStatus itemStatus = new ItemStatus();
        try {
            ResultSet result = CommonDao.get("select * from itemstatus where id = "+id);
            result.next();
            itemStatus.setId(result.getInt("id"));
            itemStatus.setName(result.getString("name"));
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());

        }
        return itemStatus;

    }
}

