/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

import java.util.Arrays;
import java.util.Random;
import static lekce205.InsertionSort.sort;

/**
 *
 * @author vojtech.holcman.s
 */
public class MergeSort {

    public static void main(String[] args) {
//        int a[] = {100, 1, 22, 3};
        int a[] = new int[100];
        Random r = new Random(0);
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(1000);
        }
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        int[] b = new int[a.length];
        sort(a, b, 0, a.length - 1);
    }

    private static void sort(int[] a, int[] b, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(a, b, left, middle);
            sort(a, b, middle + 1, right);
            merge(a, b, left, middle, right);
        }
    }

    private static void merge(int[] a, int[] b, int left, int middle, int right) {
        for (int i = left; i <= right; i++) {
            b[i] = a[i];
        }
        int i = left;
        int l = left;
        int r = middle + 1;
        while (l <= middle && r <= right) {
            if (b[l] < b[r]) {
                a[i++] = b[l++];
            } else {
                a[i++] = b[r++];
            }
        }
        while (l <= middle) {
            a[i++] = b[l++];
        }
        while (r <= right) {
            a[i++] = b[r++];
        }

    }
}
