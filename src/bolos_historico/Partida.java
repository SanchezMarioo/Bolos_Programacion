/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolos_historico;

/**
 *
 * @author MARIO
 */
public class Partida {

    private Jugador j1;
    private Jugador j2;
    private Marcador marcadorJ1; // Composición: La partida TIENE un marcador
    private Marcador marcadorJ2;
    private int rondaActual;
    private int rondasTporPartida = 0;
    static private int rondasGlobal;
    private int tiradaEnRonda = 0;
    static private int partidasTotales = 0;
    /**
     * Constructor que pide pasa los objetos de jugador1,jugador2, y el numero de rondas
     * @param j1
     * @param j2
     * @param rondas 
     */
    public Partida(Jugador j1, Jugador j2, int rondas) {
        this.j1 = j1;
        this.j2 = j2;
        this.marcadorJ1 = new Marcador();
        this.marcadorJ2 = new Marcador();
        this.rondaActual = 0;
        this.rondasTporPartida = rondas;
        partidasTotales++;
    }
    /**
     * Depende "tiradaEnRonda" que es para sacar el 
     * @return 
     */
    public String obtenerNombreJugador() {
        if (tiradaEnRonda < 2) {
            return j1.getNombre();
        } else {
            return j2.getNombre();
        }
    }
    
    /**
     * 
     * @param tiro 
     */
    public int ejecutarTirada(TipoTiro tiro) {
        int bolos = -1;
        if (tiradaEnRonda < 2) {
            bolos = j1.bolosDerribados(tiro);
            marcadorJ1.setBolosDerribados(bolos);
            marcadorJ1.aumentarRonda();
        } else {
            bolos = j2.bolosDerribados(tiro);
            marcadorJ2.setBolosDerribados(bolos);
            marcadorJ2.aumentarRonda();
            
        }
        tiradaEnRonda++;
        // Se restablece
        if(tiradaEnRonda > 3){
            tiradaEnRonda = 0;
            rondaActual++;
            rondasGlobal++;
        }
        return bolos;
    }

    static public int getPartidasTotales() {
        return partidasTotales;
    }

    public int getRondaActual() {
        return rondaActual;
    }
    

    public static int getRondasGlobal() {
        return rondasGlobal;
    }
    public boolean isFinalizada(){
        if(rondaActual == rondasTporPartida){
            return true;
        } else{
            return false;
        }
    }
    
    public void mostrarGanadorFinal(){
        System.out.println("========= RESULTADO FINAL ========");
        System.out.println(j1.getNombre() + " -> " + marcadorJ1.getBolosDerribados() + " puntos");
        System.out.println(j2.getNombre() + " -> " + marcadorJ2.getBolosDerribados() + " puntos");
    }
    public void mostrarInformacion(){
        System.out.println("====== ESTADO PARTIDA ====");
        System.out.println("Ronda: " + rondaActual + "/" + rondasTporPartida);
        System.out.println("Tiradas: " + (j1.getTiradas() + j2.getTiradas()));
        System.out.println(j1.getNombre() + " -> " + marcadorJ1.getBolosDerribados() + " puntos" + " | " + "Tiradas: " + j1.getTiradas());
        System.out.println(j2.getNombre() + " -> " + marcadorJ2.getBolosDerribados() + " puntos" + " | " + "Tiradas: " + j2.getTiradas());
        System.out.println("Terminada: " + (isFinalizada() ? "si" : "no"));
    }
    
}
