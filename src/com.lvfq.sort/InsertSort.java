package com.lvfq.sort;

import java.util.Arrays;

/**
 * InsertSort
 *
 * @author lvfq
 * @date 2018/6/17 下午3:12
 * @mainFunction : 插入排序
 * <p>
 * 插入排序 ， 初始化下标 是1 ， 然后和前一个相比
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = ArrayTool.initArray(10, 100);
        System.out.println(" before " + Arrays.toString(nums));

        insertSort_1(nums);

        System.out.println(" after  " + Arrays.toString(nums));
    }

    private static void insertSort(int[] nums) {
        int temp;
        int size = nums.length;
        int index;
        for (int i = 1; i < size; i++) {
            index = i;
            for (int j = index - 1; j >= 0; j--) {
                if (nums[index] < nums[j]) {
                    temp = nums[index];
                    nums[index] = nums[j];
                    nums[j] = temp;
                }
                index--;
            }
        }
    }

    private static void insertSort_1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                int temp = nums[i];
                int k = i - 1;
                while (k >= 0 && nums[k] > temp) {
                    nums[k + 1] = nums[k];
                    k -= 1;
                }
                nums[k + 1] = temp;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
