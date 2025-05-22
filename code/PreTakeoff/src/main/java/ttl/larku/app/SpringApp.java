package ttl.larku.app;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

public class SpringApp {

   public static void main(String[] args) {
      SpringApp app = new SpringApp();
      app.goStudentService();
   }

   public void goStudentService() {
     ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//      StudentService studentService = (StudentService) context.getBean("studentService");
      StudentService studentService = context.getBean("studentService", StudentService.class);

      StudentService studentService2 = context.getBean("studentService", StudentService.class);

      List<Student> students = studentService.getAllStudents();

      System.out.println(students);
   }
}
