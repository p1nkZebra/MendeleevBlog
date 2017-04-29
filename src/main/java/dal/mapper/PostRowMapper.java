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

    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Post post = new Post();

        Long dbValueId = resultSet.getLong("ID");
        post.setId(dbValueId);

        String stringDateTime = resultSet.getString("DATE_TIME");
        DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-DD HH:mm:SS");
        LocalDateTime localDateTime = formatter.parseLocalDateTime(stringDateTime);
        post.setDateTime(localDateTime);

        Long dbValueUserId = resultSet.getLong("USER_ID");
        post.setUserId(dbValueUserId);

        String dbValueTitle = resultSet.getString("TITLE");
        post.setTitle(dbValueTitle);

        String dbValuePublication = resultSet.getString("PUBLICATION");
        post.setPublication(dbValuePublication);

        return post;
    }

}
