package com.sort.selection;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择排序
 *
 * 1.查出最小的元素索引和对应的元素
 * 2.按照从小到大的顺序放入到新的集合中去
 *
 * @author Leon
 * @version 2019/4/29 23:19
 */
public class Main01 {

    public static void main(String[] args) throws Exception {
        List<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(-11);
        arr.add(0);
        arr.add(2);
        arr.add(-99);
        arr.add(56);
        arr.add(103);
        List<Integer> integers = selectionSort(arr);
        System.out.println(integers);
    }

    public static int findIndexOfSmall(List<Integer> source) {
        int small = source.get(0);
        int smallInx = 0;
        for (int i = 0; i < source.size(); i++) {
            if (small > source.get(i)) {
                small = source.get(i);
                smallInx = i;
            }
        }
        return smallInx;
    }

    public static List<Integer> selectionSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int smallInx = findIndexOfSmall(arr);
            result.add(arr.get(smallInx));
            arr.remove(smallInx);
        }
        return result;
    }
}
