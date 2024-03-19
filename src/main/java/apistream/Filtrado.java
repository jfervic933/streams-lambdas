
package apistream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class Filtrado {

    public static void main(String[] args) {

        /* OPERACIONES INTERMEDIAS DE FILTRADO CON FILTER, SKIP, LIMIT Y DISTINCT */
        
        List<String> personajes = Arrays.asList("Luke", "Anakin", "Darth Vader", "Chewbacca", "Obi Wan", "Joda", 
                "Han Solo", "Leia", "c3p0", "r2d2", "Anakin", "Chewbacca", "r2d2");

        // Obtenemos un stream con todos los personajes que empiezan por C
        // usando el método filter. Se pasa una expresión lambda que implementa Predicate
        // Predicate<String> predicado = s -> s.startsWith("C");
        Stream<String> personajesConC = personajes.stream().filter(s -> s.startsWith("C"));
        System.out.println(" --------- Personajes que empiezan por la letra C");
        personajesConC.forEach(System.out::println);
        // El Stream personajesConC ya no se puede volver a utilizar, porque ya se ha usado una vez
        
        // Obtenemos un stream con todos los personajes sin repetir.
        Stream<String> personajesSinRepetir = personajes.stream().distinct();
        System.out.println(" --------- Personajes sin repetir");
        personajesSinRepetir.forEach(System.out::println);
        
        // Obtenemos un stream con los 5 primeros
        Stream<String> primerosCinco = personajes.stream().limit(5);
        System.out.println(" --------- Los 5 primeros");
        primerosCinco.forEach(System.out::println);  
        
        // Obtenemos un stream que descarta los 4 elementos iniciales y además sin repetidos
        Stream<String> sinLosCuatroPrimerosYsinRepetidos = personajes.stream().skip(4).distinct();
        System.out.println(" --------- Sin los cuatro primeros y sin repetir");
        sinLosCuatroPrimerosYsinRepetidos.forEach(System.out::println);
        
         /* OPERACION FINAL RESUMEN CON COUNT */
         // Calcular el número de personajes sin repetir que hay en la lista, quitando los cuatro primeros
         long numero = personajes.stream().skip(4).distinct().count();
         System.out.println("Número sin los cuatro primeros y sin repetir: " + numero);
    }

}
