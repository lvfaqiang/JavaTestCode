package com.lvfq.sort;

import java.util.Random;

/**
 * ArrayTool
 *
 * @author lvfq
 * @date 2018/6/17 下午2:48
 * @mainFunction :
 */
public class ArrayTool {

    public static int[] initArray(int length, int range) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(range);   // 取值 0-500之间，不包含500 ，
        }
        return arr;
    }
}
