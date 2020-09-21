package U3;

/**
 *
 * @author Kyde (edyk)
 */
public class Gaussiana1  {
    //int i,j,k,l;
    double[][] matriz;
    double[] arreglo;
    double[][] Ab;
    double[] x={0};

    public Gaussiana1(double[][] matriz, double[] arreglo) {
        this.matriz = matriz;
        this.arreglo = arreglo;
    }
    
    public double[][] aumentada(){
        int n = matriz.length;
        int m = arreglo.length;
         Ab = new double[n][n+1];
        if(n!=m){
            System.out.println("no es posible hacer la matriz aumentada A|b debido que"+ "las filas de A es diferente al numero de elementos deb");
        }else{
            for(int i=0;i<n;i++){
                for(int j=0;j<n+1;j++){
                    if(j==n){
                        Ab[i][j] = arreglo[i];
                    }else{
                        Ab[i][j] = matriz[i][j];
                    }
                }
            }
        }
        return Ab;
    }
    
    
    
    public double[][] calcular(){
        for(int i =0;i<Ab.length-1;i++){ //recorre la fila hasta fila - 1 
            for(int j=0;j<Ab.length;j++){ // recorre todas las columnas 
                Ab[i][j]=Ab[i][j]/Ab[i][i]; //divide cada fila entre el pivote correspondiente
            }
            for(int k=i+1;k<Ab.length;k++){ //recorre la segunda fila hasta la ultima
                for(int l=0;l<Ab.length;l++){ // recorre todas las columnas 
                    Ab[k][l]=Ab[k][l]-(Ab[k][i]*Ab[i][l]); //op de renglon ab(i,j)
                }
            }
            Ab[Ab.length][i]=Ab[Ab.length][i]/Ab[Ab.length][Ab.length];
            
        }
        //for(i=0;i<Ab.length;i++){
        //Ab[k+1][i]=Ab[k+1][i]/Ab[k+1][k+1];
        //matriz[i][j]=Ab[i][j]/matriz[i][i];
        // }
        return Ab;
    }
    
   /* public double[] calcular(){
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
    }*/
}
