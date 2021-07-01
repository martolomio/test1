package dao.impl;

import dao.UserDoa;
import domain.Product;
import domain.User;
import utils.ConnectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDoa {

    private static  String READ_ALL= "select * from client";
    private static String CREATE= "insert into client(first_name , last_name , email , password, access ) values (?,?,?,?,?)";
    private static  String READ_BY_ID= "select * from client where id =?";
    private static  String UPDATE_BY_ID= "update client set first_name=?, last_name=? , password=?, email=?, access=? where id=?";
    private static  String DELETE_BY_ID= "delete from client where id=?";
    private static  String READ_BY_EMAIL= "select * from client where email =?";


    private Connection connection ;
    private PreparedStatement preparedStatement;

    public UserDaoImpl() throws SQLException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        connection = ConnectionUtil.openConnection();

    }
    @Override
    public User create(User user) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAccess());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  user;
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer userId = result.getInt("id");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String email = result.getString("email");
            String password = result.getString("password");
            String access = result.getString("access");


            user = new User(userId,firstName,lastName,email, password, access);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        try {
        preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4,user.getPassword());
        preparedStatement.setString(5, user.getAccess());
        preparedStatement.executeUpdate();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
        return user;
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<User> readAll() {
        List<User> userRecords = new ArrayList<User>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result= preparedStatement.executeQuery();

            while (result.next()){
                Integer userId = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String password = result.getString("password");
                String access = result.getString("access");
                userRecords.add(new User(userId,firstName,lastName,email, password, access));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userRecords;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
            preparedStatement.setString(1,email);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Integer userId = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String password = resultSet.getString("password");
            String access = resultSet.getString("access");
            user=(new User(userId,firstName,lastName,email, password, access));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
