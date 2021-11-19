package dao;

import domain.User;
import enums.Level;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setLevel(Level.valueOf(rs.getInt("level")));
            user.setLogin(rs.getInt("login"));
            user.setRecommend(rs.getInt("recommend"));
            return user;
        }
    };

    public User get(long id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ?",
                this.rowMapper, id);
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from users",
                this.rowMapper);
    }
    public void add(User user) {
        this.jdbcTemplate.update("insert into users(id, name, level, login, recommend) values(?, ?, ?, ?, ?)",
                user.getId(), user.getName(), user.getLevel().intValue(), user.getLogin(), user.getRecommend()
        );
    }

    public void delete(long id) {
        this.jdbcTemplate.update("delete from users where id = " + id);
    }

    public void update(User user) {
        this.jdbcTemplate.update("update users set name=?, level=?, login=?, recommend=?",
                user.getName(), user.getLevel().intValue(), user.getLogin(), user.getRecommend());
    }
}
