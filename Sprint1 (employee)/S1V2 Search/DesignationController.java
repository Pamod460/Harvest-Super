import java.util.List;

public class DesignationController {
    public static List<Designation> get() {
        List<Designation> designationsList = null;
        designationsList = DesignationDao.getAll();
        return designationsList;
    }


}
