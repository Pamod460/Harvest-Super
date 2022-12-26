import java.util.Hashtable;
import java.util.List;

public class ItemController {


    public static List<Item> get(Hashtable <String,Object> itemHt){
        List<Item> itemList = null;
        if (itemHt == null) {
             itemList = ItemDao.getAll();
        } else{
            String name =(String) itemHt.get("name");
            ItemStatus itemStatus =(ItemStatus) itemHt.get("status");
            SubCategory subCategory =(SubCategory) itemHt.get("subcategory");

            if(subCategory == null && itemStatus == null && name != null){
                itemList = ItemDao.getByName(name);
            } else if(subCategory == null && itemStatus != null && name == null) {
                itemList = ItemDao.getByItemStatus(itemStatus);
            } else if (subCategory != null && itemStatus == null && name == null) {
                itemList = ItemDao.getBySubCategory(subCategory);
            }
        }

        return itemList;
    }

}
