/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.selectionsort;

import java.util.Arrays;

/**
 * 思路同上
 *
 * @author Leon
 * @version 2019/5/5 14:08
 */
public class Main02 {

    public static void main(String[] args) throws Exception {
        int[] arr = {11, -11, 0, 8, -98, 9, 129, -1};
        for (int i = 0; i < arr.length - 1; i++) {
            int minInx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minInx] > arr[j]) {
                    minInx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minInx];
            arr[minInx] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
