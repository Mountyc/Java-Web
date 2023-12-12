import com.lyc.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = beanFactory.getBean("accountService", AccountService.class);
        String source = "李屹城";
        String target = "马云";
        try {
            System.out.println(source + "账户余额" + accountService.getMoney(source));
            System.out.println(target + "账户余额" + accountService.getMoney(target));
            accountService.transMoney(source, target, 100);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(source + "账户余额" + accountService.getMoney(source));
            System.out.println(target + "账户余额" + accountService.getMoney(target));
        }
    }
}