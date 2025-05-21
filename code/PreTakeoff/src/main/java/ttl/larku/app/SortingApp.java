package ttl.larku.app;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

public class SortingApp {

   public static void main(String[] args) {
//      simpleSortStudents();
      sortWithComparator();
   }

   public static void simpleSortStudents() {
      StudentService service = new StudentService();
      initService(service);

      List<Student> students = service.getAllStudents();

      Collections.sort(students);

      System.out.println("students.size: " + students.size());
      for(Student s: students) {
         System.out.println(s);
      }
   }

   public static void sortWithComparator() {
      StudentService service = new StudentService();
      initService(service);

      List<Student> students = service.getAllStudents();

      NameComparator nc = new NameComparator();

      Comparator<Student> nc2 = new Comparator<Student>() {
         @Override
         public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
         }
      };

      Comparator<Student> nc3 = (Student o1, Student o2) -> {
            return o1.getName().compareTo(o2.getName());
         };

      Comparator<Student> nc4 = (o1, o2) -> {
         return o1.getName().compareTo(o2.getName());
      };

      Comparator<Student> nc5 = (o1, o2) -> o1.getName().compareTo(o2.getName());


      Collections.sort(students, nc5);

      System.out.println("students.size: " + students.size());
      for(Student s: students) {
         System.out.println(s);
      }
   }


   static class NameComparator implements Comparator<Student> {

      @Override
      public int compare(Student o1, Student o2) {
         int i =  o1.getName().compareTo(o2.getName());
         if(i == 0) {
            i = o1.getDob().compareTo(o2.getDob());
         }
         return i;
      }
   }

//   public static void sortS(List<String> list) {}

   public static <T> void mysort(List<T> list, Comparator<T> c){}

   public static <T extends Comparable<T>> void mysort(List<T> list) {}

   public static void initService(StudentService service) {
      var students = List.of(
            new Student("Johnny", LocalDate.of(1990, 10, 5)),
            new Student("Rachna", LocalDate.of(1960, 10, 8)),
            new Student("Pheroze", LocalDate.of(1947, 8, 16)),
            new Student("Gunnar", LocalDate.of(1980, 5, 5)),
            new Student("Gunnar", LocalDate.of(1982, 5, 5)),
            new Student("Isabella", LocalDate.of(2000, 10, 5))
      );

      students.forEach(student -> service.addStudent(student));
   }

}
