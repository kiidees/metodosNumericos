/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package U5;

/**
 *
 * @author kyde(edyk)
 */
public class Derivadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ExpancionAdelante expAdel = new ExpancionAtras("sin(x)",2f,0.2f);
        ExpancionAdelante expAdel = new ExpancionAdelante("sin(x)",2,0.2f);
        expAdel.derivadaNormal();
        expAdel.derivadaExacta();
    }

}
