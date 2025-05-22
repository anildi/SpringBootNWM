package ttl.larku.app;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import static java.lang.System.out;

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

      out.println("students.size: " + students.size());
      for(Student s: students) {
         out.println(s);
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
      //public static <T> void sort(List<T> list, Comparator<T> c){}
      Collections.sort(students, (o1, o2) -> o1.getName().compareTo(o2.getName()));
      Collections.sort(students, (o1, o2) -> o1.getDob().compareTo(o2.getDob()));

      Collections.sort(students, (o1, o2) ->{
         int i =  o1.getName().compareTo(o2.getName());
         if(i == 0) {
            i = o1.getDob().compareTo(o2.getDob());
         }
         return i;
      });

      Collections.sort(students, (o1, o2) -> compareByNameAndDob(o1, o2));

      Collections.sort(students, SortingApp::compareByNameAndDob);

      out.println("students.size: " + students.size());
      for(Student s: students) {
         out.println(s);
      }

      //void accept(T t)
      students.forEach(s -> out.println(s));

      //students.forEach(out::println);
      students.forEach(SortingApp::prettyPrint);

      List<String> ls = List.of("a", "b", "c", "d");
      ls.forEach(out::println);
   }


   public static void prettyPrint(Student student) {
      out.println("[" + student + "]");
   }

   public static int compareByNameAndDob(Student o1, Student o2) {
      int i =  o1.getName().compareTo(o2.getName());
      if(i == 0) {
         i = o1.getDob().compareTo(o2.getDob());
      }
      return i;
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

   public static <T> void mySort(List<T> list, Comparator<T> comp) {}


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
