package entity;

public class Customer implements SuperEntity{
    private String id;
    private String name;
    private String address;
    private String contact;
    private String nic;
    private String carNumber;
    private String carModel;

    public Customer(String id, String name, String address, String contact, String nic, String carNumber, String carModel) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.nic = nic;
        this.carNumber = carNumber;
        this.carModel = carModel;
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return name;
    }
}
