import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDao {

    public static Category getById(int id) {
        Category category = new Category();
        try {
            ResultSet result = CommonDao.get("select * from category where id = "+id);
            result.next();
            category.setId(result.getInt("id"));
            category.setName(result.getString("name"));
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());

        }
        return category;

    }
}

