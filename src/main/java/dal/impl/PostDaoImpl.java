package dal.impl;

import dal.PostDao;
import dao.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource dataSource;


    public void save(Post entity) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
    }

    public Post findSinglePostByPostId(Long postId) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM JAVA_TASK.POST WHERE POST.ID = ?";

        Post post = (Post) jdbc.queryForObject(
                sql,
                new Object[] { postId },
                new BeanPropertyRowMapper(Post.class)
        );

        return post;
    }

    public Post findSinglePostByPostIdAndUserId(Long postId, Long userId) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM JAVA_TASK.POST WHERE POST.USER_ID = ? AND POST.ID = ?";

        Post post = (Post) jdbc.queryForObject(
                sql,
                new Object[] { userId, postId },
                new BeanPropertyRowMapper(Post.class)
        );

        return post;
    }

    public String findPublicationByPostId(Long postId) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = "SELECT publication FROM JAVA_TASK.POST  WHERE ID = ?";

        String publication = (String)jdbc.queryForObject(
                sql,
                new Object[] { postId },
                String.class
        );

        return publication;

    }

    public List<Post> findAll() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = " SELECT * FROM JAVA_TASK.POST ";

        List<Post> posts  = jdbc.query(
                sql,
                new BeanPropertyRowMapper(Post.class)
        );

        return posts;
    }
}
