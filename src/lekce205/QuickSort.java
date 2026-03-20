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
public class QuickSort {

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
        sort(data, 0, data.length);
    }

    private static void sort(double data[], int left, int right) {
        if (right - left < 1) {
            return;
        }
        if (right - left == 2) {
            if (data[left] > data[right - 1]) {
                double tmp = data[left];
                data[left] = data[right - 1];
                data[right - 1] = tmp;
            }
            return;
        }
        double pivot = data[(left + right) / 2];

        int i = left;
        int j = right - 1;

        while (i <= j) {
            while (data[i] < pivot) {
                i++;
            }

            while (data[j] > pivot) {
                j--;
            }

            if (i <= j) {
                double tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;

                i++;
                j--;
            }
        }

        sort(data, left, j + 1);
        sort(data, i, right);
    }
}

