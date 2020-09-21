/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package U5;

/**
 *
 * @author kyde(edyk)
 */
public class ExpancionAdelante extends Evaluar{
    String fX; float x, h, fXi,fXi1,fXi2,fXi3,fXi4,fXi5;

    public ExpancionAdelante(String fX, float x, float h) {
        this.fX = fX;
        this.x = x;
        this.h = h;
    }

    public void evaluaciones(){
        fXi=evaluar(fX,x);
        fXi1=evaluar(fX,(x+h));
        fXi2=evaluar(fX,(x+2*h));
        fXi3=evaluar(fX,(x+3*h));
        fXi4=evaluar(fX,(x+4*h));
        fXi5=evaluar(fX,(x+5*h));
    } 
    
    public void derivadaNormal(){
        evaluaciones();    
        System.out.println("fXi= "+fXi);
        System.out.println("fXi1= "+fXi1);
        System.out.println("fXi2= "+fXi2);
        System.out.println("fXi3= "+fXi3);
        System.out.println("fXi4= "+fXi4);
        System.out.println("fXi5= "+fXi5);
        System.out.println("dX= "+(fXi1-fXi)/(h));
        System.out.println("ddX= "+(fXi2-2*fXi1+fXi)/(h*h));
        System.out.println("dddX= "+(fXi3-3*fXi2+3*fXi1-fXi)/(h*h*h));
        System.out.println("ddddX= "+(fXi4-4*fXi3+6*fXi2-4*fXi1+fXi)/(h*h*h*h));
    }
    
    public void derivadaExacta(){
        System.out.println("exacta dX= "+(-fXi2+4*fXi1-3*fXi)/(2*h));
        System.out.println("exacta ddX= "+(-fXi3+4*fXi2-5*fXi1+2*fXi)/(h*h));
        System.out.println("exacta dddX= "+(-3*fXi4+14*fXi3-24*fXi2+18*fXi1-5*fXi)/(2*(h*h*h)));
        System.out.println("exacta dddX= "+(-2*fXi5+11*fXi4-24*fXi3+26*fXi2-14*fXi1+3*fXi)/(h*h*h*h));
    }
}
