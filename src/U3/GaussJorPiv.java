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
public class GaussJorPiv {
    double [][] a,ab;
    double [] b,x;
    int f,c;
    int k;
    double factor;
    double piv;
    double q;
    ReuseMethods.Matriz showMatriz = new ReuseMethods.Matriz();

    public GaussJorPiv(double[][] a, double[] b) {
        this.a = a;
        this.b = b;
    }
    
    
    public double[][] aumentada(){
        f = a.length;
        c = b.length;
         ab = new double[f][c+1];
        if(f!=c){
            System.out.println("no es posible hacer la matriz aumentada A|B debido que"+ "las filas de A es diferente al numero de elementos deb");
        }else{
            for(int i=0;i<f;i++){
                for(int j=0;j<c+1;j++){
                    if(j==c){
                        ab[i][j] = b[i];
                    }else{
                        ab[i][j] = a[i][j];
                    }
                }
            }
        }
        return ab;
    }
    
    public void calcular(){
        for(k =0;k<f-1;k++){
            //inicio pivoteo
            int p = k;
            double big = Math.abs(ab[k][k]);
            for(int i=k+1;i<c-1;i++){
                piv = Math.abs(ab[i][k]);
                if(piv>big){
                    big=piv;
                    p=i;
                }
            }
            if (p!=k){
                for (int j=k;j<c-1;j++){
                    piv = ab[p][j];
                    ab[p][j]= ab[k][j];
                    ab[k][j]=piv;
                }
            }
            double bar = ab[p][c];
            ab[p][c]=ab[k][c];
            ab[k][c]=bar;
            System.out.println("Pivote cambiado");
            showMatriz.mostrarMatriz(ab);
            //Fin pivoteo
            factor=ab[k][k];
            
            for (int i=0;i<c;i++){
                ab[k][0]=ab[k][0]/factor;
            }
            for(int i =k+1;i<f;i++){
                for(int j=0;j<c;j++){
                    q=ab[i][j]-ab[i][k]*ab[k][j];
                }
                for(int j=0;j<f;j++){
                    //M(i,:)=q;
                    ab[j][k]=q;
                }   
            }
        }
        //factor=ab[k][k];
        factor=ab[k+1][k+1];
        for(int i=0;i<c;i++){
            //ab[k][i]=ab[k][i]/factor;
            ab[k+1][i]=ab[k+1][i]/factor;
        }
        
        for(int k=f;k<c-1;k++){
            for (int i=k-1;i<f-1;i++){
                for(int j=0;j<c;j++){
                    q=ab[i][j]-ab[i][k]*ab[k][j];
                }
                for(int j=0;j<f;j++){
                    //M(i,:)=q;
                    ab[j][k]=q;
                }
            }
        }
        System.out.println("matriz escalonada");
        showMatriz.mostrarMatriz(ab);
    }
}
