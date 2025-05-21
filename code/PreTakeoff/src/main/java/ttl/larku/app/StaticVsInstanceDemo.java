package ttl.larku.app;

public class StaticVsInstanceDemo {

   private static int count;

   private int value = 10;

   public static void main(String[] args) {
      System.out.println("Hello World!");

      var s2 = new StaticVsInstanceDemo();
      s2.value++;

      var s3 = new StaticVsInstanceDemo();
      s3.value++;

      count++;
   }

   public static void staticMethod() {
      System.out.println("InstanceMethod");
      var ic = new InnerClass();
   }

   public void instanceMethod() {
      System.out.println("InstanceMethod");

      var ic = new InnerClass();
   }

   public static class InnerClass {

   }
}

class Point {
   int x;
   int y;

   public void fun() {
      StaticVsInstanceDemo.staticMethod();

      var svid = new StaticVsInstanceDemo();
      svid.instanceMethod();

      var ic = new StaticVsInstanceDemo.InnerClass();
   }
}
