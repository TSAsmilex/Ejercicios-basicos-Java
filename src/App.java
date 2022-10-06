import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

        System.out.println("\n# Fibonacci recursivo");
        System.out.println("0: "   + fibonacci(0));
        System.out.println("1: "   + fibonacci(1));
        System.out.println("2: "   + fibonacci(2));
        System.out.println("5: "   + fibonacci(5));
        System.out.println("10: "  + fibonacci(10));
        System.out.println("13: "  + fibonacci(13));
        System.out.println("20: "  + fibonacci(20));

        System.out.println("\n# Fibonacci dinámico");
        System.out.println("0: "   + fibonacci_dynamic(0));
        System.out.println("1: "   + fibonacci_dynamic(1));
        System.out.println("2: "   + fibonacci_dynamic(2));
        System.out.println("5: "   + fibonacci_dynamic(5));
        System.out.println("10: "  + fibonacci_dynamic(10));
        System.out.println("13: "  + fibonacci_dynamic(13));
        System.out.println("20: "  + fibonacci_dynamic(20));
    }

    
    public static boolean ejercicio1(String word) {
        /* 
          Comprobar si un string es palíndromo o no.

          Idea: coger dos iteradores: uno por delante, y otro por detrás. Hacerlos
          avanzar hasta que se encuentren.

          Si por el camino los valores que toman son diferentes, 
          entonces la palabra no es un palíndromo
        */
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
        /*
            Comprobar si un número es un palíndromo.

            Idea: reutiliza la función anterior :)
        */
        return ejercicio1(Integer.toString(number));
    }


    public static int ejercicio3(int number) {
        /*
            Calcular el factorial de un número.

            Idea básica: coge un acumulador, e itera desde i = 0 hasta dicho número, 
            multiplicando los números de uno a uno. 

            Idea de mi implementación: considera una lista de todos los números 
            desde 1 hasta n, y mediante programación funcional, multiplícalos.
        */

        var list = IntStream.range(1, number + 1);
        return list.reduce(1, (a, b) -> a * b);
    }


    public static long ejercicio4(long u, long v) {
        /*  
            GCD binario iterativo 
            https://rosettacode.org/wiki/Greatest_common_divisor#Java    
            
            Sí, esto no hay quien lo entienda, pero lo hice en su momento y             
            me ha dado nostalgia.
            
            (También llamado síndrome de Estocolmo)
        */

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
        /*
            Comprobar si un número es de Amstrong.

            Un número de Amstrong es aquel para el cual la suma de los cubos de sus dígitos
            coincide con dicho número.

            Esta implementación hace exactamente eso, mediante programación funcional. 
        */

        // Separar el número en dígitos
        var digits = Arrays.stream(Integer.toString(number)
                           .split(""))
                           .mapToInt(Integer::parseInt);

        var sum_of_cubes = digits.map(a -> a*a*a).sum();
        return number == sum_of_cubes;
    }


    public static String ejercicio6(String s) {
        /*
            Revertir un string

            Idea: empieza desde el final, y concaténale los caracteres a un nuevo string. 
        */

        String result = new String();

        for (int i = s.length()-1; i >= 0; i--) {
            result += s.charAt(i);
        }

        return result;
    }


    public static int ejercicio7(int number) {
        /*
            Calcular el mínimo número de términos para las que, dado n, se tiene que 
            la suma de dichos números = n; siendo los únicos posibles 2, 3, y 5. 

            Esta implementación utiliza un greedy. 
            En esencia, tomamos el máximo valor posible, e intentamos meterlo hasta que se pasa.
            Cuando eso ocurra, pasamos al siguiente más pequeño. 

            Si llegamos a una situación en la que no podemos continuar, lanza una excepción. 
        */
        
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


    public static int fibonacci(int n) {
        /*
            Fibonacci recursivo.

            El término n-ésimo de la función de Fibonacci F_n viene dado por 
                
                F_n = F_{n-1} + F_{n-2}

            La implementación recursiva se utiliza *literalmente* esa misma definición.

            Únicamente hay que encargarse de gestionar los casos básicos.
        */

        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n < 0) {
            throw (new ArithmeticException("n debe ser no negativo"));
        }
        else {
            return (fibonacci(n - 1) + fibonacci(n - 2));
        }        
    }


    static HashMap<Integer, Integer> fn = new HashMap<>();
    
    public static int fibonacci_dynamic(int n) {
        /*
            Fibonacci con programación dinámica.

            Idea de la programación dinámica:
        
                > "Those who forget history are condemned to repeat it" 
            
            Es decir, si has hecho un cálculo, no lo vuelvas a repetir. 

            Por ejemplo, para calcular F_3, necesitas F_2, F_1, F_0.
            Si quieres hacer justo después F_4, deberías calcular F_3, F_2, F_1 y F_0. 
            Si al hacer guardas los cálculos de F_3, F_4 solo debe consultarlos. 

            Para ello, vamos a crear un nuevo miembro para la clase (i.e., static), el cual podrá 
            consultar la función en cualquier momento. 
            He escogido un HashMap por la comodidad que presenta para este caso. Esta estructura
            nos proporciona un par clave - valor. 
            Dada una clave, nos proporciona el valor asociado. Nos podemos imaginar esta estructura como 
                
                {
                    clave1 -> valor1, 
                    clave2 -> valor2, 
                    ...
                }
            
            En este caso, podemos guardarnos lo siguiente:

                {
                    0 -> 0, 
                    1 -> 1, 
                    2 -> F_2, 
                    3 -> F_3,
                    ...
                }
            
            Y el método podrá cnsultar en cualquier momento este map dada una cierta clave.
        */

        // Inicialización del HashMap.
        // Esto, en principio, habría que hacerlo en el propio constructor de la clase,
        // y evitar este tipo de operaciones dentro de la función.
        // Sin embargo, por temas de legibilidad y didáctiva, lo dejo aquí.

        if (fn.size() == 0) {
            fn.put(0, 0);
            fn.put(1, 1);
        }
        
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n < 0) {
            throw (new ArithmeticException("n debe ser no negativo"));
        }

        if (fn.containsKey(n)) {
            return fn.get(n - 1) + fn.get(n - 2);
        }
        else {
            var actual = fibonacci_dynamic(n - 1) + fibonacci_dynamic(n - 2);
            fn.put(n, actual);  
            return actual;
        }
    }
}