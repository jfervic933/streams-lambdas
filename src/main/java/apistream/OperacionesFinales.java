
package apistream;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class OperacionesFinales {
    
    public static void main(String[] args) {
        
        int [] array = {3,2,1,6,5,4,9,10,7,8};
        
        // Se puede crear un Stream de tipo entero a partir del array
        IntStream stream = IntStream.of(array);
        
        // Funciones de reducción mediante conteo, suma, min, max, etc
        // Contar número de elementos
        System.out.println("Cantidad " + IntStream.of(array).count());
        
        // Mínimo y máximo. Devuelven un Optional
        // Un Optional es un contenedor de objetos que viene a ayudar con los punteros null
        // Si no es null entonces getAsInt() devuelve su valor, en otro caso lanza una excepción NoSuchElement
        System.out.println("Mínimo " + IntStream.of(array).min().getAsInt());
        System.out.println("Máximo " + IntStream.of(array).max().getAsInt());
        
        // Para evitar la posible excepción, se pueden implementar de la siguiente forma
        // suponiendo que si no existe el elemento porque el array está vacío entonces se devuelve cero
        System.out.println("Mínimo " + IntStream.of(array).min().orElse(Integer.MIN_VALUE));
        System.out.println("Máximo " + IntStream.of(array).max().orElse(Integer.MAX_VALUE));
        
        // Suma y media de los elementos
        System.out.println("Suma " + IntStream.of(array).sum());
        System.out.println("Media " +  IntStream.of(array).average().getAsDouble());
        
        // Producto de todos los valores, siendo el primer valor del producto 1
        // Básicamente aplica una acumulación de valores del siguiente tipo
        // int acumulador = 1;
        // for (int i = 0; i<array.length;i++){
        //      acumulador = acumulador * array[i];
        // }
        System.out.println("Producto usando el método reduce "
                + IntStream.of(array).reduce(1, (x, y) -> x * y));
        
        // Números impares
        System.out.println("Imprimiento los impares ");
        IntStream.of(array).filter(i->i%2!=0).forEach(System.out::println);
        
        // Números impares ordenados
        System.out.println("Imprimiento los impares ");
        IntStream.of(array)
                .filter(i->i%2!=0).sorted()
                .forEach(System.out::println);
        
        // Números mayores de 5, multiplicados por dos y mostrados de forma ordenada
        System.out.println("Mayores de 5 ordenados");
        IntStream.of(array)
                .filter(i->i>5)
                .sorted()
                .map(i->i*2)
                .forEach(System.out::println);
        
        // Números pares elevados al cuadrado
        System.out.print("Números pares elevados al cuadrado, sin ordenar ");
        IntStream.of(array)
                .filter(i->i%2==0)
                .map(i->(int)Math.pow(i, 2))
                .forEach(i->System.out.print(" - " + i));
        System.out.println("");
        
        // Array de 50 números aleatorios entre 0 y 101
        // new Random().ints() devuelve un Stream de int
        int[] arrayAleatorios = new Random().ints(50, 0, 101).toArray();
        // Lista de 25 números enteros aleatorios entre 10 y 110
        // El Stream de int se pasa a Stream de Integer con el metodo boxed()
        List<Integer> listaEnteros = new Random().ints(25, 10, 111).boxed().distinct().collect(Collectors.toList());
    }
    
}
