package ttl.larku.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ttl.larku.dao.jpahibernate.JPAStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.domain.Student.Status;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


/**
 * A straight ahead Unit test.  Only Mockito, no Spring
 */
//@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
//Can use @MockitoSettings to turn on LENIENT mode.
//Then Mockito won't get upset with unused Mocks.
//Probably better to leave it off and get rid of
//unused mocks.
//@MockitoSettings(strictness = Strictness.LENIENT)
@Tag("unit")
public class StudentServiceUnitTest {

    private String name1 = "Bloke";
    private String name2 = "Blokess";
    private String newName = "Karl Jung";
    private String phoneNumber1 = "290 298 4790";
    private String phoneNumber2 = "3838 939 93939";
    private LocalDate dob1 = LocalDate.of(1988, 10, 7);
    private LocalDate dob2 = LocalDate.of(2010, 10, 7);

    @Mock
    private JPAStudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void setup() {
        studentService.clear();
    }

    @Test
    public void testCreateStudent() {
        Student s = new Student(name1, phoneNumber1, dob1, Status.FULL_TIME);

        Mockito.when(studentDAO.insert(s)).thenReturn(s);

        Student newStudent = studentService.createStudent(s);

        Mockito.verify(studentDAO).insert(s);
    }

    @Test
    public void testDeleteStudent() {
        Student student1 = new Student(name1, phoneNumber1, dob1, Status.FULL_TIME);
        student1.setId(1);

        //Set up Mocks
        Mockito.when(studentDAO.findById(1)).thenReturn(student1);
        Mockito.when(studentDAO.delete(student1)).thenReturn(true);

        //Call and JUnit asserts
        boolean result = studentService.deleteStudent(student1.getId());
        assertTrue(result);

        //Mockito verification
        Mockito.verify(studentDAO).findById(1);
        Mockito.verify(studentDAO).delete(student1);
    }

    @Test
    public void testDeleteNonExistentStudent() {

        Mockito.when(studentDAO.findById(9999)).thenReturn(null);
        //Non existent Id
        boolean result = studentService.deleteStudent(9999);
        assertFalse(result);

        Mockito.verify(studentDAO).findById(9999);
        Mockito.verify(studentDAO, never()).delete(any());
    }

    @Test
    public void testUpdateStudent() {
        Student student1 = new Student(name1, phoneNumber1, dob1, Status.FULL_TIME);
        student1.setId(1);

        //Set up Mocks
        Mockito.when(studentDAO.findById(1)).thenReturn(student1);
        Mockito.when(studentDAO.update(student1)).thenReturn(true);

        //Call and Junit assertions
        boolean result = studentService.updateStudent(student1);
        assertTrue(result);

        //Mockito Verification
        Mockito.verify(studentDAO).findById(1);
        Mockito.verify(studentDAO).update(student1);
    }

    @Test
    public void testUpdateNonExistentStudent() {
        Student student1 = new Student(name1, phoneNumber1, dob1, Status.FULL_TIME);
        student1.setId(9999);

        Mockito.when(studentDAO.findById(student1.getId())).thenReturn(null);

        boolean result = studentService.updateStudent(student1);
        assertFalse(result);

        Mockito.verify(studentDAO).findById(9999);
        Mockito.verify(studentDAO, never()).update(student1);
    }
}
