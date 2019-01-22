/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.sort.selection;

import java.util.Arrays;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/1/22 10:29
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
