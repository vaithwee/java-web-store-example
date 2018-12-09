package xyz.vaith.store.dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import xyz.vaith.store.dao.UserDao;
import xyz.vaith.store.domain.User;
import xyz.vaith.store.utils.JdbcUitl;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User createNewUser(User user) throws SQLException {
        String sql="INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?)";
        Object[] params={user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()};
        QueryRunner runner = new QueryRunner(JdbcUitl.getDataSource());
        runner.update(sql,params);
        user.setPassword(null);
        return user;
    }

    @Override
    public boolean isExistUser(String username) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ?";
        QueryRunner runner = new QueryRunner(JdbcUitl.getDataSource());
        User user = runner.query(sql, new BeanHandler<User>(User.class), username);
        return user!=null;
    }

    @Override
    public boolean activeUser(String code) throws SQLException {
        String sql = "UPDATE user SET state = 1 WHERE code = ?";
        QueryRunner runner = new QueryRunner(JdbcUitl.getDataSource());
        return runner.update(sql, code) > 0;
    }
}
