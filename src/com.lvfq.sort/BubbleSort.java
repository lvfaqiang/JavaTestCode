package com.lvfq.sort;

import java.util.Arrays;

/**
 * BubbleSort
 *
 * @author lvfq
 * @date 2018/6/17 下午2:34
 * @mainFunction : 冒泡排序
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] nums = ArrayTool.initArray(100, 100);
        System.out.println(" before " + Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println("after  ： " + Arrays.toString(nums));

    }




    /**
     * 冒泡排序
     * 排序方式，依次对比两个相邻的数值，，
     *
     * @param nums
     */
    private static void bubbleSort(int[] nums) {
        int temp;
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; i++) {
                if (nums[j] < nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
