package Unidad2;

import Deriva.Deriva;

public class NewtonRaphson {
    String funcion;
    float equisCero,equisR,equisAnterior,errorPorcentualIngresado,errorPorcentualAnterior=100;
    int iteracion=0;
    Evaluacion.Evalua eval = new Evaluacion.Evalua();

    public NewtonRaphson(String fX, float x0, float eP) {
        this.funcion = fX;
        this.equisCero = x0;
        this.errorPorcentualIngresado = eP;
    }
    
    public String deriva(String fX){
        Deriva dervar = new Deriva();
        return dervar.derivar(fX,"x");
    }
    
    public void calcular(){
        do{
            equisR=equisCero-(eval.evaluar(funcion,equisCero)/eval.evaluar(deriva(funcion),equisCero));
            if(iteracion!=0)
                errorPorcentualAnterior=Math.abs((equisR-equisAnterior)/equisR)*100;
            equisCero=equisR;
            equisAnterior=equisR;
            iteracion++;
            System.out.println("equis= "+equisR+" Con la iteracion= "+iteracion);
            System.out.println("El error porcetual es= "+errorPorcentualAnterior+"%");
            System.out.println("0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0");
        }while(errorPorcentualIngresado<errorPorcentualAnterior);
    }
    
    public static void main(String[] args) {
        System.out.println("Con el metodo de Newton Raphson:");
        System.out.println("");
        NewtonRaphson newton = new NewtonRaphson("2x^3 -11.7x^2 +17.7x -5",3f,13f);
        newton.calcular();
        System.out.println("");
    }
}
