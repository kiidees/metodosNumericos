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
public class NewtonRaphson {
    String fX, fPrimX;
    float x0,xR,xRold,eP,ePa=100;
    int i=0;


    public NewtonRaphson(String fX, float x0, float eP) {
        this.fX = fX;
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
    
    public String deriva(String fX){
        Deriva d1 = new Deriva();
        return d1.derivar(fX,"x");
    }
    
    public void calcular(){
        do{
            xR=x0-(evaluar(fX,x0)/evaluar(deriva(fX),x0));
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
