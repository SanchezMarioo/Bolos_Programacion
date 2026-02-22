/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package bolos_historico;

/**
 *
 * @author MARIO
 */
public enum TipoTiro {
    // =============================================
    // VALORES DEL ENUM
    // =============================================
    // Cada valor llama al constructor con su identificador numérico.
    // NORMAL(1) equivale internamente a: new TipoTiro(1)
    
    NORMAL(1),      // Tiro estándar: probabilidad normal
    EFECTO(2),      // Tiro con efecto: más difícil pero efectivo
    POTENTE(3);     // Tiro potente: máxima fuerza
    // OJO: punto y coma después del último valor, NO coma

    // =============================================
    // ATRIBUTO
    // =============================================
    // Cada valor del enum almacena su número identificador aquí.
    // NO es static porque cada valor tiene su propio número.
    
    private final int numero;

    TipoTiro(int numero) {
        this.numero = numero;
    }

    
    public int getNumero() {
        return numero;
    }
}
