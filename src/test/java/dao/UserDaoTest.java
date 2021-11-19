package dao;

import domain.User;
import enums.Level;
import factories.ObjectFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ObjectFactory.class)
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @BeforeEach
    void beforeEach() {
        this.userDao.delete(0);

    }

    @Test
    void addAndGet() {
        User user = new User();
        user.setId(0);
        user.setName("solum_user1");
        user.setLevel(Level.BASIC);
        this.userDao.add(user);

        User selUser1 = this.userDao.get(user.getId());
        assertEquals("solum_user1", selUser1.getName());
        assertEquals(Level.BASIC, selUser1.getLevel());
    }


    @Test
    void update() {
        User user = new User();
        user.setId(0);
        user.setName("solum_user1");
        user.setLevel(Level.BASIC);
        this.userDao.add(user);

        user.setName("solum_user2");
        this.userDao.update(user);

        User selectedUser = this.userDao.get(user.getId());
        assertEquals("solum_user2", selectedUser.getName());

    }
}