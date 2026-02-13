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
        System.out.println(gcd(36, 48));
        System.out.println(coprimes(10));
    }

    public static String toBase(long n, int base) {
        StringBuilder sb = new StringBuilder();
        //pouze pro kladna n

        while (n != 0) {
            long fraction = n % base;
            // 0-9 -> '0' - '9'
            // 10-... -> 'A'-...
            char c = fraction <= 9 ? '0' : 'A' - 10;
            c += fraction;
            sb.insert(0, c);
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

    public static long gcd(long a, long b) {
        long a1 = a;
        long b1 = b;
        while (b1 != 0) {
            long r = a1 % b1;
            a1 = b1;
            b1 = r;
        }
        return a1;
    }

    public static void coprimes(int max) {
        for (int a = 1; a < max; a++) {
            for (int b = a + 1; b < max; b++) {
                if (gcd(a, b) == 1) {
                    System.out.println(a + " , " + b);
                }
            }
        }
    }

}
