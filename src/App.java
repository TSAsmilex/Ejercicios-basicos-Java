import java.math.BigInteger;
import java.util.stream.IntStream;

import org.w3c.dom.ranges.Range;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Ejercicio 1: \n");
        System.out.println("Anna: "  + ejercicio1("Anna"));
        System.out.println("anna: "  + ejercicio1("anna"));
        System.out.println("Level: " + ejercicio1("level"));
        System.out.println("Nope: "  + ejercicio1("Nope"));

        System.out.println("Ejercicio 2: \n");
        System.out.println("1: " + ejercicio2(1));
        System.out.println("11: " + ejercicio2(11));
        System.out.println("123: " + ejercicio2(123));

        System.out.print("Ejercicio 3\n");
        System.out.println("0! = " + ejercicio3(0));
        System.out.println("1! = " + ejercicio3(1));
        System.out.println("2! = " + ejercicio3(2));
        System.out.println("3! = " + ejercicio3(3));
        System.out.println("10! = " + ejercicio3(10));
        System.out.println("40! = " + ejercicio3(40));
    }

    
    public static boolean ejercicio1(String word) {
        word = word.toLowerCase();
        word = word.strip();

        int size = word.length();
        
        int start = 0, end = word.length()-1; 
        boolean is_palindrome = true;

        while (start <= size/2 && is_palindrome) {
            is_palindrome = word.charAt(start) == word.charAt(end);
            start++;
            end--;
        }

        return is_palindrome;
    }


    public static boolean ejercicio2(int number) {
        return ejercicio1(Integer.toString(number));
    }


    public static int ejercicio3(int number) {
        var list = IntStream.range(1, number + 1);
        return list.reduce(1, (a, b) -> a * b);
    }


    public static void ejercicio4() {

    }


    public static void ejercicio5() {

    }


    public static void ejercicio6() {

    }


    public static void ejercicio7() {

    }
}