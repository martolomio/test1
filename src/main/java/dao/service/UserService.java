package dao.service;

import domain.User;
import sheard.AbstractCrud;

public interface UserService  extends AbstractCrud<User> {
    User getUserByEmail(String email);
}

