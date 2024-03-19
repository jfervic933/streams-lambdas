/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apistream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class Transformacion {
    
    // Ejemplos con el método map de Streams
    
    public static void main(String[] args) {
        
        List<String> personajes = Arrays.asList("Luke", "Anakin", "Darth Vader", "Chewbacca", "Obi Wan", "Joda", 
                "Han Solo", "Leia", "c3p0", "r2d2", "Anakin", "Chewbacca", "r2d2");
        
        // Obtenemos un Stream de String con los nombres en mayúsucula
        Stream<String> enMayus = personajes.stream().map(cadena->cadena.toUpperCase());
        // Se imprime el Stream por consola 
        System.out.println("------ Lista en mayúsculas -------");
        enMayus.forEach(System.out::println);
        
        System.out.println("--------------");
        
        // Las líneas anteriores se pueden dejar como sigue. Se facilita la lectura y se ve el 
        // encadenamiento de operaciones
        personajes.stream()
                .map(cadena->cadena.toUpperCase())
                .forEach(System.out::println);
        
        // Con una operación final de colección podemos crear una lista con los nombres en minúscula
        List<String> personajesMayus = personajes.stream()
                .map(cadena->cadena.toLowerCase())
                .collect(Collectors.toList());
        // Se imprime la lista
        System.out.println("------ Lista en minúsculas -------");
        personajesMayus.forEach(cadena->System.out.print(" " + cadena));
        System.out.println("");

        // Obtener el número de caracteres de cada nombre de personaje
        personajes.stream()
                .mapToInt(s->s.length())
                .forEach(num->System.out.print(" " + num));
        
        System.out.println("");

    }
    
}
