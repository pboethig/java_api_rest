package apitesting.com.org.classes;

public class Info {

    /**
     * id
     */
    private String email;

    /**
     * Title
     */
    private String phone;

    /**
     * Author
     */
    private String address;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
