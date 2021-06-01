import java.sql.*;
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

    public List<Data> getAllDetailsFromTable() throws CustomException {
        List<Data> contactDetails = new ArrayList<>();
        String sql = "select * from addressbook;";
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zipcode = resultSet.getInt("zip");
                int phoneNumber = resultSet.getInt("phone_number");
                String email = resultSet.getString("email");
                contactDetails.add(new Data(firstName, lastName, address, city, state, zipcode, phoneNumber, email));
            }
        } catch (SQLException e) {
            throw new CustomException("Query Failed!!");
        }
        return contactDetails;
    }
}