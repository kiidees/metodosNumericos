/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluacion;

import org.nfunk.jep.JEP;

/**
 *
 * @author Ramon
 */
public class Evalua {
    
    public float evaluar(String fX, float var){
        float eval;
        JEP jepEval = new JEP();
        jepEval.addStandardConstants();
        jepEval.addStandardFunctions();
        jepEval.setImplicitMul(true);
        jepEval.addVariable("x", var);  
        jepEval.parseExpression(fX);
        //Si existiese algun error.
        if(jepEval.hasError()){
             System.out.println(jepEval.getErrorInfo()); 
        }
        eval=(float) jepEval.getValue();
        return eval;
    }
    
}
