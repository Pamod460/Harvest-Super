import java.sql.ResultSet;
import java.sql.SQLException;

public class SubCategoryDao {

    public static SubCategory getById(int id) {

        SubCategory subCategory = new SubCategory();
        try {
            ResultSet result = CommonDao.get("select * from subcategory where id = "+id);
            result.next();
            subCategory.setId(result.getInt("id"));
            subCategory.setName(result.getString("name"));
            subCategory.setCategory(CategoryDao.getById(result.getInt("category_id")));
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());
        }
        return subCategory;

    }
}

