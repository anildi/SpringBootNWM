package ttl.larku.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ttl.larku.domain.Student;
import ttl.larku.domain.StudentRecord;

public class InMemoryStudentRecordDAO {

   private Map<Integer, StudentRecord> students = new HashMap<>();
   private int nextId = 1;

   public StudentRecord insert(StudentRecord student) {
      int id = nextId++;

//      StudentRecord newStudent = new StudentRecord(id, student.name(), student.phoneNumber(),
//            student.dob(), student.status());

      StudentRecord newStudent = student.withId(id);

      students.put(newStudent.id(), student);
      return student;
   }

   public boolean delete(int id) {
      return students.remove(id) != null;
   }

   public boolean update(StudentRecord student) {
      return students.replace(student.id(), student) != null;
   }

   public StudentRecord findById(int id) {
      return students.get(id);
   }

   public List<StudentRecord> findAll() {
      return new ArrayList<>(students.values());
   }
}
