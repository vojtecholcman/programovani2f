/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce203;

/**
 *
 * @author vojtech.holcman.s
 */
public abstract class MyAbstractClass implements MyInterface {

    public static void main(String[] args) {
        MyAbstractClass myc = new MyAbstractClass() {
            @Override
            public void m1() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    @Override
    public int m2() {
        return 2;
    }

    @Override
    public int m3() {
        return 3;
    }
}
