public class Data {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private int phoneNumber;
    private String emailId;
    private int id;
    private String type;
    private String addressbook_name;

    public Data(String firstName, String lastName, String address, String city, String state, int zipcode, int phoneNumber, String email, int id,String type,String addressbook_name) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.emailId = email;
        this.id = id;
        this.type = type;
        this.addressbook_name = addressbook_name;
    }

}
