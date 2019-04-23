/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.other.probability;

import java.util.Random;

/**
 * 给定函数返回0 1概率为p和1-p，根据这个函数构造函数使得返回0 1的概率一样
 *
 * @author Leon
 * @version 2019/4/23 14:12
 */
public class Main01Probability {

    public static void main(String[] args) throws Exception {
        int zeroOrOneSameProbability = getZeroOrOneSameProbability();
        System.out.println(zeroOrOneSameProbability);
        // int zeroOrOne = getZeroOrOne();
        // System.out.println(zeroOrOne);
    }

    /**
     * 定义函数，返回0概率为p;返回1概率为1-p
     *
     * 此代码展示的只是其中一种示例的情况。当然这种实现有很多方式。
     *
     * @return
     */
    public static int getZeroOrOne() {
        boolean b = new Random().nextBoolean();
        if (b) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 1. 生成0的概率为p，生成1的概率为1-p
     * 2. 生成0 1 概率为p(1-p)
     * 3. 生成1 0概率为(1-p)p
     * 4. 我们发现2和3中的概率相等。
     *
     * 据此我们可以得出使其返回0,1概率相等的函数。
     *
     *
     * @return
     */
    public static int getZeroOrOneSameProbability() {
        for (;;) {
            int i = getZeroOrOne();
            int j = getZeroOrOne();
            if (i == 0 && j == 1) {
                return 1;
            }
            if (i == 1 && j == 0) {
                return 0;
            }
        }
    }
}















