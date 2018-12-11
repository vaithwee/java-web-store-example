package xyz.vaith.store.dao;

import xyz.vaith.store.domain.User;

import java.sql.SQLException;

public interface UserDao {
     User createNewUser(User user) throws SQLException;
     boolean isExistUser(String username) throws SQLException;
     boolean activeUser(String code) throws SQLException;
     User login(String username, String password) throws SQLException;
}
