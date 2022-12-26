import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemStatusDao {


    public static List<ItemStatus> getAll(){
        List<ItemStatus> itemStatuses = new ArrayList<>();
        try {
            ResultSet result = CommonDao.get("select * from itemstatus");
            while (result.next()){
                ItemStatus itemStatus = new ItemStatus();
                itemStatus.setId(result.getInt("id"));
                itemStatus.setName(result.getString("name"));
                itemStatuses.add(itemStatus);
            }
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());
        }
        return itemStatuses;
    }


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

