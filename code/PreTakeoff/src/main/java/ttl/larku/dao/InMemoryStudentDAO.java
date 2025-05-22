package ttl.larku.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import ttl.larku.domain.Student;

public class InMemoryStudentDAO implements StudentDAO {

//   private List<Student> studentsl = new ArrayList<>();
   //TODO - fix for Concurrency
   private Map<Integer, Student> students = new ConcurrentHashMap<>();
//   private Set<Student> studentSet = new HashSet<>();
   //TODO - fix for Concurrency
//   private int nextId = 1;
   private AtomicInteger nextId = new AtomicInteger(1);

   public InMemoryStudentDAO() {
      int stop = 0;
   }

   @Override
   public Student insert(Student student) {
//      int id = nextId++;
      int id = nextId.getAndIncrement();

      student.setId(id);
      students.put(student.getId(), student);
      return student;
   }

   @Override
   public boolean delete(int id) {
      Student result = students.remove(id);
      return result != null;
   }

   @Override
   public boolean update(Student student) {
      return students.replace(student.getId(), student) != null;
   }

   @Override
   public Student findById(int id) {
      return students.get(id);
   }

   @Override
   public List<Student> findAll() {
      return new ArrayList<>(students.values());
   }
}
