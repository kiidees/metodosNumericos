
package Unidad2;

/**
 *
 * @author Ramon
 */
public class PuntoFijo {
    String funcion;
    float equisCero,equisR,equisRanterior,errorPorcentual,errorPorcentualAnterior=100;
    int iteracion;
    Evaluacion.Evalua eval = new Evaluacion.Evalua();

    public PuntoFijo(String funcion, float x0, float eP) {
        this.funcion = funcion;
        this.equisCero = x0;
        this.errorPorcentual = eP;
    }
    
    public void calcular(){
        do{
            equisR=eval.evaluar(funcion,equisCero);
            if(iteracion!=0)
                errorPorcentualAnterior=Math.abs((equisR-equisRanterior)/equisR)*100;
            equisCero=equisR;
            equisRanterior=equisR;
            iteracion++;
            System.out.println("equis R= "+equisR+" Con la iteracion= "+iteracion);
            System.out.println("El error porcetual es= "+errorPorcentualAnterior+"%");
            System.out.println("0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0");
        }while(errorPorcentual<errorPorcentualAnterior);
    }
    
    public static void main(String[] args) {
        System.out.println("Con el metodo de Punto Fijo:");
        System.out.println("");
        PuntoFijo puntofijo = new PuntoFijo("((1.8*x +2.5))^(1/2)",5,0.05f);
        puntofijo.calcular();
        System.out.println("");
    }
}
