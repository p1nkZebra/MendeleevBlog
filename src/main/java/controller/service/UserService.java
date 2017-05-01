package controller.service;

import dal.UserDao;
import dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void saveNewUser(User user) {

    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Long id) {
        return userDao.findById(id);
    }

    public void update(User user) {

        userDao.update(user);
    }

    public User findUser(String login, String password) {
        User user = userDao.findByLoginPassword(login, password);
        return user;
    }
}
