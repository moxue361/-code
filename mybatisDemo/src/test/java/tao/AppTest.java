package tao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tao.bean.Order;
import tao.bean.User;
import tao.dao.IOrderDao;
import tao.dao.IUserDao;

/**
 * Unit test for simple App.
 */
public class AppTest {

    // 接口代理实现
    public static void test1() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
        in.close();
    }

    /**
     * 动态sql测试 foreach标签
     */
    public static void test2() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(45);
        list.add(41);

        InputStream in = Resources.getResourceAsStream("sqlConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> users = mapper.findByIds(list);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
        in.close();
    }

    /**
     * 动态sql测试 if标签
     */
    public static void test3() throws Exception {

        // User user1 = new User();
        // user1.setUsername("小二");

        User user1 = new User();
        user1.setUsername("小二");
        user1.setSex("女");

        InputStream in = Resources.getResourceAsStream("sqlConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);

        List<User> users = mapper.findByCondition(user1);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
        in.close();
    }

    /**
     * plugin测试 分页助手
     */
    public static void test4() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);

        // 设置分页相关参数
        PageHelper.startPage(2, 3);

        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        // 获得分页相关参数
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("总页数：" + pageInfo.getTotal());
        System.out.println("每页显示条数：" + pageInfo.getPageSize());
        System.out.println("前一页：" + pageInfo.getPrePage());
        System.out.println("是否是首页：" + pageInfo.isIsFirstPage());

        sqlSession.close();
        in.close();
    }

    /**
     * 多表操作测试 一对一
     */
    public static void test5() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        IOrderDao mapper = sqlSession.getMapper(IOrderDao.class);
        List<Order> orders = mapper.findAll();
        for (Order order : orders) {
            System.out.println(order);
        }
        sqlSession.close();
        in.close();
    }

    /**
     * 多表操作测试 一对多
     */
    public static void test6() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
        in.close();
    }

    public static void main(String[] args) throws Exception {
        test6();
    }
}
