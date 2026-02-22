/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolos_historico;

import java.util.Scanner;

/**
 *
 * @author MARIO
 */
public class Lectura {

    // Se importa el Scanner aqui por que se van a validar todos los mens
    private static Scanner sc = new Scanner(System.in);
    /**
     * Metodo que comprueba SI es un numero y si se encuentra en rango 
     * @param mensaje se pasa el mensaje que se va a mandar al usuario 
     * @param minimo el minimo del rango 
     * @param maximo maximo del rango 
     * @return devuelve el numero despues de comprobarlo 
     */
     static public int validarNumero(String mensaje, int minimo, int maximo) {
        // Se sale del bucle en caso de se encuente en rango
        int numero = -1;
        do {
            System.out.print(mensaje);
            // Comprueba si es un numero
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                sc.nextLine();
                if (numero >= minimo && numero <= maximo) {
                    // Salida esperada del bucle
                    return numero;
                } else {
                    System.err.println("Introduce un número entre " + minimo + " y " + maximo);
                }
            } else {
                System.err.println("Error: Debes introducir un número entero.");
                sc.next(); // Limpiamos el buffer para evitar bucle infinito
            }
        } while (true);
        
    }
     /**
      * Metodo encargada de recoger mensajes 
      * @param mensaje se pasa el mensaje que se va a mandar al usuario 
      * @return devuelve lo que responde el usuario
      */
   static public String leerCadena(String mensaje){
       System.out.print(mensaje);
       String respuesta = sc.nextLine().trim();
       return respuesta;
   }
}
