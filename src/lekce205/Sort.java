/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

import java.util.Arrays;

/**
 *
 * @author vojta
 */
public class Sort {

    public static double[] bubbleSort(double[] data, boolean ascending) {
        for (int i = 0; i < data.length - 1; i++) {
            boolean moved = false;

            for (int j = 0; j < data.length - 1 - i; j++) {
                if ((ascending && data[j] > data[j + 1])
                        || (!ascending && data[j] < data[j + 1])) {

                    double temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    moved = true;
                }
            }
            if (!moved) {
                break;
            }
        }


        return data;
    }

    public static double[] selectionSort(double[] data, boolean ascending) {
        if (data == null || data.length < 2) {
            return data;
        }

        for (int i = 0; i < data.length - 1; i++) {
            int selectedIndex = i;

            for (int j = i + 1; j < data.length; j++) {
                if ((ascending && data[j] < data[selectedIndex])
                        || (!ascending && data[j] > data[selectedIndex])) {
                    selectedIndex = j;
                }
            }

            double temp = data[i];
            data[i] = data[selectedIndex];
            data[selectedIndex] = temp;
        }

        return data;
    }

    public static double[] quickSort(double[] data, boolean ascending) {
        if (data == null || data.length < 2) {
            return data;
        }

        quickSortRecursive(data, 0, data.length - 1, ascending);
        return data;
    }

    private static void quickSortRecursive(double[] data, int left, int right, boolean ascending) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(data, left, right, ascending);
        quickSortRecursive(data, left, pivotIndex - 1, ascending);
        quickSortRecursive(data, pivotIndex + 1, right, ascending);
    }

    private static int partition(double[] data, int left, int right, boolean ascending) {
        double pivot = data[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if ((ascending && data[j] <= pivot)
                    || (!ascending && data[j] >= pivot)) {
                i++;
                double temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        double temp = data[i + 1];
        data[i + 1] = data[right];
        data[right] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        double[] arr1 = {5.4, 2.1, 9.8, 1.0, 3.3};
        double[] arr2 = {5.4, 2.1, 9.8, 1.0, 3.3};
        double[] arr3 = {5.4, 2.1, 9.8, 1.0, 3.3};

        System.out.println("Bubble sort:    " + Arrays.toString(bubbleSort(arr1, true)));
        System.out.println("Selection sort: " + Arrays.toString(selectionSort(arr2, true)));
        System.out.println("Quick sort:     " + Arrays.toString(quickSort(arr3, true)));
    }
}
}
