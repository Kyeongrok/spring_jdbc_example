package factories;

import dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import services.UserService;

import javax.sql.DataSource;

@Configuration
public class ObjectFactory {

    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao(postgresDatasource());
        return userDao;
    }

    @Bean
    public UserService userService() {
        UserService userService = new UserService(userDao());
        return userService;
    }

    private DataSource postgresDatasource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUrl("jdbc:postgresql://localhost:5432/aims_core");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");

        return dataSource;
    }
}
