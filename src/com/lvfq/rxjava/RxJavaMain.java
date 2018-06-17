package com.lvfq.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/**
 * RxJavaMain
 *
 * @author lvfq
 * @date 2017/10/28 上午12:48
 * @mainFunction :
 */
public class RxJavaMain {

    // interval 定时器 ， range 区间， repeat

    public static void main(String[] args) {
//        create1();
//        create2();
//        create3();
//        create4();
//        testDefer();
    }

    /**
     * 初始化方式一
     */
    private static void create1() {
        /**
         * 创建被观察者
         */
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onNext("World");
//                throw new RuntimeException("test Exception");
                subscriber.onCompleted();
            }
        });

        /**
         * 创建观察者
         */
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("result : " + s);
            }
        };

        /**
         * 订阅事件
         */
        observable.subscribe(subscriber);
    }

    /**
     * 创建方式2
     */
    private static void create2() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onNext("world");
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("result : " + s);
            }
        });
    }

    /**
     * 创建方式3
     */
    private static void create3() {
        Observable.just("hello", "world").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("result : " + s);
            }
        });
    }

    private static void create4() {
        Observable.from(new Integer[]{1, 2, 3, 4, 5, 6}).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("result : " + s);
            }
        });
    }

    private static String value = "";

    private static void testDefer() {

        /**
         * defer 方法是当 subscribe() 方法调用之后，才会进行初始化调用，所以，这里打印结果时，value 已经是被赋值了的。
         */
        Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(value);
            }
        });
        value = "用来测试 defer方法";

        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("defer result : " + s);
            }
        });
    }
}
