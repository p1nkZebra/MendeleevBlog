package dal;

import dao.User;

import java.util.List;

public interface UserDao {
    void save(User entity);

    List<User> findAll();

}
