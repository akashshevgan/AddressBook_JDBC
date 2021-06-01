public class Data {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private int phoneNumber;
    private String emailId;

    public Data(String firstName, String lastName, String address, String city, String state, int zipcode, int phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.emailId = email;
    }

    @Override
    public String toString() {
        return
                "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Address: " + address + '\n' +
                "City: " + city + '\n' +
                "State: " + state + '\n' +
                "Zip: " + zipcode + '\n' +
                "PhoneNumber: " + phoneNumber + '\n' +
                "EmailId: " + emailId + '\n';
    }
}
