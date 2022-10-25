## Spring JDBC 예제

```java
public class UserService implements UserLevelUpgradePolicy{

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean canUpgradeLevel(User user) {
        switch (user.getLevel()) {
            case BASIC: return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER: return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
            case GOLD: return false;
            default:
                throw new IllegalArgumentException("Unknown Level:" + user.getLevel());
        }
    }

    public void upgradeLevel(User user) {
        user.setLevel(user.getLevel().nextLevel());
        this.userDao.update(user);
    }

    public void upgradeLevels() {
        for (User user : userDao.getAll()) {
            if (canUpgradeLevel(user)) {
                upgradeLevel(user);
            }
        }
    }
}
```
