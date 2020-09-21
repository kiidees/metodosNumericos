/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2;


import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author jklm2
 */
public class Deriva {
    String respec;
    String fun;

    public String getRespec() {
        return respec;
    }

    public void setRespec(String respec) {
        this.respec = respec;
    }
    
    
    
    public String derivar(String funcion, String respect)
    {
        String derivada="";
        //respect=getRespec();
        DJep derivar = new DJep();
        derivar.addStandardFunctions();
        derivar.addStandardConstants();
        derivar.addComplex();
        derivar.setAllowUndeclared(true);
        derivar.setAllowAssignment(true);
        derivar.setImplicitMul(true);
        derivar.addStandardDiffRules();
        try
        {
            Node nodo = derivar.parse(funcion);
            Node diff = derivar.differentiate(nodo,respect);
            Node sim = derivar.simplify(diff);
            derivada=derivar.toString(sim);
        }catch (ParseException e){e.printStackTrace();}
        return derivada;
    }
    
}
