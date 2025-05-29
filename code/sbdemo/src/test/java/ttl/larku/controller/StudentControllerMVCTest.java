package ttl.larku.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class StudentControllerMVCTest {

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
   public void testGetAllStudents() throws Exception {

      ResultActions actions = mockMvc.perform(
               get("/student").accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk());

      MvcResult mvcResult = actions.andReturn();
      String result = mvcResult.getResponse().getContentAsString();

      System.out.println("result: " + result);
   }

}
