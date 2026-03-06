/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author vojtech.holcman.s
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int a[] = {100, 1, 22, 3};
        int a[] = new int[100];
        Random r = new Random(0);
        for (int i = 0; i < a.length; i++) {
            r.nextInt(1000);
        }
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        boolean sorted = false;
        int last = a.length - 1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < last; i++) {
                if (a[i] > a[i + 1]) {
                    sorted = false;
                    int b = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = b;
                }
            }
            last--;
        }
    }
}
