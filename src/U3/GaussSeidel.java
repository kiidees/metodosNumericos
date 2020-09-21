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

public class GaussSeidel {
    
    public void gaussSeidel(double[][] A, double [] b, double tol, int iter, double[] x0, int n)
    {
        double[] x = new double[n];
        double aux;
        int cont = 0;
        double error = tol+1;
        
        System.out.println("x1" + "\t" + "x2" + "\t" + "x3" + "\t" + "error");
        while(error > tol && cont < iter)
        {

            error = 0;
                	
            for(int i = 0; i < n; i++)
            {
                System.out.println(x[i]);
                System.out.println();
                double suma = 0;
                
                for (int j = 0; j < n; j++)
                {
                    if (i != j)
                    {
                        suma += A[i][j]*x0[j];
                    }
                }

                x[i] = (b[i] - suma)/A[i][i];
                aux = x[i]-x0[i];
                error += Math.pow(aux,2);
                x0[i] = x[i];
                
            }
            error = Math.sqrt(error);
            cont++;
            System.out.println("El numero de iteracion es: "+cont);
        }
        
        if(error < tol)
        {
            System.out.println("La solucion aproxima del sistema es:" + "\n");
            for(int i = 0; i < n; i++)
            {
                System.out.println(x[i]);
            }
        }else{
                
            System.out.println("Fracaso en esas iteraciones" + "\t" + cont);
                
        }   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double [][] matriz = {{4,1,1},{2,8,-3},{3,2,9}};
        double [] b = {1,0,-3};
        double [] xIni = {0,0,0};
        
        GaussSeidel seidel = new GaussSeidel();
        seidel.gaussSeidel(matriz, b, 0.001, 50, xIni, 3);

    }
    
}
