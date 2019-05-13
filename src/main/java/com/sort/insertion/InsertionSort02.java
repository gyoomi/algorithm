package com.sort.insertion;

import java.util.Arrays;

/**
 * 优化思路：将多次交换复制，转换成一次赋值交换。
 *
 * @author Leon
 * @version 2019/5/12 23:17
 */
public class InsertionSort02 {

    public static void main(String[] args) throws Exception {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 寻找arr[i]在已排序数组的合理的位置。向前找
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
