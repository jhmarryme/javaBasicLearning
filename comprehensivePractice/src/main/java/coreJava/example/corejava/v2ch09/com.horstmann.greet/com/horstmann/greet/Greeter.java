package coreJava.example.corejava.v2ch09.com.horstmann.greet.com.horstmann.greet;

public interface Greeter
{
   static Greeter newInstance()
   {
      return new com.horstmann.greet.internal.GreeterImpl();
   }

   String greet(String subject);
}
