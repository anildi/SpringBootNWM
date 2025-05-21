package ttl.larku.service;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import ttl.larku.domain.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStudentService {

   StudentService service = new StudentService();

   @Test
   public void testValidStudent() {

      Student student = new Student("Sally", LocalDate.of(1999, 6, 7));
      service.addStudent(student);

      assertTrue(student.getId() > 0);

      List<Student> students = service.getAllStudents();

      assertEquals(1, students.size());
   }

   @Test
   public void testNotValidStudent() {

      assertThrows(IllegalArgumentException.class, () -> {
         Student student = new Student("Sally", LocalDate.of(2024, 6, 7));
         service.addStudent(student);

         assertTrue(student.getId() > 0);

         List<Student> students = service.getAllStudents();

         assertEquals(1, students.size());
      });
   }
}
