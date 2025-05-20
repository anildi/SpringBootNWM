package ttl.larku.domain;

import java.time.LocalDate;
import java.util.Objects;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestStudent {

   @Test
   public void testCreateStudentWithAllArgConstructor() {
      String name = "Joey";
      LocalDate dob = LocalDate.of(2000, 10, 10);
      String phone = "383 93 393939";
      Student student = new Student(1, name, dob, Student.Status.HIBERNATING, phone);

//      student.setId(1);
//      student.setName(name);
////      student.setDob(dob);
//      student.setPhoneNumber("383 92 303030303");

      LocalDate ld = student.getDob();
      int month = ld.getMonthValue();

      assertNotNull(student);
      assertEquals(name, student.getName());
      assertEquals(dob, student.getDob());
   }

   @Test
   public void testCreateStudentWith3ArgConstructor() {
      String name = "Joey";
      LocalDate dob = LocalDate.of(2000, 10, 10);
      String phone = "383 93 393939";
      Student.Status status = Student.Status.FULL_TIME;

      Student student = new Student(1, name, dob);

      System.out.println("Student: " + student);


      assertNotNull(student);
      assertEquals(name, student.getName());
      assertEquals(dob, student.getDob());
      assertEquals(status, student.getStatus());

      assertNull(student.getPhoneNumber());
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
