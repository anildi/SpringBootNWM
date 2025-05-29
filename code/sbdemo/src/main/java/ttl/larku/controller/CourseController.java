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
import ttl.larku.domain.Course;
import ttl.larku.domain.Student;
import ttl.larku.domain.StudentRecord;
import ttl.larku.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

   @Autowired
   private CourseService courseService;

   @GetMapping
   public List<Course> getCourses() {
      List<Course> courses = courseService.getAllCourses();
      return courses;
   }
}
