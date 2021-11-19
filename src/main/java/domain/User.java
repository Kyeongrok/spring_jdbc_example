package domain;

import enums.Level;

public class User {
    private long id;
    private String name;
    private Level level;
    private int login;
    private int recommend;

    public User() {
    }

    public User(long id, String name, Level level, int login, int recommend) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.login = login;
        this.recommend = recommend;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }
}
