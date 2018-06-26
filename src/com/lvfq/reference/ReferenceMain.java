package com.lvfq.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.sql.Ref;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * ReferenceMain
 *
 * @author lvfq
 * @date 2018/6/25 下午5:18
 * @mainFunction :
 */
public class ReferenceMain {


    public static void main(String[] args) {
        WeakObj weakObj = new WeakObj();
        weakObj.excute();

        SoftObj softObj = new SoftObj();
        softObj.excute();

        WeakMap map = new WeakMap();
        map.excute();


    }


    public static class WeakObj {
        public void excute() {
            ReferenceObj obj = new ReferenceObj();
            WeakReference<ReferenceObj> objWeakReference = new WeakReference<ReferenceObj>(obj);
            obj.setContent("this is test Content");
            System.out.println("obj is Null " + (objWeakReference.get() == null));
            obj = null;
            System.gc();
            System.out.println("obj is Null1  " + (objWeakReference.get() == null));
        }
    }

    public static class SoftObj {
        public void excute() {
            ReferenceObj obj1 = new ReferenceObj();
            SoftReference<ReferenceObj> objSoftReference = new SoftReference<ReferenceObj>(obj1);
            obj1.setContent("this is test Content");
            System.out.println("obj is Null " + (objSoftReference.get() == null));
            obj1 = null;
            System.gc();
            System.out.println("obj is Null1  " + (objSoftReference.get() == null));

        }
    }

    public static class WeakMap {
        public void excute() {
            ReferenceObj obj1 = new ReferenceObj();
            ReferenceObj obj2 = new ReferenceObj();
            ReferenceObj obj3 = new ReferenceObj();

            WeakHashMap<String, ReferenceObj> map = new WeakHashMap<>();

            map.put("key1", obj1);
            map.put("key2", obj2);
            map.put("key3", obj3);

            for (Map.Entry<String, ReferenceObj> obj : map.entrySet()) {
                obj.getValue().setContent("this is Test Content");
            }

            System.out.println("key1 = " + map.get("key1"));
            map.remove("key1");

//            System.gc();
            for (String obj : map.keySet()) {
                System.out.println(" key : " + obj);
            }
            System.out.println("size = " + map.size());
        }
    }

    public static class ReferenceObj {

        private String content;

        public void setContent(String content) {
            System.out.println("content = " + content);
        }
    }

}
