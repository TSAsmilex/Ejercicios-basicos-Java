import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("# Ejercicio 1");
        System.out.println("Anna: "  + ejercicio1("Anna"));
        System.out.println("anna: "  + ejercicio1("anna"));
        System.out.println("Level: " + ejercicio1("level"));
        System.out.println("Nope: "  + ejercicio1("Nope"));

        System.out.println("\n# Ejercicio 2");
        System.out.println("1: "   + ejercicio2(1));
        System.out.println("11: "  + ejercicio2(11));
        System.out.println("123: " + ejercicio2(123));

        System.out.println("\n# Ejercicio 3");
        System.out.println("0! = "  + ejercicio3(0));
        System.out.println("1! = "  + ejercicio3(1));
        System.out.println("2! = "  + ejercicio3(2));
        System.out.println("3! = "  + ejercicio3(3));
        System.out.println("10! = " + ejercicio3(10));
        System.out.println("40! = " + ejercicio3(40));

        System.out.println("\n# Ejercicio 4");
        System.out.println("mcd(2, 3) = " + ejercicio4(2, 3));
        System.out.println("mcd(2, 3) = " + ejercicio4(1, 3));
        System.out.println("mcd(2, 4) = " + ejercicio4(2, 4));

        System.out.println("\n# Ejercicio 5");
        System.out.println("1: "   + ejercicio5(1));
        System.out.println("3: "   + ejercicio5(3));
        System.out.println("371: " + ejercicio5(371));

        System.out.println("\n# Ejercicio 6");
        System.out.println("patata -> " + ejercicio6("patata"));
        System.out.println("Armstrong -> " + ejercicio6("Armstrong"));

        System.out.println("\n# Ejercicio 7");
        System.out.println("2: "   + ejercicio7(2));
        System.out.println("5: "   + ejercicio7(5));
        System.out.println("10: "  + ejercicio7(10));
        System.out.println("13: "  + ejercicio7(13));
        System.out.println("100: " + ejercicio7(100));
        System.out.println("1: "   + ejercicio7(1));

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


    public static long ejercicio4(long u, long v) {
        long t, k;
 
        if (v == 0) return u;
        
        u = Math.abs(u);
        v = Math.abs(v); 
        if (u < v){
          t = u;
          u = v;
          v = t;
        }
       
        for(k = 1; (u & 1) == 0 && (v & 1) == 0; k <<= 1){
          u >>= 1; v >>= 1;
        }
       
        t = (u & 1) != 0 ? -v : u;
        while (t != 0){
          while ((t & 1) == 0) t >>= 1;
       
          if (t > 0)
            u = t;
          else
            v = -t;
       
          t = u - v;
        }
        return u * k;
    }


    public static boolean ejercicio5(int number) {
        // Separar el número en dígitos
        var digits = Arrays.stream(Integer.toString(number)
                           .split(""))
                           .mapToInt(Integer::parseInt);

        var sum_of_cubes = digits.map(a -> a*a*a).sum();
        return number == sum_of_cubes;
    }


    public static String ejercicio6(String s) {
        String result = new String();

        for (int i = s.length()-1; i >= 0; i--) {
            result += s.charAt(i);
        }

        return result;
    }


    public static int ejercicio7(int number) {
        // 2, 3, 5. Calcular el mínimo número de sumas para las que, dado n, 
        // se tiene que la suma de dichos números = n.
        
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(5);
        
        ArrayList<Integer> packets = new ArrayList<>();

        try {
            while (!stack.empty()) {
                var current = stack.peek();
                
                if (current <= number) {         // Greedy -> meter el más grande siempre 
                    packets.add(current);
                    number = number - current;

                    if (number == 0) {      // Hemos terminado; han entrado justos.
                        stack.clear();
                    }
                }
                else {    
                    stack.pop();
                }
            }

            if (number < 0 || packets.size() == 0) {
                throw (new ArithmeticException("No podemos suplir " + number + " con un número de paquetes exacto."));
            }
        }
        catch (ArithmeticException e) { 
            System.out.println(e);
        }

        return packets.size();
    }
}