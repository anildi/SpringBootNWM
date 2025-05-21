package ttl.larku.domain;

import java.time.LocalDate;
import java.util.Objects;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestStudentRecord {

   @Test
   public void testCreateStudentRecordWithAllArgConstructor() {
      String name = "Joey";
      LocalDate dob = LocalDate.of(2000, 10, 10);
      String phone = "383 93 393939";
      StudentRecord student = new StudentRecord(10, name, phone, dob, StudentRecord.Status.HIBERNATING);
      StudentRecord student2 = new StudentRecord(10, name, phone, dob, StudentRecord.Status.HIBERNATING);

      assertNotNull(student);
      assertEquals(name, student.name());
      assertEquals(dob, student.dob());

      System.out.println("studentR: " + student);

      if(student.equals(student2)) {
         System.out.println("Equal");
      }
   }

   @Test
   public void testCreateStudentWith3ArgConstructor() {
      StudentRecord studentRecord = new StudentRecord("JOey", "838383", LocalDate.now(), StudentRecord.Status.HIBERNATING);

      assertEquals(0, studentRecord.id());
   }



   class Point
   {
      private int x;
      private int y;

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof Point point)) return false;
         return x == point.x && y == point.y;
      }

      @Override
      public int hashCode() {
         return Objects.hash(x, y);
      }

      public Point(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }

   @Test
   public void testPointEquality() {
      Point p1 = new Point(1, 1);
      Point p2 = new Point(1, 1);

      if(p1.equals(p2)) {
         System.out.println("Equal");
      }else {
         System.out.println("Not Equal");
      }
   }

}
