import com.lyc.mybatis.pojo.Student;
import com.lyc.mybatis.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    private static void printStudentList(IStudentService studentService) {
        List<Student> studentList = studentService.selectAllStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) throws ParseException {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        IStudentService studentService = beanFactory.getBean("studentService", IStudentService.class);

        System.out.println("---第一次查询---");
        printStudentList(studentService);

        System.out.println("---添加学生后---");
        // 添加学生
        Student student = new Student();
        student.setStuName("王五");
        student.setStuBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-05"));
        studentService.insertStudent(student);
        printStudentList(studentService);

        // 更新id=1的学生
        Student stuToUpdate = studentService.selectStudentById(1);
        stuToUpdate.setStuName("J");
        stuToUpdate.setStuBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2002-12-30"));
        studentService.updateStudent(stuToUpdate);
        System.out.println("---更新学生后---");
        printStudentList(studentService);

        // 删除id=1的学生
        studentService.deleteStudentById(1);
        System.out.println("---删除学生后---");
        printStudentList(studentService);
    }
}