import java.util.List;

public class SupplierController {
    public static List<Supplier> get() {
        List<Supplier> suppliers = SupplierDao.getAll();
        return suppliers;
    }
}
