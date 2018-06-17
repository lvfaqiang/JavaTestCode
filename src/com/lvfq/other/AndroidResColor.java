package com.lvfq.other;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * AndroidResColor
 *
 * @author lvfq
 * @date 2017/10/7 下午3:37
 * @mainFunction :
 */
public class AndroidResColor {

    private String path = "/Users/apple/Desktop/colors/";
    private String values = "    <color name=\"{0}\">#{1}</color>";

    int length = 16;
    String[] str = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static void main(String[] args) {
        AndroidResColor color = new AndroidResColor();
        color.generate();

    }

    private void generate() {
        long startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("< ? xml; version=\"1.0\" encoding=\"utf-8\"?>\n");
//        stringBuffer.append("<resources>\n");

        String a = "";
        String b = "";
        String c = "";
        String d = "";
        String e = "";
        String f = "";
        int count = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            a = str[i];
            for (int j = 0; j < length; j++) {
                b = str[j];
                for (int k = 0; k < length; k++) {
                    c = str[k];
                    for (int m = 0; m < length; m++) {
                        d = str[m];
                        for (int n = 0; n < length; n++) {
                            e = str[n];
                            for (int o = 0; o < length; o++) {
                                f = str[o];
                                stringBuffer.append(values.replace("{0}", getColor(a, b, c, d, e, f)).replace("{1}", a + b + c + d + e + f) + "\n");

                                count++;
                                if ((count < 16777216 && count % 798910 == 0) || count == 16777216) {
                                    index++;
                                    generateFile(stringBuffer, index);
                                    stringBuffer.setLength(0);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("count : " + count);
//        stringBuffer.append("</resources>\n");
//
//        File colorsFile = new File(path, "colors.xml");
//        try {
//            PrintWriter pw = new PrintWriter(new FileOutputStream(colorsFile));
//            pw.print(stringBuffer.toString());
//            pw.close();
//        } catch (FileNotFoundException exception) {
//            exception.printStackTrace();
//        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }


    /**
     * 获取 Ascll 码值
     *
     * @param value
     * @return
     */
    private int getAscll(String value) {
        String s = Integer.toHexString(value.toCharArray()[0]);
        return Integer.parseInt(s);
    }

    private void generateFile(StringBuffer buffer, int index) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        stringBuffer.append("<resources>\n");
        stringBuffer.append(buffer);
        stringBuffer.append("</resources>\n");

        File colorsFile = new File(path, "colors_" + index + ".xml");
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(colorsFile));
            pw.print(stringBuffer.toString());
            pw.close();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 参数固定6个
     *
     * @param strings
     * @return
     */
    private String getColor(String... strings) {
        String s1 = strings[0];
        String s2 = strings[1];
        String s3 = strings[2];
        String s4 = strings[3];
        String s5 = strings[4];
        String s6 = strings[5];

        String s = "";
        if ((s1.equals(s2) && s1.equals(s3) && s1.equals(s4) && s1.equals(s5) && s1.equals(s6)) ||
                (!s1.equals(s2) && s1.equals(s3) && s1.equals(s5) && s2.equals(s4) && s2.equals(s6))) {
            s = "color_" + s1 + s2;
        } else {
            s = "c_" + strings[0] + strings[1] + strings[2] + strings[3] + strings[4] + strings[5];
        }
        return s;
    }
}
