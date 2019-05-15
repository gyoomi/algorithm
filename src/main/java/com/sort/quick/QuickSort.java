/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.sort.quick;

import java.util.Arrays;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/1/23 9:19
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p);
        sort(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];

        // arr[l+1,...j]  arr[j]   arr[j+1,...i)
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}



















