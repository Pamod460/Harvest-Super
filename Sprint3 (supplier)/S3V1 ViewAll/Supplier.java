public class Supplier {

    private int id;
    private String name;
    private String tpMobile;
    private String tpLand;
    private String regNo;
    private String address;
    private String docommenced;
    private String dostrared;
    private String contactPerson;
    private SupplierType supplierType;
    private SupplierStatus supplierStatus;

    public Supplier() {
    }

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

    public String getTpMobile() {
        return tpMobile;
    }

    public void setTpMobile(String tpMobile) {
        this.tpMobile = tpMobile;
    }

    public String getTpLand() {
        return tpLand;
    }

    public void setTpLand(String tpLand) {
        this.tpLand = tpLand;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDocommenced() {
        return docommenced;
    }

    public void setDocommenced(String docommenced) {
        this.docommenced = docommenced;
    }

    public String getDostrared() {
        return dostrared;
    }

    public void setDostrared(String dostrared) {
        this.dostrared = dostrared;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public SupplierType getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(SupplierType supplierType) {
        this.supplierType = supplierType;
    }

    public SupplierStatus getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(SupplierStatus supplierStatus) {
        this.supplierStatus = supplierStatus;
    }
}
