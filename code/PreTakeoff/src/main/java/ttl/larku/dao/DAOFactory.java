package ttl.larku.dao;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class DAOFactory {

   private static String profile;

   private static Map<String, Object> beans = new ConcurrentHashMap<>();

   static {
      ResourceBundle bundle = ResourceBundle.getBundle("larkUContext");
      profile = bundle.getString("larku.profile.active");
   }


   public static StudentDAO getStudentDAO() {
      return switch (profile) {
         case "dev" -> {
//            StudentDAO dao = (StudentDAO)beans.get("studentDAO");
//            if(dao == null) {
//               dao = new InMemoryStudentDAO();
//               beans.put("studentDAO", dao);
//            }
            StudentDAO dao = (StudentDAO) beans.computeIfAbsent("studentDAO", k -> new InMemoryStudentDAO());
            yield dao;
         }
         case "prod" -> (StudentDAO) beans.computeIfAbsent("studentDAO", k -> new JPAStudentDAO());

         default -> throw new IllegalArgumentException("Unknown profile: " + profile);
      };
   }

   public static StudentDAO getStudentDAOOldSwitch() {
      switch (profile) {
         case "dev":
            return new InMemoryStudentDAO();
         case "prod":
            return new JPAStudentDAO();
         default:
            throw new IllegalArgumentException("Unknown profile: " + profile);
      }
   }
}
