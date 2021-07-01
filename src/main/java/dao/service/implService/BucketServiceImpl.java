package dao.service.implService;

import dao.BucketDao;
import dao.impl.BucketDaoImpl;
import dao.service.BucketService;
import domain.Bucket;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class BucketServiceImpl implements BucketService {
    private BucketDao bucketDao;

    public  BucketServiceImpl(){
        try {
            bucketDao = new BucketDaoImpl();
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
    public Bucket create(Bucket bucket) {
        return bucketDao.create(bucket);
    }

    @Override
    public Bucket read(Integer id) throws SQLException {
        return bucketDao.read(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketDao.update(bucket);
    }

    @Override
    public void delete(Integer id) {
        bucketDao.delete(id);
    }

    @Override
    public List<Bucket> readAll() {
        return bucketDao.readAll();
    }
}
