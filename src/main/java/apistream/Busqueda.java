
package apistream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class Busqueda {

    public static void main(String[] args) {

        List<String> personajes = Arrays.asList("Lu", "Anakin", "Darth Vader", "Chewbacca", "Obi Wan", "Joda",
                "Han Solo", "Leia", "c3p0", "r2d2", "Anakin", "Chewbacca", "r2d2");
        
        List<String> vacia = Collections.EMPTY_LIST;

        // Verificamos si TODOS los elementos cumplen una condición con allMatch
        // En particular, que la longitud de la cadena de caracteres sea mayor o igual que 4.
        Predicate<String> longitudMayor3 = x -> x.length()>3;
        boolean longitud = personajes.stream().allMatch(longitudMayor3);
      

        String mensajeLongitud = (longitud) ? "Todos los nombres tienen 4 o más caracteres"
                : "Hay algún nombre con menos de 4 caracteres";

        System.out.println(mensajeLongitud);
        System.out.println("");

        // Verificamos si ALGUNO de los elementos cumple con una condición
        boolean luke = personajes.stream().anyMatch((s) -> s.equalsIgnoreCase("luke"));
        String mensaje = (luke) ? "Luke está en la lista" : "Luke no está en la lista";
        System.out.println(mensaje);
        System.out.println("");

        // La inversa de allMatch es noneMatch
        boolean noneMatchLongitud = personajes.stream().noneMatch(s -> s.length() >= 4);

        String mensajenoneMatchLongitud = (noneMatchLongitud) ? "Todas los personajes tienen menos de 4 caracteres"
                : "Hay algún personaje con 4 caracteres o más";

        System.out.println(mensajenoneMatchLongitud);
        System.out.println("");

        // Localiza el primer elemento del Stream y lo devuelve en tipo Optional
        // Optional básicamente encapsula información que puede ser null
        // Desde Java 8 métodos de la api stream devuelven Optional en lugar de null
        Optional<String> primero = personajes.stream().findFirst();
        System.out.println(primero.orElse("No quedan nombres en el Stream"));
        System.out.println("");
        
        primero = vacia.stream().findFirst();
        System.out.println(primero.orElse("No quedan nombres en el Stream"));
        System.out.println("");

    }

}
