package dao.impl;

import dao.ProductDao;
import domain.Bucket;
import domain.Product;
import utils.ConnectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static  String READ_ALL= "select * from product";
    private static String CREATE= "insert into product(`name`,`description`,`price` ) values (?,?,?)";
    private static  String READ_BY_ID= "select * from product where id =?";
    private static  String UPDATE_BY_ID= "update product set name=?, description=?, prise=? where id=?";
    private static  String DELETE_BY_ID= "delete from product where id=?";

    private Connection connection ;
    private PreparedStatement preparedStatement;

    public ProductDaoImpl() throws SQLException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        connection = ConnectionUtil.openConnection();

    }
    @Override
    public Product create(Product product) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getDescription());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            product.setId(rs.getInt(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public Product read(Integer id) {
        Product product = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer productId = result.getInt("id");
            String name = result.getString("name");
            String description = result.getString("description");
            Double price = result.getDouble("price");

            product = new Product(productId,name,description,price);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  product;
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
    public List<Product> readAll() {
        List<Product> productRecords = new ArrayList<Product>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result= preparedStatement.executeQuery();

            while (result.next()){
                Integer productId = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                Double price = result.getDouble("price");
                productRecords.add(new Product(productId,name,description,price));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productRecords;
    }
}
