/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.sort.shell;

import java.util.Arrays;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/1/22 13:49
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        // 1. int gap = arr.length / 3;
        // ~~
        // 2.
        int gap = 1;
        while (gap < arr.length / 3) {
            gap = gap * 3  + 1;
        }
        while (gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap = gap/3;
        }
    }
}
