import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDao {
    public static Supplier getById(int id) {

        Supplier supplier = new Supplier();
        try {
            ResultSet result = CommonDao.get("select * from supplier where id = " + id);
            result.next();
            supplier.setId(result.getInt("id"));
            supplier.setName(result.getString("name"));
            supplier.setTpMobile(result.getString("tpmobile"));
            supplier.setTpLand(result.getString("tpland"));
            supplier.setRegNo(result.getString("regno"));
            supplier.setAddress(result.getString("address"));
            supplier.setDocommenced(result.getString("docommenced"));
            supplier.setDostrared(result.getString("dostrared"));
            supplier.setContactPerson(result.getString("contactperson"));
            supplier.setSupplierType(SupplierTypeDao.getById(result.getInt("suppliertype_id")));
            supplier.setSupplierStatus(SupplierStatusDao.getById(result.getInt("supplierstatus_id")));
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());
        }
        return supplier;

    }

    public static List<Supplier> getAll() {

        List<Supplier> suppliers = new ArrayList<>();
        try {
            ResultSet result = CommonDao.get("select * from supplier");
            while (result.next()) {
                Supplier supplier = new Supplier();
                supplier.setId(result.getInt("id"));
                supplier.setName(result.getString("name"));
                supplier.setTpMobile(result.getString("tpmobile"));
                supplier.setTpLand(result.getString("tpland"));
                supplier.setRegNo(result.getString("regno"));
                supplier.setAddress(result.getString("address"));
                supplier.setDocommenced(result.getString("docommenced"));
                supplier.setDostrared(result.getString("dostrared"));
                supplier.setContactPerson(result.getString("contactperson"));
                supplier.setSupplierType(SupplierTypeDao.getById(result.getInt("suppliertype_id")));
                supplier.setSupplierStatus(SupplierStatusDao.getById(result.getInt("supplierstatus_id")));
                suppliers.add(supplier);
            }
        } catch (SQLException Ex) {
            System.out.println("Can't Get Results as : " + Ex.getMessage());
        }
        return suppliers;

    }
}
