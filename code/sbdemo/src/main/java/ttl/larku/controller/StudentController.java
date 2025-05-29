package ttl.larku.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ttl.larku.domain.Student;
import ttl.larku.domain.StudentRecord;
import ttl.larku.service.StudentService;
import ttl.track.domain.Track;
import ttl.track.service.TrackService;

@RestController
@RequestMapping("/student")
public class StudentController {

   @Autowired
   private StudentService studentService;

   @GetMapping
   public List<Student> getStudents() {
      List<Student> students = studentService.getAllStudents();
      return students;
   }

   @GetMapping("/{id}")
   public Student getStudent(@PathVariable("id") int id) {
     Student student = studentService.getStudent(id);
     return student;
   }

   @PostMapping
   public Student addStudent(@RequestBody Student student,
                             @RequestHeader Map<String, String> header) {
      Student newStudent = studentService.createStudent(student);
      return newStudent;
   }

   @PostMapping("/record")
   public StudentRecord addStudent(@RequestBody StudentRecord student,
                             @RequestHeader Map<String, String> header) {
      int stop = 0;
      return student;
   }
}
