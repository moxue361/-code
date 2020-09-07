package tao.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class BaseDao {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static {
        InputStream is;
        try {
            is = new FileInputStream("src/main/resources/jdbc.properties");
            Properties p = new Properties();
            p.load(is);
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            driver = p.getProperty("driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int update(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    /**
     * @param sqlString,params
     * @return List
     * 
     */
    @Deprecated
    public List<Map<String, Object>> query(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = stmt.executeQuery();
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String key = rs.getMetaData().getColumnName(i);
                    Object value = rs.getObject(i);
                    map.put(key, value);
                }
                list.add(map);
            }
            if (list.size() == 0)
                return null;
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public <T> T queryOneObj(String sql, Class<T> clazz, Object... params) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                T obj = clazz.newInstance();
                Method[] allMethods = clazz.getMethods();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String key = rs.getMetaData().getColumnName(i);
                    Object value = rs.getObject(i);
                    for (Method m : allMethods) {
                        if (m.getName().substring(3).equalsIgnoreCase(key) && m.getName().startsWith("set")) {
                            m.invoke(obj, value);
                            break;
                        }
                    }
                }
                return (T)obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public <T>  List<T> queryObjs(String sql, Class<T> clazz, Object... params) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
                
            }
            ResultSet rs = stmt.executeQuery();
            List<T> list=new ArrayList<T>();
            while(rs.next()) {
                T obj = clazz.newInstance();
                Method[] allMethods = clazz.getMethods();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String key = rs.getMetaData().getColumnName(i);
                    Object value = rs.getObject(i);
                    for (Method m : allMethods) {
                        if (m.getName().substring(3).equalsIgnoreCase(key) && m.getName().startsWith("set")) {
                            m.invoke(obj, value);
                            break;
                        }
                    }
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
