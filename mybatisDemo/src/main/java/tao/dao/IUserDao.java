package tao.dao;

import java.util.List;

import tao.bean.User;

public interface IUserDao {
    public List<User> findAll();
    public List<User> findByIds(List<Integer> ids);
    public List<User> findByCondition(User user);
}