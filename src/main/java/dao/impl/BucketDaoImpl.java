package dao.impl;

import dao.BucketDao;
import domain.Bucket;
import utils.ConnectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BucketDaoImpl implements BucketDao {

    private static  String READ_ALL= "select * from bucket";
    private static String CREATE= "insert into bucket(`user_id`,`product_id`,`putchase_date` ) values (?,?,?)";
    private static  String READ_BY_ID= "select * from bucket where id =?";
    private static  String DELETE_BY_ID= "delete from bucket where id=?";

    private Connection connection ;
    private PreparedStatement preparedStatement;

    public BucketDaoImpl() throws SQLException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
       connection = ConnectionUtil.openConnection();

    }

    @Override
    public Bucket create(Bucket bucket) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,bucket.getUserId());
            preparedStatement.setInt(2,bucket.getProductId());
            preparedStatement.setDate(3,new Date(bucket.getPuchaseDate().getTime()));
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            bucket.setId(rs.getInt(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bucket;
    }

    @Override
    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

           result.next();
            Integer bucketId = result.getInt("id");
            Integer userId = result.getInt("user_id");
            Integer productId = result.getInt("product_id");
            Date purchaseDate = result.getDate("purchase_date");

            bucket = new Bucket(bucketId, userId, productId,purchaseDate);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bucket;
    }

    @Override
    public Bucket update(Bucket bucket) {
        throw new IllegalStateException("there are no update for bucket");
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
    public List<Bucket> readAll() {
        List<Bucket> bucketRecords = new ArrayList<Bucket>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result= preparedStatement.executeQuery();

            while (result.next()){
                Integer bucketId = result.getInt("id");
                Integer userId = result.getInt("user_id");
                Integer productId = result.getInt("product_id");
                Date purchaseDate = result.getDate("purchase_date");
                bucketRecords.add(new Bucket(bucketId, userId, productId,purchaseDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bucketRecords;
    }
}
