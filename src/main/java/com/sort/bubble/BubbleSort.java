/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.sort.bubble;

import java.util.Arrays;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/1/22 9:23
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
