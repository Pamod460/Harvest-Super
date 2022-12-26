public class ItemStatus {

    private  int id;
    private  String name;

    ItemStatus(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String toString(){
        return  name;
    }
}
