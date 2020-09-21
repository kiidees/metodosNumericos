/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package U2;



/**
 *
 * @author Kyde (edyk)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*NOTA; la funcion debe escribirse con cada parametro separado,
        las multiplicaciones con asterisco '*' y las potencias con circunflejo '^'*/
        //Creamos el objeto sec, de tipo secante
        System.out.println("Comienza el metodo de Secante");
        //los parametros del constructor son ("funcion",xcero,xrmenosuno,error porcentual) 
        Secante sec = new Secante("sin(x) +cos((x^2 +1)) -1",2.25f,1.5f,0.01f);
        sec.calcular(); //calculamos la raiz
        //creamos el objeto newrap, de tipo NewtonRapson
        System.out.println("Comienza el metodo de Newton-Raphson");
        //los parametros del constructor son ("funcion",xcero,error porcentual)
        NewtonRaphson newrap = new NewtonRaphson("x +sin(x)",0,0.01f);
        newrap.calcular(); //calculamos la raiz
        //creamos el objeto punfi, de tipo PuntoFijo
        System.out.println("Comienza el metodo de Punto Fijo");
        //los parametros del constructor son ("funcion equivalente",xcero, error porcentual)
        PuntoFijo punfi = new PuntoFijo("((1.8*x +2.5))^(1/2)",5,0.05f);
        punfi.calcular();
    }

}
