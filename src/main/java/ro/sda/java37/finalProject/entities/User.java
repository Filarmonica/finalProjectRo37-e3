package ro.sda.java37.finalProject.entities;

public class User{
    private Long id;
    private String email;
    private String password;
    private String city;
    private Address address;
    private boolean avatar;  //it has an avatar or not
    boolean role;  // it is admin or user

    public User(Long id, String email, String password, String city, Address address, boolean avatar, boolean role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.city = city;
        this.address = address;
        this.avatar = avatar;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isAvatar() {
        return avatar;
    }

    public void setAvatar(boolean avatar) {
        this.avatar = avatar;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", address=" + address +
                ", avatar=" + avatar +
                ", role=" + role +
                '}';
    }
}