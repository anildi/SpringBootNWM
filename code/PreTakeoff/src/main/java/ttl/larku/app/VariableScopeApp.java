package ttl.larku.app;

import java.util.ArrayList;
import java.util.List;

public class VariableScopeApp {

   public static void main(String[] args) {
      VariableScopeApp app = new VariableScopeApp();

//      app.go();
//      app.go2();
      app.go4();
//      app.go5();
   }

   record Point(int x, int y) {
      public void fun() {

      }
   }

   public void go() {
      Point p;
      p = new Point(1, 2);

      Point p2 = p;

      p2 = new Point(3, 4);
   }

   public void go2() {
      Point result = makePoint();

      System.out.println("result: " + result);
   }

   public Point makePoint() {
     Point p = new Point(1, 2);

     return p;
   }


   public void go3() {
//      var list = List.of("a", "b", "c");
      var list = List.of(new Point(0, 0),
            new Point(2, 3),
            new Point(4, 5));

      var list2 = new ArrayList<>();
      list.forEach(list2::add);
   }

   public void go4() {
      int i = 0;
      String s = "abc";
      String s2 = new String("abc");

      if(s.equals(s2)) {
         System.out.println("Equals");
      } else {
         System.out.println("Not Equals");
      }


      var list = List.of("a", "b", "c");

      var list2 = new ArrayList<>();
      list.forEach(list2::add);
   }

   public void go5() {
      List<Integer> list = new ArrayList<>();

      list.add(Integer.valueOf(1));
      list.add(1);

      list.forEach(x -> System.out.println(x.getClass()));
   }
}
