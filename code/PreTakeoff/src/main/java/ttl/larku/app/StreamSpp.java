package ttl.larku.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import static java.lang.System.out;

public class StreamSpp {

   public static void main(String[] args) {
      StreamSpp mapApp = new StreamSpp();
      //mapApp.extract1();
      //mapApp.extract2();
      mapApp.composeOperations();

   }

   public void composeOperations() {
      StudentService service = new StudentService();
      initService(service);

      List<Student> students = service.getAllStudents();

      List<Student> result1 = filter(students, s -> s.getStatus() == Student.Status.FULL_TIME);
      List<String> finalResult = map(result1, Student::getName);

      finalResult.forEach(out::println);
   }

   public void composeWithStreams() {
      StudentService service = new StudentService();
      initService(service);

      List<Student> students = service.getAllStudents();

      Set<String> names = students.stream()
            .filter(s -> s.getStatus() == Student.Status.FULL_TIME)
            .map(s -> s.getName())
            .collect(Collectors.toSet());

      var result = students.stream()
            .filter(s -> s.getStatus() == Student.Status.FULL_TIME)
            .map(s -> s.getName())
            .collect(Collectors.toSet());


   }


   public <T, R> List<R> map(List<T> students, Function<T, R> extractor) {
      List<R> result = new ArrayList<>();
      for(T t : students) {
         result.add(extractor.apply(t));
      }

      return result;
   }

   public <T> List<T> filter(Collection<T> input, Predicate<T> checker) {
      List<T> result = new ArrayList<>();
      for(T s : input) {
         if(checker.test(s)) {
            result.add(s);
         }
      }

      return result;
   }


   public interface GenericExtractor<T, R> {
      public R extract(T t);
   }
   public <T, R> List<R> betterExtractor(List<T> students, GenericExtractor<T, R> extractor) {
      List<R> result = new ArrayList<>();
      for(T t : students) {
         result.add(extractor.extract(t));
      }

      return result;
   }

   public List<String> badExtractor(List<Student> students) {
      List<String> result = new ArrayList<>();
      for(Student student : students) {
         result.add(student.getName());
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
