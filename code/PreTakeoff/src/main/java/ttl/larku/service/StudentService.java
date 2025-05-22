package ttl.larku.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import ttl.larku.dao.DAOFactory;
import ttl.larku.dao.InMemoryStudentDAO;
import ttl.larku.dao.JPAStudentDAO;
import ttl.larku.dao.StudentDAO;
import ttl.larku.domain.Student;

public class StudentService {

   List<String> list = new ArrayList<>();

//   StudentDAO dao = new InMemoryStudentDAO();
//   StudentDAO dao = new JPAStudentDAO();
   private StudentDAO dao;

   public StudentService() {
      int stop = 0;
   }

   public Student addStudent(Student student) {
      long age = student.getDob().until(LocalDate.now(), ChronoUnit.YEARS);

      if(age < 18) {
         throw new IllegalArgumentException("Age must be at least 18");
      }

      return dao.insert(student);
   }

   public boolean deleteStudent(int id) {
      return dao.delete(id);
   }

   public boolean updateStudent(Student student) {
      return dao.update(student);
   }

   public Student getStudentById(int id) {
      return dao.findById(id);
   }

   public List<Student> getAllStudents() {
      return dao.findAll();
   }

//   public JPAStudentDAO getStudentDAO() {
   public StudentDAO getStudentDAO() {
      return dao;
   }

   public void setStudentDAO(StudentDAO dao) {
      this.dao = dao;
   }

}
