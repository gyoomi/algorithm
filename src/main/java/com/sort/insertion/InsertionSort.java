/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.sort.insertion;

import java.util.Arrays;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/1/22 10:54
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        for (int i = 1; i < arr.length; i++) {
            // Waiting to insert
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        // InsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void InsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }
}
