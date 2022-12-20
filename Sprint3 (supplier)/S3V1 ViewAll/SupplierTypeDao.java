import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierTypeDao {
    public static SupplierType getById(int id) {

        SupplierType supplierType = new SupplierType();
        try {
            ResultSet result = CommonDao.get("select * from suppliertype where id = "+id);
            result.next();
            supplierType.setId(result.getInt("id"));
            supplierType.setName(result.getString("name"));

        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());
        }
        return supplierType;

    }}
