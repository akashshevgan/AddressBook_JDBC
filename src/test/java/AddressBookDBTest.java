import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class AddressBookDBTest {

    @Test
    void giveDataFromADatabase_WhenRetrieved_ShouldMatchTheCount() throws CustomException {
        List<Data> contactDetails;
        AddressBookDB addressBookDB = new AddressBookDB();
        contactDetails = addressBookDB.getAllDetailsFromTable();
        System.out.println(contactDetails.size());
        Assertions.assertEquals(5, contactDetails.size());
    }

    @Test
    void givenNewSalary_WhenUpdated_ShouldPassTestAndBeInSync() throws CustomException {
        AddressBookDB addressBookDB = new AddressBookDB();
        int result = addressBookDB.updateContactDetailsInDB("Yogesh", "901165307");
        Assertions.assertEquals(1, result);
    }

    @Test
    void givenCityNaME_WhenFound_ShouldReturnNoOfContactsFromGivenCity() throws CustomException {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Data> contactDetails;
        contactDetails = addressBookDB.getContactDetailsAccordingToCity("Vaijapur");
        Assertions.assertEquals(2, contactDetails.size());
    }

//    @Test
//    void givenCityNaME_WhenFound_ShouldReturnNoOfContactsFromGivenState() throws CustomException {
//        AddressBookDB addressBookDB = new AddressBookDB();
//        List<Data> contactDetails;
//        contactDetails = addressBookDB.getContactDetailsAccordingToState("Maharastra");
//        Assertions.assertEquals(4, contactDetails.size());
//    }
}