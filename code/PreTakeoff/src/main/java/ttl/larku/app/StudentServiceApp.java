package ttl.larku.app;

import java.time.LocalDate;
import java.util.List;
import ttl.larku.dao.InMemoryStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

public class StudentServiceApp {

   public static void main(String[] args) {
      StudentService service = new StudentService();

      Student student = new Student("Sally", LocalDate.of(1998, 6, 7));
      service.addStudent(student);

      List<Student> students = service.getAllStudents();

      System.out.println("students.size: " + students.size());
      for(Student s: students) {
         System.out.println(s);
      }
   }


   public static void initService(StudentService service) {
      var students = List.of(
            new Student("Johnny", LocalDate.of(1990, 10, 5)),
            new Student("Rachna", LocalDate.of(1960, 10, 8)),
            new Student("Pheroze", LocalDate.of(1947, 8, 16)),
            new Student("Gunnar", LocalDate.of(1980, 5, 5)),
            new Student("Isabella", LocalDate.of(2000, 10, 5))
      );

      students.forEach(student -> service.addStudent(student));
   }

}
