/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U3;

/**
 *
 * @author jklm2
 */
public class ElimGauss {
    public static double[][] A;
    public static double[] b;

    public ElimGauss() {
    }
    
    
    public static double[][] aumentada(double[][] A, double[] b){
        int n = A.length;
        int m = b.length;
        double[][] Ab = new double[n][n+1];
        //if(n!=m){
        //    System.out.println("no es posible hacer la matriz aumentada A|b debido que"+ "las filas de A es diferente al numero de elementos deb");
        //}else{
            for(int i=0;i<n;i++){
                for(int j=0;j<n+1;j++){
                    if(j==n){
                        Ab[i][j] = b[i];
                    }else{
                        Ab[i][j] = A[i][j];
                    }
                }
            }
        //}
        return Ab;
    }
    
    public double[] eliminacionGauss(double[][] A, double[] b){
        int n = A.length;
        int l = A[0].length;
        double[] x={0};
        if(n!=l){
            System.out.println("A no es una matriz cuadrada.");
        }else{
            double[][] Ab = aumentada(A,b);
            double m = 0;
            for(int k=0;k<n-1;k++){
                for(int i=k+1;i<n;i++){
                    m = Ab[i][k] / Ab[k][k];
                    for(int j=k;j<n+1;j++){
                        Ab[i][j] = (double) Ab[i][j] - m*Ab[k][j];
                    }
                }
            }
            double suma;
            x = new double[n];
            for(int i=n-1;i>=0;i--){
                suma=0;
                for(int j=i+1;j<n;j++){
                    suma = suma + Ab[i][j]*x[j];
                }
                 x[i] = (Ab[i][n] - suma)/Ab[i][i];
            }
        }
        return x;
    }
    
}
