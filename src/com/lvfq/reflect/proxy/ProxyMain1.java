package com.lvfq.reflect.proxy;

import com.lvfq.reflect.Parent;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyMain1
 *
 * @author lvfq
 * @date 2017/5/27 上午11:06
 * @mainFunction :
 */
class ProxyMain1 {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Say {
        String value();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Query {
        String value();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Filed {
        String value();
    }

    interface Subject {
        @Say("方法")
        String getName(@Query("name") String name, @Filed("nick") String nick);
    }


    static class ProxyHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//            Annotation[] deAn = method.getDeclaredAnnotations();
//            for (int i = 0; i < deAn.length; i++) {
//                Annotation an = deAn[i];
//                if (Say.class.isInstance(an)) {
//                    System.out.println(((Say) an).value());
//                }
//            }
            Say say = method.getAnnotation(Say.class);
            Annotation[][] param = method.getParameterAnnotations();
            String str = "?" + say.value();
            for (int i = 0; i < param.length; i++) {
                Annotation[] p = param[i];
                for (int j = 0; j < p.length; j++) {
                    Annotation a = p[j];
                    if (Query.class.isInstance(a)) {
                        Query query = (Query) a;
                        str += "&" + ((Query) a).value() + "=" + args[i];
                    } else if (Filed.class.isInstance(a)) {
                        str += "@" + ((Filed) a).value() + "=" + args[i];
                    }
                }
            }
//            System.out.println(str);
            return str;
        }
    }


    public static void main(String[] args) {
        ProxyHandler handler = new ProxyHandler();
        Subject s = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, handler);
        System.out.println(s.getName("发强", "强哥"));
    }

}
