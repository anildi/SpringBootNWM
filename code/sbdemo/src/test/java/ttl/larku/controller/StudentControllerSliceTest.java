package ttl.larku.controller;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {StudentController.class})
@AutoConfigureMockMvc
public class StudentControllerSliceTest {

   @MockitoBean
   private StudentService studentService;

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private ApplicationContext context;

   @BeforeEach
   public void beforeEach() {
      int count = context.getBeanDefinitionCount();
      System.out.println("Num Beans: " + count);
   }

   @Test
   public void testAddStudent() throws Exception {
      var dummyList = List.of(new Student("John"), new Student("Jane"));

      Mockito.when(studentService.getAllStudents()).thenReturn(dummyList);

      ResultActions actions = mockMvc.perform(get("/student").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

      MvcResult mvcResult = actions.andReturn();
      String result = mvcResult.getResponse().getContentAsString();

      System.out.println("result: " + result);
   }

}
