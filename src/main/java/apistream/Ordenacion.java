
package apistream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class Ordenacion {
    
    public static void main(String[] args) {
        
        List<Persona> contactos = new ArrayList<>();
        
        // La lista mantiene el orden según se van añadiendo los elmentos con add
        contactos.add(new Persona("92345678A", "Pepe", "Perez", LocalDate.of(1997, 1, 2)));
        contactos.add(new Persona("03456789B", "Juan", "López", LocalDate.of(1991, 2, 3)));
        contactos.add(new Persona("34567890C", "Ana", "Ramírez", LocalDate.of(1996, 3, 4)));
        contactos.add(new Persona("85678901D", "María", "Fernández", LocalDate.of(1990, 4, 5)));
        contactos.add(new Persona("75678901S", "Luis", "López", LocalDate.of(1997, 4, 5)));

        // Imprime la lista usando referencia a métodos. Se mantiene el orden según se añadieron los elementos. 
        System.out.println("------- LISTA ORIGINAL --------");
        contactos.forEach(System.out::println);
        
        // ------ EJEMPLOS DE ORDENACIÓN SIN API STREAM ----------------------//
        
        // Ordenamos mediante clase interna anónima
        // El criterio de ordenación es el NIF
        contactos.sort(new Comparator<Persona>(){
             @Override
             public int compare(Persona o1, Persona o2) {
                 return o1.getNif().compareTo(o2.getNif());
             }
            
        });
        
        // La ordenación anterior con clase anónima equivale a la siguiente
        // ordenación usando expresiones lambda
        // contactos.sort((o1, o2) -> o1.getNif().compareTo(o2.getNif()));
        
        System.out.println("------- LISTA ORDENADA POR NIF -------");
        contactos.forEach(System.out::println);
        
        // Ordenamos mediante clase interna anónima
        // El criterio de ordenación es la fecha de nacimiento
        contactos.sort(new Comparator<Persona>(){
             @Override
             public int compare(Persona o1, Persona o2) {
                 return o1.getFechaNac().compareTo(o2.getFechaNac());
             }
            
        });
        
        // La ordenación anterior con clase anónima equivale a la siguiente
        // ordenación usando expresiones lambda
        //contactos.sort((p1,p2)->p1.getFechaNac().compareTo(p2.getFechaNac()));
        
        System.out.println("------- LISTA ORDENADA POR FECHA NACIMIENTO -------");
        contactos.forEach(System.out::println);
        
        // ------ EJEMPLOS DE ORDENACIÓN CON API STREAM ----------------------//
        
        // Ordenación por nombre y salida por consola
        System.out.println("------- LISTA ORDENADA POR FECHA NOMBRE -------");
        contactos.stream()
                .sorted((p1,p2)->p1.getNombre().compareTo(p2.getNombre()))
                .forEach(System.out::println);
        
        // Ordenación por fecha de nacimiento y salida por consola
        System.out.println("------- LISTA ORDENADA POR FECHA -------");
        contactos.stream()
                .sorted((p1,p2)->p1.getFechaNac().compareTo(p2.getFechaNac()))
                .forEach(System.out::println);
        
        // Ordenación por apellidos y creación de una nueva lista con las fechas
        // según la ordenación de los apellidos
        System.out.println("------- LISTA ORDENADA POR FECHA -------");
        List <LocalDate> fechas = contactos.stream()
                .sorted((p1,p2)->p1.getApellidos().compareTo(p2.getApellidos()))
                .map(p->p.getFechaNac())
                .collect(Collectors.toList());
        
        fechas.forEach(System.out::println);
    }
    
}
