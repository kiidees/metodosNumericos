/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U3;
import java.util.*;

import java.lang.reflect.Array;
import java.lang.*;

import java.util.Arrays;
public class InversaGaussPivot
{
    static void muestramatriz(float matriz[][], int var)
    {
        for(int x=0;x<var;x++)
        {
            for(int y=0;y<(var*2);y++)
                System.out.print(" "+matriz[x][y]+" |");
            System.out.println("");
        }
        
    }
    static void pivote(float matriz[][],int piv,int var)
    {
        float temp=0;
        temp=matriz[piv][piv];
        for(int y=0;y<(var);y++)
        {
            
            matriz[piv][y]=matriz[piv][y]/temp;
        }
    }
    static void hacerceros(float matriz[][],int piv,int var)
    {
        for(int x=0;x<var;x++)
        {
            if(x!=piv)
            {
                float c=matriz[x][piv];
                for(int z=0;z<(var);z++)
                    matriz[x][z]=((-1*c)*matriz[piv][z])+matriz[x][z];
            }
        }
    }
    static float [][] matIdentidad(int var){
        float[][] matriz1;
        matriz1 = new float[var][var];
        for(int i=0; i<var ; i++)
            {
                for(int j=0; j<var; j++)
                {
                    if(i==j)
                        matriz1 [i][j]=1;
                    else
                        matriz1 [i][j]=0;
                }
            }
        return matriz1;
    }
    
    private static float[][] aumentada(float[][] mat1, float[][] mat2, int var) {
        
		float[][] matMerged = new float[var][2*var];
                //float[][] matMerged = (float[][])ArrayUtils.addAll(mat1, mat2);
                /*for(int i=0;i<matMerged.length;i++){
                int j=0;
                if(j<mat1.length){
                matMerged=
                }
                }
                */
                
                
                /*
                for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(j==n){
                        Ab[i][j] = arreglo[i];
                    }else{
                        Ab[i][j] = matriz[i][j];
                    }
                }
            } */
                
                /*Random rand = new Random();
                for (int i=0; i<var; i++){
                for (int j=0; j<2*var; j++){
                matMerged[i][j] = rand.nextInt((100+1));
                }
                }*/
        
                int i=0,j=0,k=0,l=0;
                for(int x=0;x<var;x++)
                {
                    for(int y=0;y<(2*var);y++)
                    {
                        if(y<var){
                            matMerged[x][y]=mat1[x][y];
                        }else if(y>var){
                            matMerged[x][y]=mat2[x][i++];
                            //i++;
                        }
                        
                    }
                }
                
                
		return matMerged;
 
	}
    
    public static void main(String args[])
    {
        Scanner leer=new Scanner(System.in);
        int var=0, piv=0;
        float matriz[][];
        //float matAumentada[][];
        
        System.out.println("\t ** Este programa nos muestra la solución de un sistema de ecuaciones \n\t\tlineales a través del método inversa con pivoteo **");
        System.out.println("\n¿Cuantas variables tiene tu sistema?");
        var=leer.nextInt();
        matriz=new float[var][var];
        //float [][] matAumentada = aumentada(matriz,matIdentidad(var),var);
        for(int x=0;x<var;x++)
        {
            for(int y=0;y<(var);y++)
            {
                System.out.println("Ingresa la constante de la posicion: A["+(x+1)+"]["+(y+1)+"]");
                matriz[x][y]=leer.nextFloat();
            }
        }
        //matAumentada = new float[var][var*2];
        
        //matAumentada = aumentada(matriz,matIdentidad(var),var);
        //float [][] matAumentada = aumentada(matriz,matriz,var);
        float [][] matAumentada = aumentada(matriz,matIdentidad(var),var);
        //for(int a=0;a<var;a++)
        //{
            
            //pivote(matAumentada,piv,var);
            
            //System.out.println("\tRenglon "+(a+1)+" entre el pivote");
            System.out.println(matAumentada.length+" "+matAumentada[0].length);
            muestramatriz(matAumentada,var);
            //muestramatriz(matriz,var);
            
            //System.out.println("");
            
            //System.out.println("\tHaciendo ceros");
            //hacerceros(matAumentada,piv,var);
            
            //muestramatriz(matAumentada,var);
            //System.out.println("");
            //piv++;
        //}
        //for(int x=0;x<var;x++)
        //    System.out.println("La variable X"+(x+1)+" es: "+matriz[x][var]);
        
    }
    
}