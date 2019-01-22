/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.sort.merge;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/1/22 17:43
 */
public class MergeSort {

    public static void main(String[] args) {

    }

    public static void mergeSortUp2Down(int[] arr, int start, int end) {
        if (null == arr || start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSortUp2Down(arr, start, mid);
        mergeSortUp2Down(arr, mid, end);

    }

    public static void merge(int[] arr, int start, int mid, int end) {

    }
}
