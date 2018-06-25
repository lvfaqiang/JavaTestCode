package com.lvfq.sync;

/**
 * SyncMain
 *
 * @author lvfq
 * @date 2018/6/25 上午10:32
 * @mainFunction :
 */
public class SyncMain {

    public static void main(String[] args) {
        /**
         * 测试 1
         * 运行结果，info1 执行完成之后，开始执行 other1
         *
         *  logInfo1 ----------- Start
         logInfo1 ----------- End
         logOther1 ----------- Start
         logOther1 ----------- End
         *
         * 说明：synchronized 修饰方法，如果当前对象实例为同一个，则只能同时执行一个 带有 synchronized 修饰的方法。
         * 如果有多个 synchronized 修饰的方法同时调用时，执行顺序会等待上一个执行完成，才开始下一个方法执行。
         */

//        SyncObj obj = new SyncObj();
//        obj.logInfo1();
//        obj.logOther1();


        /**
         *  测试 2
         *  执行结果，同时执行，
         *
         *  说明： synchronized 修饰方法时，锁对象是当前对象实例， synchronized 修饰参数、属性时，当前锁对象是 当前参数、属性。
         *  两个执行时，互不影响。
         *
         */
        SyncObj syncObj2 = new SyncObj();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                syncObj2.logInfo2();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                syncObj2.logOther2();
            }
        };

//        t1.start();
//        t2.start();


        /**
         * 测试 3
         * 运行结果 t3 线程中的方法调用执行完成后，才会执行 t4 线程中的方法调用。
         *
         * 如果 synchronized 修饰的为 Class 类型时[ eg: logOther2()] 该代码块在当前类型中属于 同步代码块。
         * 这里不需要同一个实例，只要实例类型相同，就需要等待其他实例执行完成释放锁之后，才能调用。
         */

        Thread t3 = new Thread() {
            @Override
            public void run() {
                SyncObj obj = new SyncObj();
                obj.logOther2();
            }
        };

        Thread t4 = new Thread() {
            @Override
            public void run() {
                SyncObj obj = new SyncObj();
                obj.logOther2();
            }
        };

//        t3.start();
//        t4.start();


        /**
         * 测试 4
         * 运行结果： 如果是同一个实例，那么当前实例的其他同步代码块需要等候 锁对象 释放之后，才能调用
         * 如果不是同一个实例，那么则互不影响。
         */

        SyncObj obj4 = new SyncObj();

        Thread t5 = new Thread() {
            @Override
            public void run() {
//                obj4.logInfo3();
                SyncObj obj = new SyncObj();
                obj.logInfo3();

            }
        };

        Thread t6 = new Thread() {
            @Override
            public void run() {
//                obj4.logOther3();
                SyncObj obj = new SyncObj();
                obj.logOther3();
            }
        };

        t5.start();
        t6.start();


    }


    public static class SyncObj {

        //  方案一
        public synchronized void logInfo1() {
            System.out.println("logInfo1 ----------- Start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("logInfo1 ----------- End");
        }


        public synchronized void logOther1() {
            System.out.println("logOther1 ----------- Start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("logOther1 ----------- End");
        }


        // 方案二

        public synchronized void logInfo2() {
            System.out.println("logInfo2 ----------- Start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("logInfo2 ----------- End");
        }


        public void logOther2() {
            synchronized (SyncObj.class) {

                System.out.println("logOther2 ----------- Start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("logOther2 ----------- End");
            }
        }

        // 方案 四

        private byte[] lock = new byte[0];

        public void logInfo3() {
            synchronized (lock) {
                System.out.println("logInfo3 ----------- Start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("logInfo3 ----------- End");
            }
        }

        public void logOther3() {
            synchronized (lock) {
                System.out.println("logOther3 ----------- Start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("logOther3 ----------- End");
            }
        }


    }
}


