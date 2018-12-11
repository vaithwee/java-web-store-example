package xyz.vaith.store.service.Impl;

import xyz.vaith.store.dao.Impl.UserDaoImpl;
import xyz.vaith.store.dao.UserDao;
import xyz.vaith.store.domain.User;
import xyz.vaith.store.service.UserService;
import xyz.vaith.store.utils.MailUtil;
import xyz.vaith.store.utils.UUIDUtil;

public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) throws Exception {
        UserDao dao = new UserDaoImpl();
        if (dao.isExistUser(user.getUsername())) {
            throw new Exception("用户名已存在!");
        }
        user.setUid(UUIDUtil.getId());
        user.setState(0);
        user.setCode(UUIDUtil.getCode());
        user = dao.createNewUser(user);
        MailUtil.sendMail(user.getCode(), user.getEmail());
        return user;
    }

    @Override
    public boolean active(String code) throws Exception {
        UserDao dao = new UserDaoImpl();
        return dao.activeUser(code);
    }

    @Override
    public User login(String username, String password) throws Exception {
        UserDao dao = new UserDaoImpl();
        User user = dao.login(username, password);
        if (null == user) {
            throw new Exception("错误的用户名或者密码");
        }
        if (user.getState() == 0) {
            throw new Exception("用户未激活");
        }
        return user;
    }
}
