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
public class MergeSort02Optimize {

    /**
     *
     * Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
     * 可以在1秒之内轻松处理100万数量级的数据
     * 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
     * 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用归并排序,对arr[l...r]的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(int[] arr, int l, int r) {
        // 优化2: 对于小规模数组, 使用插入排序
        if (15 >= r - l) {
            // InsertionSort.sort(arr, l, r);
            return;
        }
        // 隐藏bug：待优化
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[l] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        // 拷贝一个同样的数组出来，用于数据处理
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        // 初始化，i指向左半部分的起始索引位置l；
        //        j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            // 如果左半部分元素已经全部处理完毕
            if (i > mid) {
                arr[k] = aux[j - l]; 
                j++;
            // 如果右半部分元素已经全部处理完毕
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            // 左半部分所指元素 < 右半部分所指元素
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            // 左半部分所指元素 > 右半部分所指元素
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}
