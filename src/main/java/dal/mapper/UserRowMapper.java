package dal.mapper;

import dao.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper extends BeanPropertyRowMapper {

    public UserRowMapper(Class mappedClass) {
        super(mappedClass);
    }

    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();

        Long dbValueId = resultSet.getLong("ID");
        user.setId(dbValueId);

        String dbValueFirstName = resultSet.getString("FIRST_NAME");
        user.setFirstName(dbValueFirstName);

        String dbValueLastName = resultSet.getString("LAST_NAME");
        user.setLastName(dbValueLastName);

        String dbValueLogin = resultSet.getString("LOGIN");
        user.setLogin(dbValueLogin);

        String dbValuePassword = resultSet.getString("PASSWORD");
        user.setPassword(dbValuePassword);

        return user;
    }

}
