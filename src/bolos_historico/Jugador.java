/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolos_historico;

import java.util.Random;

/**
 *
 * @author MARIO
 */
public class Jugador {

    // Se declaran ambas constante debido a no se va a 
    // ni a cambiar el nombre ni la precision
    private final String nombre;
    private final int precision;
    
    private int tiradas;

    // Constante de configuracion del juego 
    private static final int MAX_BOLOS = 10;
    private final int MAX_PRECISION = 10;

    private Random random;

    // Se realizan comprobaciones antes llamar al constructor de rango y de mensajes
    public Jugador(String nombre, int precision) {
        this.nombre = nombre;
        this.precision = precision;
        this.random = new Random();
        this.tiradas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecision() {
        return precision;
    }

    public static int getMAX_BOLOS() {
        return MAX_BOLOS;
    }

    public int getTiradas() {
        return tiradas;
    }
    

    /**
     * Este método devolverá los bolos derribados en cada ronda. Pero esto
     * dependerá del tipo de tiro y del nivel de precisión String tiro
     * procedente del ENUM
     *
     * @return
     */
    public int bolosDerribados(TipoTiro tiro) {
        int probabilidadDeFallo = generarNumeroRandom(0, 100);
        int bolos = 0;
        // Switch depende del tiro y dentro if depende del a precision
        switch (tiro) {
            case NORMAL -> {
                if (precision <= 3) {
                    bolos = (probabilidadDeFallo <= 30) ? 0 : generarNumeroRandom(1, 6);
                } else if (precision <= 7) {
                    bolos = (probabilidadDeFallo <= 10) ? 0 : generarNumeroRandom(3, 8);
                } else {
                    bolos = generarNumeroRandom(6, 10);
                }
            }
            case POTENTE -> {
                if (precision < 4) {
                    bolos = (probabilidadDeFallo <= 60) ? 0 : generarNumeroRandom(5, 8);
                } else {
                    bolos = (probabilidadDeFallo <= 35) ? 0 : generarNumeroRandom(8, 10);
                }
            }
            case EFECTO -> {
                if (precision <= 5) {
                    bolos = (probabilidadDeFallo <= 65) ? 0 : generarNumeroRandom(0, 4);
                } else {
                    bolos = (probabilidadDeFallo <= 10) ? 0 : generarNumeroRandom(7, 10);
                }
            }
        }
        tiradas++;
        return bolos;
    }

    /**
     * Este metodo genera un numero random dentro de un rango
     *
     * @param minimo
     * @param maximo
     * @return devuelve ese numero
     */
    private int generarNumeroRandom(int minimo, int maximo) {
        // Se genera un numero random y luego se devuelve ese numero
        return random.nextInt(maximo - minimo + 1) + minimo;
    }
}
