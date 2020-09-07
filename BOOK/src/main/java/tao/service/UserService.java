package tao.service;

import tao.bean.User;
import tao.dao.UserDao;

public class UserService {
    public Boolean regist(User user){
        return new UserDao().save(user);
    }

    public User login(User user) {
        return new UserDao().queryOne(user);
    }
}