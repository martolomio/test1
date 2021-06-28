package testservelet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public  static User map(ResultSet results) throws SQLException {
        String firstName = results.getString("first_name");
        String lastName = results.getString("last_name");
        String email = results.getString("email");
        String password = results.getString("password");
        String access= results.getString("access");

        return new User(firstName, lastName, email, password, access );

    }
}
