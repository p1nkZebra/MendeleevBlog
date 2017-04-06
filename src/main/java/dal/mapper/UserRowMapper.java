package dal.mapper;

import dao.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("ID"));
        user.setFirstName(rs.getString("FIRST_NAME"));
        user.setLastName(rs.getString("LAST_NAME"));
        return user;
    }

}
