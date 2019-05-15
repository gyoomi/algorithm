/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.sort.quick;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *
 * @author Leon
 * @version 2019/5/5 15:56
 */
public class QuickSort02 {

    public static final int DEFAULT_PIVOT = 0;

    public static void main(String[] args) throws Exception {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(-9);
        arr.add(12);
        arr.add(20);
        arr.add(-98);
        arr.add(76);
        arr.add(3);
        arr.add(88);
        arr.add(898);
        arr.add(-919);
        List<Integer> rs = quickSort(arr);
        System.out.println(rs);
    }


    public static List<Integer> quickSort(List<Integer> source) {
        if (source.size() < 2) {
            return source;
        } else {
            int pivot = source.get(DEFAULT_PIVOT);
            List<Integer> less = source.stream().filter(e -> e < pivot).collect(Collectors.toList());
            List<Integer> greater = source.stream().filter(e -> e > pivot).collect(Collectors.toList());
            List<Integer> result = new ArrayList<>();
            result.addAll(quickSort(less));
            result.add(pivot);
            result.addAll(quickSort(greater));
            return result;
        }
    }
}













