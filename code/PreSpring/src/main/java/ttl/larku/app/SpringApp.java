package ttl.larku.app;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ttl.larku.domain.Course;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.LarkUConfig;
import ttl.larku.service.CourseService;
import ttl.larku.service.StudentService;

public class SpringApp {

   public static void main(String[] args) {
      SpringApp app = new SpringApp();
//      app.goStudentService();
      app.goCourseService();
   }

   public void goStudentService() {
//     ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

//      StudentService studentService = (StudentService) context.getBean("studentService");
      StudentService studentService = context.getBean("studentService", StudentService.class);


      List<Student> students = studentService.getAllStudents();

      System.out.println(students);
   }

   public void goCourseService() {
//     ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

//      StudentService studentService = (StudentService) context.getBean("studentService");
      CourseService courseService = context.getBean("courseService", CourseService.class);


      List<Course> courses = courseService.getAllCourses();

      System.out.println(courses);
   }
}
