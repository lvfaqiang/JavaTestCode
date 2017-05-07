package com.lvfq.sort;

/**
 * JavaSortMain
 *
 * @author lvfq
 * @date 2017/5/4 下午1:45
 * @mainFunction : Java 排序测试。
 */
public class JavaSortMain {


    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, 3, 7, 4, 8, 9, 0, 6};
        bubbleSort(nums);
        for (int i :
                nums) {
            System.out.print(nums[i] + " , ");
        }
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    private static void bubbleSort(int[] nums) {
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
