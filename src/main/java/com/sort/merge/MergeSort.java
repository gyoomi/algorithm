/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.sort.merge;

import java.util.Arrays;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/1/22 17:43
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        mergeSortUp2Down(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortUp2Down(int[] arr, int start, int end) {
        if (null == arr || start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSortUp2Down(arr, start, mid);
        mergeSortUp2Down(arr, mid + 1, end);
        merge(arr, start, mid ,end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < k; l++) {
            arr[start + l] = temp[l];
        }
        temp = null;
    }
}
