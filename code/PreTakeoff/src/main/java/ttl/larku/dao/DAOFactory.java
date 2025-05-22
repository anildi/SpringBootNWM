package ttl.larku.dao;

import java.util.ResourceBundle;

public class DAOFactory {

   private static String profile;

   static {
      ResourceBundle bundle = ResourceBundle.getBundle("larkUContext");
      profile = bundle.getString("larku.profile.active");
   }


   public static StudentDAO getStudentDAO() {
      return switch (profile) {
         case "dev" -> new InMemoryStudentDAO();
         case "prod" -> new JPAStudentDAO();
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
