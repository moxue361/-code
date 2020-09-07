package service;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import dao.UserDao;

public class UserService {
    
    private UserDao userDao;

    private List<String> strList;
    private Map< String,UserDao> userDaoMap;
    private Properties properties;

    public void save() {
        userDao.save(); 
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Map<String, UserDao> getUserDaoMap() {
        return userDaoMap;
    }

    public void setUserDaoMap(Map<String, UserDao> userDaoMap) {
        this.userDaoMap = userDaoMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "UserService [properties=" + properties + ", strList=" + strList + ", userDao=" + userDao
                + ", userDaoMap=" + userDaoMap + "]";
    }
}