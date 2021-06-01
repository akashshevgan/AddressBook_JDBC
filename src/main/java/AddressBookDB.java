import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDB {

    private Connection getConnection() throws CustomException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/addressbookservice";
        String userName = "root";
        String password = "root";
        Connection connection;
        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (SQLException e) {
            throw new CustomException("Connection to Database Failed");
        }
        return connection;
    }

    private List<Data> getDataFromDBWhenSQLGiven(String sql) throws CustomException {
        List<Data> contactDetails;
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            contactDetails = getResultSet(resultSet);

        } catch (SQLException e) {
            throw new CustomException("Query Failed");
        }
        return contactDetails;
    }

    private List<Data> getResultSet(ResultSet resultSet) throws CustomException {
        List<Data> contactDetails = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zipcode = resultSet.getInt("zipcode");
                int phoneNumber = resultSet.getInt("phonenumber");
                String email = resultSet.getString("email");
                contactDetails.add(new Data(firstName, lastName, address, city, state, zipcode, phoneNumber, email));
            }
        } catch (SQLException e) {
            throw new CustomException("Query Failed!!");
        }
        return contactDetails;
    }

    public List<Data> getAllDetailsFromTable() throws CustomException {
        String sql = "select * from addressbook;";
        return this.getDataFromDBWhenSQLGiven(sql);
    }

    public int updateContactDetailsInDB(String firstName, String phoneNumber) throws CustomException {
        String sql = String.format("update addressbook set phonenumber = '%s' where firstname = '%s';", phoneNumber, firstName);
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new CustomException("Update Failed");
        }
    }

    public List<Data> getContactDetailsAccordingToCity(String city) throws CustomException {
        String sql = String.format("select * from addressbook where city = '%s';", city);
        return this.getDataFromDBWhenSQLGiven(sql);
    }

//    public List<Data> getContactDetailsAccordingToState(String state) throws CustomException {
//        String sql = String.format("select * from addressbook where state = '%s';", state);
//        return this.getDataFromDBWhenSQLGiven(sql);
//    }
}