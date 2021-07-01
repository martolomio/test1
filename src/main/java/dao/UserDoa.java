package dao;

import domain.User;
import sheard.AbstractCrud;

public interface UserDoa extends AbstractCrud<User> {
    User getUserByEmail(String email);
}
