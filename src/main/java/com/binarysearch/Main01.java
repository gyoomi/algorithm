/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.binarysearch;

/**
 * 二分查找
 *
 * @author Leon
 * @version 2019/4/29 15:18
 */
public class Main01 {

    public static void main(String[] args) throws Exception {
        int[] arr = {-9, 0, 1, 2, 22, 88, 91, 98};
        int i = binarySearch(arr, 98);
        System.out.println(i);
    }

    public static int binarySearch(int[] search, int ele) {
        if (search.length < 1) {
            return -1;
        }
        int lowInx = 0;
        int highInx = search.length - 1;
        while (lowInx <= highInx) {
            int midInx = (lowInx + highInx) / 2;
            int guess = search[midInx];
            if (guess == ele) {
                return midInx;
            } else if (ele > guess) {
                lowInx = midInx + 1;
            } else {
                highInx = midInx - 1;
            }
        }
        return -1;
    }
}















