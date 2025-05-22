package ttl.larku.app;

import java.time.LocalDate;
import java.util.List;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

public class ControllerApp {
   StudentService studentService = new StudentService();
   public static void main(String[] args) {
      ControllerApp app = new ControllerApp();

      app.postAStudent();
      app.getStudents();
   }

   public void postAStudent() {
      Student student = new Student("Franicine", LocalDate.of(1000, 10, 10));

      studentService.addStudent(student);

      List<Student> students = studentService.getAllStudents();

      System.out.println("students: size = " + students.size());
      students.forEach(System.out::println);

   }

   public void getStudents() {
//      StudentService studentService = new StudentService();

      List<Student> students = studentService.getAllStudents();

      System.out.println("students: size = " + students.size());
      students.forEach(System.out::println);
   }

}
