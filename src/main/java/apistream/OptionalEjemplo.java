/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apistream;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public class OptionalEjemplo {

    public static void main(String[] args) {

        List<String> lista = getListaPersonajes();
        
        Optional<String> personaje = buscarPorPosicion(lista, 3);

        // Si hay valor en el optional, se obtiene con get
        if (personaje.isPresent()) {
            String nombrePersonaje = personaje.get();
            System.out.println("Elemento de la posición 3 " + nombrePersonaje);
        }
        

        // Si hay valor en el Optional entonces ejecuta el consumer que se pasa
        personaje.ifPresent(p -> System.out.println("El elemento tiene como valor " + p));

        // Si hay valor lo obtiene y si no entonces muestra el String de orElse
        String nombre = personaje.orElse("No existe el elemento");
        System.out.println("El elemento es " + nombre);

        // Se busca un elemento inexistente
        Optional<String> personaje2 = buscarPorPosicion(lista, 100);
        String nombre2 = personaje2.orElse("No existe el elemento");
        System.out.println("El elemento es: " + nombre2);
        
        // El mismo ejemplo, usando la clase Persona
        List<Persona> listaPersonas = getListaPersonas();
        Optional<Persona> personaOpt = buscarPersonaPosicion(listaPersonas, 1);
        
        // Si hay valor en el optional, se obtiene con get
        if (personaOpt.isPresent()) {
            Persona p = personaOpt.get();
            System.out.println("Nombre de la persona de la posición 1 " + p.getNombre());
        }

        // Si hay valor en el Optional entonces ejecuta el consumer que se pasa
        personaOpt.ifPresent(p -> System.out.println("La persona tiene como apellidos " + p.getApellidos()));

        // Si hay valor lo obtiene y si no devuelve la persona del orElse
        Persona pers = personaOpt.orElse(new Persona());
        System.out.println("La persona es " + pers);

        // Se busca un elemento inexistente
        Optional<Persona> pers2 = buscarPersonaPosicion(listaPersonas, 100);
        pers = pers2.orElse(new Persona("4", "Eva", "Hernández", LocalDate.of(2008, Month.MAY, 23)));
        System.out.println("La persona es: " + pers);

    }

    public static Optional<String> buscarPorPosicion(List<String> lista, int pos) {
        try {
            // Si no hay excepción creo un Optional con el String encontrado
            return Optional.of(lista.get(pos));
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            // Si esa posición no existe en la lista devuelvo un optional vacío
            return Optional.empty();
        }
    }

    public static List<String> getListaPersonajes() {
        List<String> personajes = Arrays.asList("Luke", "Anakin", "Darth Vader", "Chewbacca", "Obi Wan", "Joda",
                "Han Solo", "Leia", "c3p0", "r2d2", "Anakin", "Chewbacca", "r2d2");

        return personajes;
    }

    public static List<Persona> getListaPersonas() {
        Persona[] array = { new Persona(),
                            new Persona("1", "Luis", "López", LocalDate.of(2000, Month.MARCH, 15)),
                            new Persona("2", "María", "Pérez", LocalDate.of(2010, Month.AUGUST, 15)),
                            new Persona("3", "Juan", "Molina", LocalDate.of(1976, Month.FEBRUARY, 18)),
                            new Persona("4", "Eva", "Hernández", LocalDate.of(2008, Month.MAY, 23))
        };
        
        List<Persona> personas = Arrays.asList(array);
  
        
        return personas;
    }
    
     public static Optional<Persona> buscarPersonaPosicion(List<Persona> lista, int pos) {
        try {
            // Si no hay excepción creo un Optional con la Persona encontrada
            return Optional.of(lista.get(pos));
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            // Si esa posición no existe en la lista devuelvo un optional vacío
            return Optional.empty();
        }
    }

}
