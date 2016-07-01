import com.kaishengit.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 20330 on 2016/6/30.
 */
public class SpringDemoTestCase {
    @Test
    public void unit(){
        System.out.println("init method");

    }
    @Test
    public void testGetUserDao(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");

        /*BookService bookService=(BookService)context.getBean("bookService");
        bookService.showBook();*/
        UserService userService=(UserService)context.getBean("userService");
        userService.sayHi();

        /* UserDao userDao=(UserDao)context.getBean("userDao");
        userDao.sayHello();

        UserDao userDao1=(UserDao)context.getBean("userDao");
        System.out.println(userDao==userDao1);*/
    }
}
