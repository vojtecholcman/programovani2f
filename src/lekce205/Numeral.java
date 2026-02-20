/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

import java.util.Arrays;

/**
 *
 * @author vojtech.holcman.s
 */
public class Numeral {

    public static void main(String[] args) {
//        System.out.println(toBase(28, 16));
//        System.out.println(Horner(3, new double[]{1, 2, 5}));
//        System.out.println(gcd(36, 48));
//        coprimes(10);
//        System.out.println(Arrays.toString(arithmeticSequence(1, 2, 10)));
//        System.out.println(Arrays.toString(geometricSequence(1, 2, 10)));
//        System.out.println(Arrays.toString(geometricSequence(1, 1.5, 10)));
//        System.out.println(Arrays.toString(factorialSequence(20)));
        printPascalsTriangle(6);

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

    public static double[] arithmeticSequence(double first, double difference, int size) {
        double[] sequence = new double[size];

        for (int i = 0; i < size; i++) {
            sequence[i] = first + i * difference;
        }

        return sequence;
    }

    public static double[] geometricSequence(double first, double ratio, int size) {
        double[] sequence = new double[size];

        for (int i = 0; i < size; i++) {
            sequence[i] = first * Math.pow(ratio, i);
        }

        return sequence;
    }

    public static long[] factorialSequence(int size) {
        long[] sequence = new long[size];

        long current = 1;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                sequence[i] = 1;
            } else {
                current *= i;
                sequence[i] = current;
            }
        }

        return sequence;
    }

    public static void printPascalsTriangle(int height) {
        for (int n = 0; n < height; n++) {
            long value = 1;

            for (int k = 0; k <= n; k++) {
                System.out.print(value);
                if (k < n) {
                    System.out.print(" ");
                }

                value = value * (n - k) / (k + 1);
            }
            System.out.println();
        }
    }
}
