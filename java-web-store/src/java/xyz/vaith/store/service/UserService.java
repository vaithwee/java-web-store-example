package xyz.vaith.store.service;

import xyz.vaith.store.domain.User;

public interface UserService {
     User register(User user) throws Exception;
     boolean active(String code) throws Exception;
     User login(String username, String password) throws Exception;
}
