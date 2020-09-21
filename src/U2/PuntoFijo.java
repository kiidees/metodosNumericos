/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2;

import org.nfunk.jep.JEP;

/**
 *
 * @author jklm2
 */
public class PuntoFijo {
    String gX;
    float x0,xR,xRold,i=0,eP,ePa=100;

    public PuntoFijo(String gX, float x0, float eP) {
        this.gX = gX;
        this.x0 = x0;
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
            xR=evaluar(gX,x0);
            if(i!=0)
                ePa=Math.abs((xR-xRold)/xR)*100;
            x0=xR;
            xRold=xR;
            i++;
            System.out.println("El valor de xR es= "+xR+" Con i= "+i);
            System.out.println("El error porcetual es= "+ePa+"%");
            System.out.println("------------------------------------------------");
        }while(eP<ePa);
    }
}
