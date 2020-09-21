package U3;

/**
 *
 * @author Kyde (edyk)
 */
public class Gaussiana  {
    int i,j,k,l;
    double[][] matriz, matriz1;
    double[] arreglo;
    double[][] Ab;
    double[] x={0};

    public Gaussiana(double[][] matriz, double[] arreglo) {
        this.matriz = matriz;
        this.arreglo = arreglo;
    }
    
    public double[][] aumentada(){
        int n = matriz.length;
        int m = matriz1.length;
         Ab = new double[n][2*n];
         
         //diaonal principal con 1
        for(int i=0; i<n ; i++)
            {
                for(int j=0; j<m; j++)
                {
                    if(i==j)
                        matriz1 [i][j]=1;
                    else
                        matriz1 [i][j]=0;
                }
            }

        
            for(i=0;i<n;i++){
                for(j=0;j<n+1;j++){
                    if(j==n){
                        Ab[i][j] = matriz1[i][j];
                    }else{
                        Ab[i][j] = matriz[i][j];
                    }
                }
            }
        
        return Ab;
    }
    
    
    
    /*public double[][] calcular(){
    for(i =0;i<Ab.length-1;i++){
    for(j=0;j<Ab.length;j++){
    Ab[i][j]=Ab[i][j]/Ab[i][i];
    }
    for( j=i+1;j<Ab.length;j++){
    for(k=0;k<Ab.length;k++){
    Ab[j][k]=Ab[j][k]-(Ab[j][i]*Ab[i][k]);
    }
    }
    Ab[k+1][i]=Ab[k+1][i]/Ab[k+1][k+1];
    
    }
    //for(i=0;i<Ab.length;i++){
    //Ab[k+1][i]=Ab[k+1][i]/Ab[k+1][k+1];
    //matriz[i][j]=Ab[i][j]/matriz[i][i];
    // }
    return Ab;
    }*/
    
    public double[] calcular(){
        int n = Ab.length;
        int l = Ab[0].length;
        double m = 0;
        //double[] x={0};
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
        //for(i=0;i<Ab.length;i++){
        //Ab[k+1][i]=Ab[k+1][i]/Ab[k+1][k+1];
        //matriz[i][j]=Ab[i][j]/matriz[i][i];
        // }
        return x;
    }
}
