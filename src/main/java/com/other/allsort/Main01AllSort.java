package com.other.allsort;

import java.util.Arrays;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/4/27 23:13
 */
public class Main01AllSort {

    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3};
        allSort(arr, 0);
    }

    private static void allSort(int[] source, int level) {
        if (level == source.length) {
            System.out.println(Arrays.toString(source));
        } else {
            for (int i = level; i < source.length; i++) {
                swap(source, i, level);
                allSort(source, level + 1);
                swap(source, i, level);
            }
        }
    }

    private static void swap(int[] source, int a, int b) {
        int temp = source[a];
        source[a] = source[b];
        source[b] = temp;
    }
}
