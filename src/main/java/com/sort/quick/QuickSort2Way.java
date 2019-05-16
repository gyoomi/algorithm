/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.sort.quick;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/16 11:44
 */
public class QuickSort2Way {

    public static void main(String[] args) throws Exception {
        Integer[] integers = SortTestHelper.generateNearlyOrderedArray(1000000, 15);
        sort(integers);

    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Integer[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition2Way(arr, l, r);
        sort(arr, l, p);
        sort(arr, p + 1, r);
    }

    /**
     * 双路快速排序的partition
     * 返回p, 使得arr[l...p-1] <= arr[p] ; arr[p+1...r] >= arr[p]
     * 双路快排处理的元素正好等于arr[p]的时候要注意，详见下面的注释：）
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition2Way(Integer[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        int v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1 ,j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
            while (i <= r && arr[i] < v) {
                i++;
            }
            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            // 思考一下为什么?
            while (j >= l + 1 && arr[j] > v) {
                j--;
            }
            // 大家可以参考: http://coding.imooc.com/learn/questiondetail/4920.html
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

}















