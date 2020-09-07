import org.springframework.context.support.ClassPathXmlApplicationContext;

import aopDemo.Target;
import service.UserService;

public class test {

    /**
     * 依赖注入测试
     */
    public static void test1() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        UserService userService = (UserService) app.getBean("userService");
        // UserService userService = (UserService) app.getBean(UserService.class);
    
        userService.save();
        System.out.println(userService);
    
        app.close();
    }

    /**
     * AOP测试
     */
    public static void test2() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Target target = app.getBean(Target.class);    
        target.hello("hi");
        app.close();
    }


    public static void main(String[] args) {

    }
}