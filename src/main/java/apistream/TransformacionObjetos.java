/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TransformacionObjetos {
    
    public static void main(String[] args) {
         // ArrayList implementa List, por lo tanto el tipo ArrayList es un tipo List
        List<Persona> contactos = new ArrayList<>();
        
        // La lista mantiene el orden según se van añadiendo los elmentos con add
        contactos.add(new Persona("12345678A", "Pepe", "Perez", LocalDate.of(1997, 1, 2)));
        contactos.add(new Persona("23456789B", "Juan", "López", LocalDate.of(1991, 2, 3)));
        contactos.add(new Persona("34567890C", "Ana", "Ramírez", LocalDate.of(2000, 3, 4)));
        contactos.add(new Persona("45678901D", "María", "López", LocalDate.of(1990, 4, 5)));
        contactos.add(new Persona("45678901S", "Luis", "López", LocalDate.of(1997, 4, 5)));

        // Imprime la lista usando referencia a métodos. Se mantiene el orden según se añadieron los elementos. 
        System.out.println("------- LISTA ORIGINAL --------");
        contactos.forEach(System.out::println);
        
        // Se usa map para obtener en una lista de fechas sólo las fechas de nacimiento
        // En este caso se transforma con map de objetos Persona a objetos LocalDate
        List <LocalDate> fechas = contactos.stream()// Creación del Stream
                .map(p->p.getFechaNac())            // Operación intermedia de transformación
                .collect(Collectors.toList());      // Operación final de colección
        
        System.out.println("------ TODAS LAS FECHAS DE NACIMIENTO ---------");
        fechas.forEach(System.out::println);
        
        // Se usa map para obtener en una lista los nombres 
        // En este caso se transforma de objetos Persona a objetos String
        List <String> nombres = contactos.stream()  // Creación del Stream
                .map(p->p.getNombre())              // Operación intermedia de transformación
                .collect(Collectors.toList());      // Operación final de colección
        
        System.out.println("------ TODOS LOS NOMBRES ---------");
        nombres.forEach(System.out::println);
        
        // Todos los apellidos distintos. En esta ocasión no se crea una lista, se usa un 
        // método final para imprimir. También se usan referencias a métodos Persona::getApellidos
        // Igualmente se transforma de Persona a String
        System.out.println("------ TODOS LOS APELLIDOS DISTINTOS ---------");
        contactos.stream()                      // Creación del Stream
                .map(p->p.getApellidos())     // Operación intermedia de transformación
                .distinct()                     // Operación intermedia de filtrado
                .forEach(System.out::println);  // Operación final consumidora
        
        // Los métodos map transforman los objetos de la colección en otros, en función de la interfaz Function
        // que pasemos como parámetro al método
        
        // Todas las edades ordenadas de mayor a menor. En esta ocasión no se crea una lista, 
        // se usa un método final para imprimir. También se usan referencias a métodos Persona::getEdad
        // Se transforma de Persona a Integer
        System.out.println("------ TODAS LAS EDADES ---------");
        contactos.stream()                          // Creación del Stream
                .map(Persona::getEdad)              // Operación intermedia de transformación
                .sorted(Comparator.reverseOrder())  // Operación inter. de ordenación
                .forEach(System.out::println);      // Operación final consumidora
        
    }
    
}
