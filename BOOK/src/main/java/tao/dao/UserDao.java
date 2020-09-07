package tao.dao;

import tao.bean.User;

public class UserDao extends BaseDao {

    /**
     * @param user
     * @return if username does not exist,return null,otherwise return the user
     */
    public User queryOne(User user) {
        return queryOneObj("select * from t_user where username=? and password=?", User.class, user.getUsername(),
                user.getPassword());
    }

    /**
     * @param user
     * @return  if saved successfully return true,otherwise return false
     */
    public Boolean save(User user) {
        if (queryOneObj("select * from t_user where username=?", User.class, user.getUsername()) == null) {
            update("insert into t_user(username,password,email) values(?,?,?)", user.getUsername(), user.getPassword(),
                    user.getEmail());
            return true;
        }
        return false;
    }
}
