package com.lvfq.butterknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * BindView
 *
 * @author lvfq
 * @date 2018/6/20 下午6:34
 * @mainFunction :
 */

@Target(ElementType.FIELD) // 定义当前注解使用在变量上。
//@Target(ElementType.METHOD)   // 定义当前注解使用方法上。
//@Retention(RetentionPolicy.SOURCE)  // 表示当前注解存在于源码中，当源码被编译成字节码时，该注解被清除。
//@Retention(RetentionPolicy.CLASS)   // 表示当前注解存在于字节码中，当源码被编译成字节码时，该注解不会被清除。
@Retention(RetentionPolicy.RUNTIME) // 当前注解存在于 Java 虚拟机中
public @interface BindView {
}
