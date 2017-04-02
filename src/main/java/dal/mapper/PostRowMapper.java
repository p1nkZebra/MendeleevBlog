package dal.mapper;

import dao.Post;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(rs.getLong("ID"));
        post.setUserId(rs.getLong("USER_ID"));
        post.setTitle(rs.getString("TITLE"));
        post.setPublication(rs.getString("PUBLICATION"));
        return post;
    }

}
