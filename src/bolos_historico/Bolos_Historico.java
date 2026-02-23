/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bolos_historico;

/**
 *
 * @author MARIO
 */
public class Bolos_Historico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("BIENVENIDO A BOLOS EXPRESS");
        int jugarDeNuevo;

        do {
            // Inicializamos objetos
            String nombreJugador1 = Lectura.leerCadena("Nombre Jugador 1: ");
            int pr1 = Lectura.validarNumero("Precisión J1 (1-10): ", 1, 10);
            Jugador j1 = new Jugador(nombreJugador1, pr1);
            String nombreJugador2 = Lectura.leerCadena("Nombre Jugador 2: ");
            int pr2 = Lectura.validarNumero("Precisión J2 (1-10): ", 1, 10);
            Jugador j2 = new Jugador(nombreJugador2, pr2);

            int rondas = Lectura.validarNumero("¿A cuántas rondas jugamos?: ", 1, 10);

            // 2. Crear e iniciar partida
            Partida partidaActual = new Partida(j1, j2, rondas);
            gestionarPartida(partidaActual);

            // 3. Al terminar la partida, preguntar si otra
            jugarDeNuevo = Lectura.validarNumero("\n¿Deseas jugar otra partida? (1: Sí / 0: Salir): ", 0, 1);
        } while (jugarDeNuevo == 1);

        // 4. Estadísticas finales al salir del programa
        System.out.println("\n=== ESTADÍSTICAS GLOBALES ===");
        System.out.println("Total partidas jugadas: " + Partida.getPartidasTotales());
        System.out.println("Total tiradas realizadas: " + Partida.getTiradasGlobal());
        System.out.println("¡Gracias por jugar!");
    }

    private static void gestionarPartida(Partida partida) {
        int opcion;
        // Se sale cuando la condicion de isFinalizada es true
        // Es decir si las rondas actuales son iguales al maximo de rondas se sale del menu
        do {
            System.out.println("\n------ MENU PARTIDA -----");
            System.out.println("Turno de: " + partida.obtenerNombreJugador());
            System.out.println("1. Realizar Tirada");
            System.out.println("2. Ver Puntuaciones");
            System.out.println("3. Ver Tiradas Globales");
            System.out.println("4. Abandonar Partida");

            opcion = Lectura.validarNumero("Selecciona una opción: ", 1, 4);
            switch (opcion) {
                case 1 -> {
                    System.out.println("Elije tiro: 1.Normal | 2.Efecto | 3.Potente");
                    int tiroNum = Lectura.validarNumero("Selección: ", 1, 3);
                    // Convertimos el 1, 2 o 3 al valor del Enum
                    TipoTiro tipo = tipo(tiroNum);
                    
                    System.out.println("¡Has derribado " +  partida.ejecutarTirada(tipo) + " bolos!");
                }
                case 2 ->
                    partida.mostrarInformacion();
                case 3 ->
                    System.out.println("Tiradas totales en el sistema: " + Partida.getTiradasGlobal());
                case 4 ->
                    System.out.println("Has abandonado la partida.");
            }

            // Si la partida termina por rondas, salimos del menú
            if (partida.isFinalizada()) {
                System.out.println("\n¡FIN DE LA PARTIDA!");
                partida.mostrarGanadorFinal(); // Método para decir quién ganó
                break;
            }

        } while (opcion != 4);
    }

    private static TipoTiro tipo(int tipoTiro) {
        return switch (tipoTiro) {
            case 1 -> TipoTiro.NORMAL;
            case 2 -> TipoTiro.EFECTO;
            case 3 -> TipoTiro.POTENTE;
            default -> TipoTiro.NORMAL;
        };
    }
}
