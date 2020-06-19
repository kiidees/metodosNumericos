package Unidad2;

/**
 *
 * @author Ramon
 */
public class Secante {
    String funcion;
    float equisR,equisRanterior,equisImenos,errorPorcentualIngresado,errorPorcentualAnterior=100;
    int iteracion=0;
    Evaluacion.Evalua eval = new Evaluacion.Evalua();

    public Secante(String fX, float xRold, float xImenos, float eP) {
        this.funcion = fX;
        this.equisRanterior = xRold;
        this.equisImenos = xImenos;
        this.errorPorcentualIngresado = eP;
    }

    public void calcular(){
        do{
            equisR=equisRanterior-((eval.evaluar(funcion,equisRanterior)*(equisImenos-equisRanterior))/(eval.evaluar(funcion,equisImenos)-(eval.evaluar(funcion,equisRanterior))));
            if(iteracion!=0)
                errorPorcentualAnterior=Math.abs((equisR-equisRanterior)/equisR)*100;
            equisImenos=equisRanterior;
            equisRanterior=equisR;
            iteracion++;
            System.out.println("el valor de equis= "+equisR+" Con la iteracion= "+iteracion);
            System.out.println("El error porcetual = "+errorPorcentualAnterior+"%");
            System.out.println("0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0");
        }while(errorPorcentualIngresado<errorPorcentualAnterior);
    }
    
    
    public static void main(String[] args) {
        System.out.println("Con el metodo de la secante: ");
        System.out.println("");
        Secante secante = new Secante("cos(x) -x^3",0.5f,0.3f,0.1f);
        secante.calcular();
        System.out.println("");
    }
}
