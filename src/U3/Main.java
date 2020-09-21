package U3;

import java.util.Scanner;

/**
 *
 * @author Kyde (edyk)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReuseMethods.Matriz matA = new ReuseMethods.Matriz();
        ReuseMethods.Arreglo arrB = new ReuseMethods.Arreglo();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa la longitud de tu sistema");
        int longi = teclado.nextInt();
        matA.longitud=longi;
        arrB.setLongitud(longi);
        System.out.println("Agrega tu matriz A");
        double[][] a =matA.leerMatriz();
        System.out.println("Agrega tu matriz B");
        double[] b= arrB.leerElem();
        
        /*Gaussiana1 elimGauss1 = new Gaussiana1(a,b);
        elimGauss1.aumentada();
        ReuseMethods.Matriz showAr = new ReuseMethods.Matriz(elimGauss1.calcular());
        showAr.mostrarMatriz();
        ReuseMethods.Matriz showMat = new ReuseMethods.Matriz(elimGauss1.aumentada());
        showMat.mostrarMatriz();*/
        
        
        /*Gaussiana elimGauss = new Gaussiana(a,b);
        elimGauss.aumentada();
        
        ReuseMethods.Arreglo showAr = new ReuseMethods.Arreglo(elimGauss.calcular());
        showAr.showArreglo();
        ReuseMethods.Matriz showMat = new ReuseMethods.Matriz(elimGauss.aumentada());
        showMat.mostrarMatriz();*/
                
        /*ElimGauss eligau = new ElimGauss();
        System.out.println(Arrays.deepToString(eligau.aumentada(a, b)));
        System.out.println(Arrays.toString(eligau.eliminacionGauss(a, b)));*/
        
        GaussJorPiv gaujoPiv = new GaussJorPiv(matA.matriz,arrB.arreglo);
        ReuseMethods.Matriz showMat = new ReuseMethods.Matriz();
        //mostramos matriz aumentada
        System.out.println("La matriz aumentada A|B es:");
        showMat.mostrarMatriz(gaujoPiv.aumentada());
        gaujoPiv.calcular();
    }
    
}
