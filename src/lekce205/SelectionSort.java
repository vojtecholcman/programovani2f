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
public class SelectionSort {

        public static void main(String[] args) {
//        int a[] = {100, 1, 22, 3};
        double a[] = new double[100];
        Random r = new Random(0);
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(1000);
        }
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    
    public static void sort(double data[]) {
        
        for (int i = 0; i < data.length - 1; i++) {
            /* najdeme minimum */
            int mi = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[mi]) {
                    mi = j;
                }
            }
            /* vyměníme data[i] a data[mi] */
            double tmp = data[i];
            data[i] = data[mi];
            data[mi] = tmp;
        }
    }
}
