package otheTopicsExample;

public class StringEqualsExample {
    public static void main(String args[]){
        String s1 = "Hello";// points to String pool object
        String s2 = "Hello";
        String s3 = new String("Hello");//points to heap object
        String s4 = "Hel" + "lo";

        String a = "Hel";
        String b = "lo";
        String s5 = a + b;
        System.out.println(s1 == s5);// False, a + b happens at runtime, creates new object in heap

        final String aa = "Hel";
        final String bb = "lo";
        String s6 = a + b;
        System.out.println(s1 == s6);// true, final makes values compile-time constants, JVM folds them during compilation

        System.out.println(s1 == s4);//true, Compile-time constant- so JVM optimizes "Hel" + "lo" into "Hello" and Both refer to the same pool object
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s3.intern());// true, intern() returns reference from String Pool and not heap reference
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true

        StringBuilder sb1 = new StringBuilder("Hi");
        StringBuilder sb2 = new StringBuilder("Hi");

        System.out.println(sb1 == sb2);//false
        System.out.println(sb1.equals(sb2));//false
        //Note: StringBuilder does NOT override equals()
        //Uses Object’s reference comparison

        String s = "Hello";
        s.concat(" World");
        System.out.println(s);// Hello, why-> String is immutable, Result not assigned


    }
}
