package dal.impl;

import dal.UserDao;
import dal.mapper.UserRowMapper;
import dao.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource dataSource;


    public void save(User entity) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(entity);

        tx.commit();
        session.close();
    }

    public void update(User entity) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(entity);

        tx.commit();
        session.close();
    }

    public User findByLoginPassword(String login, String password) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String countSql = ""
                + " SELECT COUNT(*) FROM JAVA_TASK.USER "
                + " WHERE LOGIN = ? "
                + " AND PASSWORD = ? ";

        Integer count = jdbc.queryForObject(
                countSql,
                new Object[] { login, password },
                Integer.class
        );

        if (count == 0) {
            return null;
        } else {
            String findUserSql = ""
                    + " SELECT * FROM JAVA_TASK.USER "
                    + " WHERE LOGIN = ? "
                    + " AND PASSWORD = ? ";

            User user = (User) jdbc.queryForObject(
                    findUserSql,
                    new Object[] { login, password },
                    new UserRowMapper(User.class)
            );

            return user;
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Session session = this.sessionFactory.openSession();
        List<User> personList = session.createQuery("from User").list();
        session.close();
        return personList;
    }

    public User findByFirstNameAndLastName(String firstName, String lastName) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_TASK.USER "
                + " WHERE FIRST_NAME = ? "
                + " AND LAST_NAME = ? ";

        User user = (User) jdbc.queryForObject(
                sql,
                new Object[] { firstName, lastName },
                new UserRowMapper(User.class)
        );

        return user;
    }

    public User findById(Long userId) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_TASK.USER "
                + " WHERE ID = ? ";

        User user = (User) jdbc.queryForObject(
                sql,
                new Object[] { userId },
                new UserRowMapper(User.class)
        );

        return user;
    }


}
