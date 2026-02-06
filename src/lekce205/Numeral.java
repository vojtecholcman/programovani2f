/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

/**
 *
 * @author vojtech.holcman.s
 */
public class Numeral {

    public static void main(String[] args) {
        System.out.println(toBase(28, 16));
        System.out.println(Horner(3, new double[]{1, 2, 5}));
    }

    public static String toBase(long n, int base) {
        StringBuilder sb = new StringBuilder();
        //pouze pro kladna n

        while (n != 0) {
            long fraction = n % base;
            // 0-9 -> '0' - '9'
            // 10-... -> 'A'-...
            char c = fraction <= 9 ? '0' : 'A' - 10;
            c+=fraction;
            sb.insert(0,c);
//            sb.insert(0, (char) ('0' + (n % base)));
            n /= base;
        }
        return sb.toString();
    }

    //double x, double[] a, NEFUNGUJE
    public static double Horner(double x, double[] a) {
        double c = a[0];

        for (int i = 1; i < a.length; i++) {
            c = c * x + a[i];
        }

        return c;
    }

}
