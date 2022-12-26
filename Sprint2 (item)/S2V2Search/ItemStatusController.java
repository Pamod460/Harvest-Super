import java.util.List;

public class ItemStatusController {

    public static List<ItemStatus> get(){

        List<ItemStatus> itemStatusList = null;
        itemStatusList = ItemStatusDao.getAll();
        return itemStatusList;
    }

}
