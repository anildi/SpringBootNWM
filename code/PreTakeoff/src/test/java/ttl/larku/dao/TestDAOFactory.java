package ttl.larku.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class TestDAOFactory {

   @Test
   public void testThatFactoryCreatesSingletons() {
      StudentDAO dao1 = DAOFactory.getStudentDAO();

      StudentDAO dao2 = DAOFactory.getStudentDAO();

      assertSame(dao1, dao2);
   }
}
