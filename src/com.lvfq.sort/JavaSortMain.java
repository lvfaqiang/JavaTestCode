package com.lvfq.sort;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * JavaSortMain
 *
 * @author lvfq
 * @date 2017/5/4 下午1:45
 * @mainFunction : Java 排序测试。
 */
public class JavaSortMain {


    public static void main(String[] args) {
//        int[] nums = new int[]{2, 5, 1, 3, 7, 4, 8, 9, 0, 6};
//        bubbleSort(nums);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(6);
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
        // 这里是根据当前对象的某一个字段进行排序
//                if (o1 > o2) {
//                    return -1;
//                } else if (o1 == o2) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//        });
//        Collections.shuffle(list);
        intorate();
//        for (Integer in : list) {
//            System.out.print(in.intValue() + " , ");
//        }
//        for (int i :
//                nums) {
//            System.out.print(nums[i] + " , ");
//        }
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

    private static void intorate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse("2017-08-10 13:00:00");
            long time = date.getTime() - System.currentTimeMillis();
            int days = (int) (time / (1000 * 60 * 60 * 24));
            System.out.println("days : " + days);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
