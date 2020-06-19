/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Unidad1;

import Evaluacion.Evalua;


/**
 *
 * @author Ramon
 */
public class FalsaPosicion {
    float equisR, a, b, errorPorcentual, equisRanterior, errorPorcentualActual, funcionEvA, funcionEvB, funcionEvEquisR, iteracion;
    String fX;
    Evalua eval = new Evalua();

    public FalsaPosicion(float a, float b, float eP, String fX) {
        this.a = a;
        this.b = b;
        this.errorPorcentual = eP;
        this.fX = fX;
    }


    public void calcular(){
        funcionEvA=eval.evaluar(fX,a);
        funcionEvB=eval.evaluar(fX,b); 
        System.out.println("El Valor de f(a) "+funcionEvA);
        System.out.println("El Valor de f(b) "+funcionEvB);
        System.out.println("---------------------------------------------------------");
        if(funcionEvA*funcionEvB>0){
            System.out.println("El intervalo no es correcto");
        }
        else{
            do{
                equisR=b-(funcionEvB*(a-b)/(funcionEvA-funcionEvB)); //formula para determinar la raiz
                errorPorcentualActual=Math.abs((equisR-equisRanterior)/equisR)*100; // calculamos el error porcentual
                iteracion++;
                System.out.println("El numero de iteracion final es: "+iteracion);
                funcionEvEquisR=eval.evaluar(fX,equisR); //evalua la funcion con el valor que le otorguemos en equisR
                if((funcionEvA*funcionEvEquisR)>0){
                    equisRanterior=equisR;
                    a=equisR;
                    System.out.println("El Valor de f("+a+") "+eval.evaluar(fX,a));
                    System.out.println("El Valor de f("+b+") "+eval.evaluar(fX,b));
                }
                else{
                    equisRanterior=equisR;
                    b=equisR;
                    System.out.println("El Valor de f("+a+") "+eval.evaluar(fX,a));
                    System.out.println("El Valor de f("+b+") "+eval.evaluar(fX,b));
                }
                //imprimimos el valor de la raiz y el error
                System.out.println("el valor calculado de x es: "+equisR);
                System.out.println("el error es: "+errorPorcentualActual+"%");
                System.out.println("---------------------------------------------------------");
            } while(errorPorcentual<errorPorcentualActual);
        }
    }
    
    public static void main(String[] args) {
        Biseccion bise = new Biseccion(-1.0001f,1f, 0.000001f, "x + e^x");
        bise.calcular();
        FalsaPosicion falpos = new FalsaPosicion(-1f,1f, 0.000001f, "x + e^x");
        falpos.calcular();
    }
}
