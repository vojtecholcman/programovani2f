/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce202;

/**
 *
 * @author vojtech.holcman.s
 */
public class Triangle {
    public static void main(String[] args) {
        try{
            Triangle t = new Triangle(3, 4);
            System.out.println(t.getC());
            
            t.setA(-3);
            System.out.println(t.getC());
        } catch(NonPositiveNumberException ex){
            System.out.println(ex);
        }
    }
    
    private static double checkValue(double x, String name){
        if(x <= 0){
            throw new NonPositiveNumberException(x, name);
        }
        return x;
    }
    private double a,b,c;
    
    public Triangle(double a, double b) {
        setA(a);
        setB(b);
        setC();
    }
    
    public final void setA(double a) {
        this.a = checkValue(a, "a");
        setC();
    }

    public final void setB(double b) {
        this.b = checkValue(b, "b");
        setC();
    }
    
    private void setC(){
        this.c = Math.hypot(a, b);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }  
}