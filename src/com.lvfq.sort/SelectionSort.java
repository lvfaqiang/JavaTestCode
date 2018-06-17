package com.lvfq.sort;

import java.util.Arrays;

/**
 * SelectionSort
 *
 * @author lvfq
 * @date 2018/6/17 下午2:58
 * @mainFunction : 选择排序
 */
public class SelectionSort {


    public static void main(String[] args) {

        int[] nums = ArrayTool.initArray(10, 100);
        System.out.println("before :" + Arrays.toString(nums));
        selectionSort(nums);
        System.out.println("after:" + Arrays.toString(nums));

    }


    /**
     * 选择排序
     * 排序方式，用某一个下标的值，分别和后面剩余的数据做比较，
     *
     * @param nums
     */
    private static void selectionSort(int[] nums) {
        int temp;
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] < nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
