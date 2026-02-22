/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolos_historico;

/**
 *
 * @author MARIO
 */
public class Marcador {
    private int rondas = 0;
    private int bolosDerribados = 0;

    public int getBolosDerribados() {
        return bolosDerribados;
    }

    public int getRondas() {
        return rondas;
    }
    /**
     * Este metodo establece al marcador los bolos derribados
     * Comprueba que no sean mayor a 10
     * @param bolosDerribados 
     */
    public void setBolosDerribados(int bolosDerribados) {
        if(bolosDerribados > 0 && bolosDerribados <= Jugador.getMAX_BOLOS()){
            this.bolosDerribados += bolosDerribados;
        }
    }
    public void aumentarRonda(){
       rondas++; 
    }
    
}
