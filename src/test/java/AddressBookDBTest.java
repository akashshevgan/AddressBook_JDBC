import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddressBookDBTest {

    @Test
    void giveDataFromADatabase_WhenRetrieved_ShouldMatchTheCount() throws CustomException {
        List<Data> contactDetails;
        AddressBookDB addressBookDB = new AddressBookDB();
        contactDetails = addressBookDB.getAllDetailsFromTable();
        System.out.println(contactDetails.size());
        Assertions.assertEquals(7, contactDetails.size());
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

    @Test
    void givenCityNaME_WhenFound_ShouldReturnNoOfContactsFromGivenState() throws CustomException {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Data> contactDetails;
        contactDetails = addressBookDB.getContactDetailsAccordingToState("Maharastra");
        Assertions.assertEquals(4, contactDetails.size());
    }

    @Test
    void givenANewEntry_WhenQueryExecuted_ShouldAddNewContactInDB() throws CustomException {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Data> contactDetails;
        addressBookDB.addNewContactToDB("suresh", "Rana", "Suyog colony", "baramati",  "maharashtra", 678594, 90675555, "ravi@gmail.com","friend",  10,"contact 11");
        contactDetails = addressBookDB.getAllDetailsFromTable();
        Assertions.assertEquals(7, contactDetails.size());
    }

    @Test
    void givenMultipleEmployees_WhenAddedToDB_ShouldMatchCount() throws CustomException {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<Data> contactDataList;
        Data[]  contactArray = {
                new Data("Akash", "Shevgan", "manjri", "pune", "maharastra",  421307, 7890654, "akashshevgan11@gmail.com",8,"family","contact5"),
                new Data("Akash", "Shevgan", "manjri", "pune", "maharastra",  421307, 7890654, "akashshevgan11@gmail.com",12,"family","contact5"),
                new Data("Akash", "Shevgan", "manjri", "pune", "maharastra",  421307, 7890654, "akashshevgan11@gmail.com",13,"family","contact5"),
                new Data("Akash", "Shevgan", "manjri", "pune", "maharastra",  421307, 7890654, "akashshevgan11@gmail.com",14,"family","contact5"),
                new Data("Akash", "Shevgan", "manjri", "pune", "maharastra",  421307, 7890654, "akashshevgan11@gmail.com",15,"family","contact5"),
        };
        Instant startThread = Instant.now();
        addressBookDB.addMultipleContacts(Arrays.asList(contactArray));
        Instant endThread = Instant.now();
        System.out.println("Time Taken to Execute : " + Duration.between(startThread, endThread));
        contactDataList = addressBookDB.getAllDetailsFromTable();
        Assertions.assertEquals(7, contactDataList.size());
    }
}