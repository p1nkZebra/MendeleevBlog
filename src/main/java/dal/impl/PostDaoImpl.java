package dal.impl;

import dal.PostDao;
import dal.mapper.PostRowMapper;
import dao.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
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



    public Post findSinglePostByPostIdAndUserId(Long postId, Long userId) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM JAVA_TASK.POST WHERE POST.USER_ID = ? AND POST.ID = ?";

        Post post = (Post) jdbc.queryForObject(
                sql,
                new Object[] { userId, postId },
                new PostRowMapper(Post.class)
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
                new PostRowMapper(Post.class)
        );

        return posts;
    }

    public List<Post> findFirstFifty() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_TASK.POST "
                + " ORDER BY POST.ID DESC "
                + " FETCH FIRST 50 ROWS ONLY ";

        List<Post> posts  = jdbc.query(
                sql,
                new PostRowMapper(Post.class)
        );

        return posts;
    }

    public List<Post> findFirstFiftyForPeriod(LocalDateTime startPeriod, LocalDateTime endPeriod) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:SS");
        String start = startPeriod.toString(formatter);
        String end = endPeriod.toString(formatter);

        String sql = ""
                + " SELECT * FROM JAVA_TASK.POST "
                + " WHERE POST.DATE_TIME >= " + "'" + start + "' "
                + " AND POST.DATE_TIME <= " + "'" + end + "' "
                + " ORDER BY POST.DATE_TIME DESC "
                + " FETCH FIRST 50 ROWS ONLY ";

        List<Post> posts  = jdbc.query(
                sql,
                new PostRowMapper(Post.class)
        );

        return posts;
    }

    public Post findById(Long postId) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_TASK.POST "
                + " WHERE POST.ID = ? ";

        Post post = (Post) jdbc.queryForObject(
                sql,
                new Object[] { postId },
                new PostRowMapper(Post.class)
        );

        return post;
    }

    public List<Post> findByUserId(Long userId) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_TASK.POST "
                + " WHERE POST.USER_ID = " + userId + " "
                + " ORDER BY POST.DATE_TIME DESC "
                + " FETCH FIRST 50 ROWS ONLY ";

        List<Post> posts  = jdbc.query(
                sql,
                new PostRowMapper(Post.class)
        );

        return posts;
    }

}
