package ttl.larku.dao;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import ttl.larku.dao.InMemoryStudentDAO;
import ttl.larku.domain.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInMemoryStudentDAO {

   private InMemoryStudentDAO dao = new InMemoryStudentDAO();

   @Test
   public void testInsertStudent() {
      Student student = new Student("Sammy", LocalDate.of(1987, 4, 4));

      Student saved = dao.insert(student);

      assertEquals(student.getName(), saved.getName());
      assertEquals(1, saved.getId());

      Student retrieved = dao.findById(saved.getId());
      assertEquals(student.getName(), retrieved.getName());
   }

   @Test
   public void testDeleteExistingStudent() {
      Student student = new Student("Sammy", LocalDate.of(1987, 4, 4));

      Student saved = dao.insert(student);

      assertEquals(student.getName(), saved.getName());

      boolean result = dao.delete(saved.getId());

      assertTrue(result);
   }

   @Test
   public void testDeleteNonExistingStudent() {

      boolean result = dao.delete(9999);

      assertFalse(result);
   }
}
