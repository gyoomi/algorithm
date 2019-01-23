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
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int x = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

}
