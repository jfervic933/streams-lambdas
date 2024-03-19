/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author carlos
 */
public class EjemplosLambda {
    
    public static void main(String[] args) {
        
        // Function. Se le pasa un argumento y devuelve otro
        // En este caso se pasa un Integer y devuelve un String al llamar a apply()
        Function<Integer,String> funcion = x->"Tu número es " + x;
        System.out.println(funcion.apply(56));
        
        // BiFunction. Se le pasan dos argumentos y devuelve otro
        // En este ejemplo recibe dos enteros y devuelve otro resultado de la
        // operación, tras llamar a apply()
        BiFunction <Integer, Integer, Integer> biFuncion = (x,y) -> (x*y)+10;
        System.out.println(biFuncion.apply(10, 20));
        
        BiFunction <Integer, Double, String> biFuncion2 = 
                 (x,y) -> x + " * " + y + " es igual a "+ (x*y);
         
        System.out.println(biFuncion2.apply(2, 3.5));
        
        // Consumer. Se le pasa un argumento y no devuelve nada
        Integer[] array = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(array);
        // Se le pasa una lista a Consumer
        Consumer<List<Integer>> listaInt = lista-> {
            for (int i = 0; i < lista.size(); i++) {
                lista.set(i, 2*lista.get(i));
            }
        };
        // Al llamar al método accept realiza la operación que implementa
        listaInt.accept(list);
        System.out.println(list);
        
        Consumer <String> imprimir = nombre -> System.out.println("Mi nombre es" + nombre);
        imprimir.accept("Juan Carlos");
        
        // BiConsumer recibe dos argumentos, igualmente no devuelve nada
        Persona sinNombre = new Persona("", "Pérez", "22222F");
        System.out.println(sinNombre);
        // En este caso esta lamda, al llamar a accept cambiar el nombre de la persona
        BiConsumer<String, Persona> biConsumer = (nombre, persona) -> persona.setNombre(nombre);
        biConsumer.accept("Carlos", sinNombre);
        
        System.out.println(sinNombre);
        
        // Predicate. Recibe un parámetro y devuelve un booleano al llamar al 
        // método test
        Predicate<Integer> mayorQueCinco = x->x>5;
        System.out.println("Mayor que cinco " + mayorQueCinco.test(2)); // Devuelve false
        
        // BiPredicate. Recibe dos parámetro y devuelve un booleano al llamar al 
        // método test
        BiPredicate<Persona, String> nombrePersona = (p, nombre)->p.getNombre().equals(nombre);
        System.out.println(nombrePersona.test(sinNombre, "Carlos"));
        
        // Supplier. No tienen parámetros. Producen un valor del tipo del que
        // se declaran al llamar al método get().
        // En este caso esta lambda devuelve un String
        Supplier<String> saludo = ()->"Ya mismo nos vamos";
        System.out.println(saludo.get());
        
        // Aquí un objeto Persona
        Supplier<Persona> crearPersona = ()->new Persona();
        System.out.println(crearPersona.get());
        
        // Aquí llama a un método de clase que devuelve un aleatorio
        Supplier<Integer> entero = ()->enteroAlea();
        System.out.println(entero.get());
        
    }
    
    public static Integer enteroAlea(){
        Random x = new Random();
        return x.nextInt();
    }
    
}
