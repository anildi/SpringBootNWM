package ttl.larku.app.tricky;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

interface Trick {
   public void doTrick();
}

@Component
//@Primary
//@Profile("west")
@Qualifier("easy")
@Order(2)
class Trick1 implements Trick {

   @Override
   public void doTrick() {
      System.out.println("Handstand");
   }
}

@Component
//@Profile("east")
@Qualifier("easy")
@Order(1)
class Trick2 implements Trick {

   @Override
   public void doTrick() {
      System.out.println("Somersault");
   }
}

@Component
//@Profile("east")
@Qualifier("hard")
class Trick3 implements Trick {

   @Override
   public void doTrick() {
      System.out.println("Back Flip");
   }
}

@Component
class Circus {
   @Autowired
   @Qualifier("easy")
   private List<Trick> tricks;

   @Autowired
   @Qualifier("hard")
   private List<Trick> hardTricks;

   public void startShow() {
//      trick.doTrick();
      for (Trick trick : tricks) {
         trick.doTrick();
      }
   }

   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
      context.getEnvironment().setActiveProfiles("west");
      context.scan("ttl.larku.app.tricky");
      context.refresh();

      Circus circus = context.getBean("circus", Circus.class);
      circus.startShow();
   }
}