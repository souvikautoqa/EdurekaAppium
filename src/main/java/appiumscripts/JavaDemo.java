package appiumscripts;

import java.util.concurrent.TimeUnit;

public class JavaDemo extends AppiumFirstScript{

    public static void main(String[] args) {

    }

    // Access specifiers
    // public, private, protected, default

    // OOPS concepts
    // Inheritance, Polymorphism , Abstarction, Encapsulation

     // variables - Data types    - these are global variables for the class
    int number = 100; //primitive
    String name = "Raghav"; // non primitive

     // Constants - Data types
    final float temp =  13.5f;

     // Constructors - Parameterized and Non Parameterized
    public JavaDemo(String name,int number) {
        // JavaDemo javademo = new JavaDemo();
        // JavaDemo javademo = new JavaDemo("Souvik","1000");
        this.name = name;
        this.number = number;
    }

     // Methods
    public void testMethod(String name,int number){
        String text = " Welcome";
        System.out.println(name);
        System.out.println(number);
        this.name = "asds";
    }

    public void testMethod(String name,int number,boolean status){
        System.out.println(name);
        System.out.println(number);
    }




}
