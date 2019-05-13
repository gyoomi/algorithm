package com.sort.merge;

import java.util.Arrays;

/**
 * 自底向上的归并排序
 *
 * @author Leon
 * @version 2019/5/13 22:38
 */
public class MergeSortBU {

    public static void main(String[] args) throws Exception {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int sz = 1; sz <= n; sz *= 2) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
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
