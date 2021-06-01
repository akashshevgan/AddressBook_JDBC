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
}