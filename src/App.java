public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Ejercicio 1: \n");
        System.out.println("Anna: "  + ejercicio1("Anna"));
        System.out.println("anna: "  + ejercicio1("anna"));
        System.out.println("Level: " + ejercicio1("level"));
        System.out.println("Nope: "  + ejercicio1("Nope"));
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


    public static void ejercicio2() {

    }


    public static void ejercicio3() {

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
