package ttl.larku.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ttl.larku.domain.Student;

public class InMemoryStudentDAO {

//   private List<Student> studentsl = new ArrayList<>();
   //TODO - fix for Concurrency
   private Map<Integer, Student> students = new HashMap<>();
//   private Set<Student> studentSet = new HashSet<>();
   //TODO - fix for Concurrency
   private int nextId = 1;

   public Student insert(Student student) {
      int id = nextId++;

      student.setId(id);
      students.put(student.getId(), student);
      return student;
   }

   public boolean delete(int id) {
      Student result = students.remove(id);
      return result != null;
   }

   public boolean update(Student student) {
      return students.replace(student.getId(), student) != null;
   }

   public Student findById(int id) {
      return students.get(id);
   }

   public List<Student> findAll() {
      return new ArrayList<>(students.values());
   }
}
