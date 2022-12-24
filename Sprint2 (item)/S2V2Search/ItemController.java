import java.util.Hashtable;
import java.util.List;

public class ItemController {


    public static List<Item> get(Hashtable <String,Object> itemHt){

        List<Item> itemList = null;
        if (itemHt == null) {
             itemList = ItemDao.getAll();

        } else{
            String name =(String) itemHt.get("name");
            itemList = ItemDao.getByName(name);
        }

        return itemList;
    }

}
