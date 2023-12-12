import com.lyc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.saveUser();
    }
}