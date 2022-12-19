import java.util.List;

public class ItemController {
    public static List<Item> get() {
        List<Item> itemList = ItemDao.getAll();
        return itemList;
    }
}
