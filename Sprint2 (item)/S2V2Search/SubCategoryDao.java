import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryDao {

    public static List<SubCategory> getAll(){
        List<SubCategory> subCategories = new ArrayList<>();
        try {
            ResultSet result = CommonDao.get("select * from subcategory");
            while (result.next()){
                SubCategory subcategory = new SubCategory();
                subcategory.setId(result.getInt("id"));
                subcategory.setName(result.getString("name"));
                subCategories.add(subcategory);
            }
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());
        }
        return subCategories;
    }

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

