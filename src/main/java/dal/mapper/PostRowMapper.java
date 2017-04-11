package dal.mapper;

import dao.Post;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper extends BeanPropertyRowMapper {

    public PostRowMapper(Class mappedClass) {
        super(mappedClass);
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(rs.getLong("ID"));

        String stringDateTime = rs.getString("DATE_TIME");
        DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-DD HH:mm:SS");
        LocalDateTime localDateTime = formatter.parseLocalDateTime(stringDateTime);
        post.setDateTime(localDateTime);

        post.setUserId(rs.getLong("USER_ID"));
        post.setTitle(rs.getString("TITLE"));
        post.setPublication(rs.getString("PUBLICATION"));
        return post;
    }

}
