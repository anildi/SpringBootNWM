package ttl.larku.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import static java.lang.System.out;

public class FilterDemo {

   public static void main(String[] args) {
      FilterDemo filterDemo = new FilterDemo();
//      filterDemo.filter1();
//      filterDemo.filter2();
//      filterDemo.filter3();
      //filterDemo.filter4();
      filterDemo.typeErasure();
   }

   public void filter1() {
      StudentService service = new StudentService();
      initService(service);

      List<Student> students = service.getAllStudents();

      List<Student> result = veryBadGetStudentsStartingWithJ(students, "J");

      result.forEach(out::println);

   }

   public void filter2() {
      StudentService service = new StudentService();
      initService(service);

      List<Student> students = service.getAllStudents();

      NameBeginsWithChecker nbwc = new NameBeginsWithChecker();

      Checker c1 = s -> s.getName().startsWith("J");

//      List<Student> result = slightlyBetterChecker(students, c1);

      List<Student> result2 = slightlyBetterChecker(students, s -> s.getName().startsWith("G"));

      List<Student> result3 = slightlyBetterChecker(students, s -> s.getPhoneNumber() != null && s.getPhoneNumber().startsWith("3"));

      List<Student> result4 = slightlyBetterChecker(students, s -> s.getStatus() == Student.Status.HIBERNATING);


      result4.forEach(out::println);

   }

   public void filter3() {
      StudentService service = new StudentService();
      initService(service);

      List<Student> students = service.getAllStudents();

//      NameBeginsWithCheckerGeneric nbwc = new NameBeginsWithCheckerGeneric();
      List<Student> result1 = muchBetterChecker(students, s -> s.getName().startsWith("G"));

      result1.forEach(out::println);

      var lString = List.of("a", "b", "c", "ddddddddddd");
      var lStringS = Set.of("a", "b", "c", "ddddddddddd");

      var result5 = muchBetterChecker(lStringS, str -> str.length() > 5);

      result5.forEach(out::println);

   }

   public void filterWithBestestChecker() {
      StudentService service = new StudentService();
      initService(service);

      List<Student> students = service.getAllStudents();

//      NameBeginsWithCheckerGeneric nbwc = new NameBeginsWithCheckerGeneric();
      List<Student> result1 = bestestChecker(students, s -> s.getName().startsWith("G"));

      result1.forEach(out::println);

      var lString = List.of("a", "b", "c", "ddddddddddd");
      var lStringS = Set.of("a", "b", "c", "ddddddddddd");

      var result5 = muchBetterChecker(lStringS, str -> str.length() > 5);

      result5.forEach(out::println);

   }

   public void filterWithMap() {
      StudentService service = new StudentService();
      initService(service);

      Map<String, String> map = Map.of("1", "one",
            "2", "two",
            "3", "three");

      var result = muchBetterChecker(map, s -> s.startsWith("t"));

      out.println(result);
   }

   public void typeErasure() {
      List<String> lstr = new ArrayList<>() ;
      lstr.add("abc");
//      lstr.add(0);

      List badList = lstr;

      badList.add(0);

      for(String s : lstr) {
         out.println(s.length());
      }

      List l = new ArrayList();
      for(Object o : l) {
         String s = (String) o;
         out.println(s.length());
      }

   }

   public <K, V> Map<K, V> muchBetterChecker(Map<K, V> input, GenericChecker<V> checker) {
      Map<K, V> result = new HashMap<>();
      for(Map.Entry<K, V> entry : input.entrySet()) {
         V t = entry.getValue();
         if(checker.check(t)) {
            result.put(entry.getKey(), t);
         }
      }

      return result;
   }

   public <T> List<T> bestestChecker(Collection<T> input, Predicate<T> checker) {
      List<T> result = new ArrayList<>();
      for(T s : input) {
         if(checker.test(s)) {
            result.add(s);
         }
      }

      return result;
   }

   public <T> List<T> muchBetterChecker(Collection<T> input, GenericChecker<T> checker) {
      List<T> result = new ArrayList<>();
      for(T s : input) {
         if(checker.check(s)) {
            result.add(s);
         }
      }

      return result;
   }

   public List<Student> slightlyBetterChecker(List<Student> input, Checker checker) {
      List<Student> result = new ArrayList<>();
      for(Student s : input) {
         String name = s.getName();
         if(checker.check(s)) {
            result.add(s);
         }
      }

      return result;
   }

   public interface GenericChecker<T> {
      public boolean check(T t);
   }

   public interface Checker {
      boolean check(Student student);
   }

   class NameBeginsWithCheckerGeneric implements GenericChecker<Student> {

      @Override
      public boolean check(Student student) {
         return student.getName().startsWith("J");
      }
   }

   class NameBeginsWithChecker implements Checker {

      @Override
      public boolean check(Student student) {
         return student.getName().startsWith("J");
      }
   }



   public List<Student> veryBadGetStudentsStartingWithJ(List<Student> input, String prefix) {
      List<Student> result = new ArrayList<>();
      for(Student s : input) {
         if(s.getName().startsWith(prefix)) {
            result.add(s);
         }
      }

      return result;
   }

   public List<Student> veryBadGetStudentsPhoneStartingWithJ(List<Student> input, String prefix) {
      List<Student> result = new ArrayList<>();
      for(Student s : input) {
         if(s.getPhoneNumber().startsWith(prefix)) {
            result.add(s);
         }
      }

      return result;
   }

   public static void initService(StudentService service) {
      var students = List.of(
            new Student("Johnny", LocalDate.of(1990, 10, 5), Student.Status.HIBERNATING, "383 83833 38"),
            new Student("Rachna", LocalDate.of(1960, 10, 8), Student.Status.FULL_TIME, "383 83833 38"),
            new Student("Pheroze", LocalDate.of(1947, 8, 16)),
            new Student("Gunnar", LocalDate.of(1980, 5, 5)),
            new Student("Gunnar", LocalDate.of(1982, 5, 5)),
            new Student("Isabella", LocalDate.of(2000, 10, 5))
      );

//      students.forEach(student -> service.addStudent(student));
      students.forEach(service::addStudent);
   }
}
