package com.lvfq.other;

import java.io.*;

/**
 * XmlTest
 *
 * @author lvfq
 * @date 2017/9/26 下午11:26
 * @mainFunction :
 */
public class XmlTest {


    private String getXmlText(File file) {
        StringBuilder builder = new StringBuilder();
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            char[] chars = new char[1024];
            int index = 0;
            while ((index = reader.read(chars)) != -1) {
                builder.append(chars, 0, index);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String path = "/Users/apple/Downloads/lay_y.xml";
        String tag = "dimen";
        String optionType = "*";
        try {
            if (args.length >= 3) {
                path = args[0];
                tag = args[1];
                optionType = args[2];
            } else if (args.length >= 2) {
                path = args[0];
                tag = args[1];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        new XmlTest().execute(path, tag, optionType);
    }

    private void execute(String path, String tag, String optionType) {
        File file = new File(path);
        String str = getXmlText(file);
//        System.out.println("str: " + str);

        boolean has = true;
        int startTagLength = tag.length() + 1;
        int endTagLength = tag.length() + 3;

        String startTag = "<" + tag;
        String endTag = "</" + tag + ">";

//        int startIndex = str.indexOf(startTag);
//        int endIndex = str.indexOf(endTag);
//        str = str.substring(0, startIndex);

//        System.out.println(" index : " + startIndex + " , " + endIndex + " , " + str);

        while (has) {
            if (!str.contains(startTag) && !str.contains(endTag)) {
                has = false;
                break;
            }
            if (optionType.equals("*")) {
                int length = str.length();
                int startIndex = str.indexOf(startTag);
                int endIndex = str.indexOf(endTag);
                str = str.substring(0, startIndex) + str.substring(endIndex + endTagLength, length);
            } else {
                str.replace(startTag, "<" + optionType);
                str.replace(endTag, "</" + optionType + ">");
            }
        }

//        System.out.println("end String： " + str + " , " + file.getParentFile().getPath() + " , name: " + file.getName());

        File nFile = new File(file.getParentFile().getAbsolutePath(), "new_" + file.getName());
//        nFile.mkdir();
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(nFile));
            pw.print(str);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
