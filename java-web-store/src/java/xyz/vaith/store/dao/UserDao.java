package xyz.vaith.store.dao;

import xyz.vaith.store.domain.User;

import java.sql.SQLException;

public interface UserDao {
    public User createNewUser(User user) throws SQLException;
    public boolean isExistUser(String username) throws SQLException;
    public boolean activeUser(String code) throws SQLException;
}
