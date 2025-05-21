package ttl.larku.app;

import java.time.LocalDate;
import java.util.List;
import ttl.larku.dao.InMemoryStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

public class StudentServiceApp {

   public static void main(String[] args) {
      StudentService service = new StudentService();

      Student student = new Student("Sally", LocalDate.of(2024, 6, 7));
      service.addStudent(student);

      List<Student> students = service.getAllStudents();

      System.out.println("students.size: " + students.size());
      for(Student s: students) {
         System.out.println(s);
      }
   }


}
