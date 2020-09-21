/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2;

import org.nfunk.jep.JEP;

/**
 *
 * @author Kyde (edyk)
 */
public class Secante {
    String fX;
    float xR,xRold,xImenos,eP,ePa=100;
    int i=0;

    public Secante(String fX, float xRold, float xImenos, float eP) {
        this.fX = fX;
        this.xRold = xRold;
        this.xImenos = xImenos;
        this.eP = eP;
    }
    
    public float evaluar(String fX, float var){
        float eval;
        JEP j = new JEP();
        j.addStandardConstants();
        j.addStandardFunctions();
        j.addVariable("x", var); //("variable", numero a evaluar) 
        j.parseExpression(fX);
         
        //Si existiese algun error.
        if(j.hasError()){
             System.out.println(j.getErrorInfo()); // Imprimir error.
        }
        eval=(float) j.getValue();
        return eval;
    }
    
    public void calcular(){
        do{
            xR=xRold-((evaluar(fX,xRold)*(xImenos-xRold))/(evaluar(fX,xImenos)-(evaluar(fX,xRold))));
            if(i!=0)
                ePa=Math.abs((xR-xRold)/xR)*100;
            xImenos=xRold;
            xRold=xR;
            i++;
            System.out.println("El valor de xR es= "+xR+" Con i= "+i);
            System.out.println("El error porcetual es= "+ePa+"%");
            System.out.println("------------------------------------------------");
        }while(eP<ePa);
    }
}
