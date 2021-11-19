package services;

import domain.User;
import enums.Level;
import factories.ObjectFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static services.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static services.UserService.MIN_RECOMMEND_FOR_GOLD;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ObjectFactory.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    List<User> users = new ArrayList<>();

    @BeforeAll
    private void setUp(){
        users = Arrays.asList(
                new User(0, "김경록", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER -1, 0),
                new User(1, "김영환", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
                new User(2, "이아름", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD-1),
                new User(3, "김윤규", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD),
                new User(4, "한영탁", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }

    @BeforeEach
    void ddd() {

    }

    @Test
    void upgradeLevels() {
        userService.upgradeLevels();
    }
}