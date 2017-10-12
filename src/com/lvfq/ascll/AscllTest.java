package com.lvfq.ascll;

/**
 * AscllTest
 *
 * @author lvfq
 * @date 2017/10/8 下午4:49
 * @mainFunction :
 */
public class AscllTest {

    public static void main(String[] args) {
        AscllTest test = new AscllTest();
        test.intToAscll("8");

        Byte a = -2;
        Byte b = -1;
        System.out.println(a.equals(b));
    }

    private void intToAscll(String value) {
        char[] arr = value.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            // 获取当前字符的 Ascll码 十六进制结果
            String result = Integer.toHexString(arr[0]);
            // Integer.parseInt(String.valueOf(arr[0])) 获取当前字符的 Ascll码 十进制结果
            byte[] b = result.getBytes();
            System.out.println(" - " + arr[0] + " , " + result);
        }
    }

}
