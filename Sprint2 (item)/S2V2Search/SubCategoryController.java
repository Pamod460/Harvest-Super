import java.util.List;

public class SubCategoryController {
    public static List<SubCategory> get(){

        List<SubCategory> SubCategoryList = null;
        SubCategoryList = SubCategoryDao.getAll();
        return SubCategoryList;
    }
}
