package dal;

import dao.User;

import java.util.List;

public interface UserDao {
    void save(User entity);

    List<User> findAll();

    User findByFirstNameAndLastName(String firstName, String lastName);

    User findById(Long userId);

    void update(User entity);

    User findByLoginPassword(String login, String password);
}
