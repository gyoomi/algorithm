package com.other.retry;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/29 22:37
 */
public class Main {

    public static void main(String[] args) throws Exception {
        retry:
        for (int i = 0; i < 10; i++) {
            System.out.println(" i = " + i);
            for (int j = 10; j < 20; j++) {
                if (j == 15) {
                    break retry;
                }
                System.out.println(" j = " + j);
            }
        }
    }
}
