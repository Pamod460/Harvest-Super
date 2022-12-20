import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierStatusDao {
    public static SupplierStatus getById(int id) {

        SupplierStatus supplierStatus = new SupplierStatus();
        try {
            ResultSet result = CommonDao.get("select * from supplierStatus where id = " + id);
            result.next();
            supplierStatus.setId(result.getInt("id"));
            supplierStatus.setName(result.getString("name"));

        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());
        }
        return supplierStatus;
    }
    }
