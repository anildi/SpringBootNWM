package ttl.larku.dao.repository;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ttl.larku.domain.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestStudentRepo {

   @Autowired
   private StudentRepo studentRepo;

   @Test
   public void testRepository() {
      //List<Student> students = studentRepo.findAll();
//      List<Student> students = studentRepo.findByName("Manoj-h2");
//      List<Student> students = studentRepo.findByNameContaining("Manoj");
      List<Student> students = studentRepo.findByNameContainingIgnoreCase("manoj");

      System.out.println("students: " + students);

      assertEquals(1, students.size());
   }
}
