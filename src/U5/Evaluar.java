/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package U5;

import org.nfunk.jep.JEP;


/**
 *
 * @author kyde(edyk)
 */
public class Evaluar {
    
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

}
