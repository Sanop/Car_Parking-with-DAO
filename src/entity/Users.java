package entity;

public class Users implements SuperEntity {
    private String id;
    private String name;
    private String nic;
    private String address;
    private String contact;
    private String email;
    private String password;
    private String userName;
    private String userRole;

    public Users() {
    }

    public Users(String password, String userName, String userRole) {
        this.password = password;
        this.userName = userName;
        this.userRole = userRole;
    }

    public Users(String id, String name, String nic, String address, String contact, String email, String password, String userName, String userRole) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.userRole = userRole;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return name;
    }
}
