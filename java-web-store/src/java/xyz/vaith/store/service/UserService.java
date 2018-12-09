package xyz.vaith.store.service;

import xyz.vaith.store.domain.User;

public interface UserService {
    public User register(User user) throws Exception;
    public boolean active(String code) throws Exception;
}
