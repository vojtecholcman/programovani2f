/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.print.Collation;
import static lekce205.MergeSort.sort;

/**
 *
 * @author vojtech.holcman.s
 */
public class CustomSort {

    public static void main(String[] args) {
        int a[] = new int[100];
        Random r = new Random(0);
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(1000);
        }
        List<Integer> l = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            l.add(a[i]);
        }
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
        Collections.sort(l);
        System.out.println(l.toString());
    }
}
