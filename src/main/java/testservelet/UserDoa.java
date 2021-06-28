package testservelet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDoa {

    private static  String READ_ALL= "select * from client";
    private static String CREATE= "insert into client(first_name , last_name , email , password, access ) values (?,?,?,?,?)";
    private static  String READ_BY_ID= "select * from client where id =?";
    private static  String UPDATE_BY_ID= "update client set first_name=?, last_name=? , password=?, email=?, access=? where id=?";
    private static  String DELETE_BY_ID= "delete from client where id=?";

    private  Connection connection ;
    private PreparedStatement preparedStatement;
    User user =null;

    public UserDoa(Connection connection){
        this.connection= connection;
    }

    public User insert(String firstName,String lastName,String email,String password,String  access) throws SQLException {
       preparedStatement = connection.prepareStatement(CREATE, preparedStatement.RETURN_GENERATED_KEYS);
       preparedStatement.setString(1,firstName);
       preparedStatement.setString(2,lastName);
        preparedStatement.setString(3,email);
        preparedStatement.setString(4,password);
       preparedStatement.setString(5,access);
       preparedStatement.executeUpdate();
        return  user;
    }
//     public  User read(int id) throws SQLException {
//         preparedStatement = connection.prepareStatement(READ_BY_ID);
//         preparedStatement.setInt(1, id);
//         ResultSet result = preparedStatement.executeQuery();
//         result.next();
//         return UserMapper.map(result);
//     }
//
//    public void update(User user) throws SQLException {
//        preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
//        preparedStatement.setString(1, user.getFirstName());
//        preparedStatement.setString(2, user.getLastName());
//        preparedStatement.setInt(3, user.getId());
//        preparedStatement.executeUpdate();
//    }
//
//    public  void delete(int id) throws SQLException {
//        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
//        preparedStatement.setInt(1, id);
//        preparedStatement.executeUpdate();
//    }
//     public List<Client> readAll()throws SQLException {
//        List<Client> listOfUsers = new ArrayList<Client>();
//         preparedStatement = connection.prepareStatement(READ_ALL);
//        ResultSet result= preparedStatement.executeQuery();
//
//        while (result.next()){
//            listOfUsers.add(ClientMapper.map(result));
//        }
//        return  listOfUsers;
//     }
}
