public class Supply {
private int id;
private Supplier supplier;
private int Subcategory;

    public Supply() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getSubcategory() {
        return Subcategory;
    }

    public void setSubcategory(int subcategory) {
        Subcategory = subcategory;
    }
}
