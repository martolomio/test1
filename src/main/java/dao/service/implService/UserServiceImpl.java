package dao.service.implService;

import dao.UserDoa;
import dao.impl.UserDaoImpl;
import dao.service.UserService;
import domain.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDoa userDao;
    private  static UserServiceImpl userServiceImpl;
    public  UserServiceImpl(){
        try {
            userDao = new UserDaoImpl();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User read(Integer id) throws SQLException {
        return userDao.read(id);
    }

    @Override
    public User update(User user) {
        return userDao.create(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }

    public  static  UserService getUserService(){
        if (userServiceImpl == null){
            userServiceImpl = new UserServiceImpl();
        }
        return  userServiceImpl;
    }
    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
