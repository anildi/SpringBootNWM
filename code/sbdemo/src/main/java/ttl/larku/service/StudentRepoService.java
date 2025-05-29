package ttl.larku.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttl.larku.dao.BaseDAO;
import ttl.larku.dao.repository.StudentRepo;
import ttl.larku.domain.Student;

@Service
public class StudentRepoService {

   @Autowired
   private StudentRepo studentDAO;

   public StudentRepoService() {
   }

   private CourseService cs;

   public Student createStudent(String name, String phoneNumber, Student.Status status) {
      Student student = new Student(name, phoneNumber, status);
      student = createStudent(student);

      return student;
   }

   public Student createStudent(String name, String phoneNumber, LocalDate dob, Student.Status status) {
      Student student = new Student(name, phoneNumber, dob, status);
      student = createStudent(student);

      return student;
   }

   public Student createStudent(Student student) {
      student = studentDAO.save(student);

      return student;
   }

   public boolean deleteStudent(int id) {
      if (studentDAO.existsById(id)) {
         studentDAO.deleteById(id);
         return true;
      }
      return false;
   }

   public boolean updateStudent(Student newStudent) {
      if (studentDAO.existsById(newStudent.getId())) {
         studentDAO.save(newStudent);
         return true;
      }
      return false;
   }

   public Student getStudent(int id) {
      return studentDAO.findById(id).orElse(null);
   }

   public List<Student> getAllStudents() {
      return studentDAO.findAll();
   }


   public void clear() {
//      studentDAO.deleteStore();
//      studentDAO.createStore();
   }

   public CourseService getCs() {
      return cs;
   }

   public void setCs(CourseService cs) {
      this.cs = cs;
   }
}
