package com.lvfq.executor;

import java.util.concurrent.*;

/**
 * UseThreadPoolExecutor1
 *
 * @author lvfq
 * @date 2017/4/27 下午4:23
 * @mainFunction :
 */
public class UseThreadPoolExecutor1 {

    public static void main(String[] args) {
//        ExecutorService service = Executors.newScheduledThreadPool(10);

        // 自定义有界队列线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                5,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4),
                new CustomRejected());
        MyTask t1 = new MyTask(1, "2");
        MyTask t2 = new MyTask(2, "2");
        MyTask t3 = new MyTask(3, "2");
        MyTask t4 = new MyTask(4, "2");
        MyTask t5 = new MyTask(5, "2");
        MyTask t6 = new MyTask(6, "2");
        MyTask t7 = new MyTask(7, "2");
        MyTask t8 = new MyTask(8, "2");
        MyTask t9 = new MyTask(9, "2");
        MyTask t10 = new MyTask(10, "2");

        executor.execute(t1);
        executor.execute(t2);
        executor.execute(t3);
        executor.execute(t4);
        executor.execute(t5);
        executor.execute(t6);
        executor.execute(t7);
        executor.execute(t8);
        executor.execute(t9);
        executor.execute(t10);

        executor.shutdown();
    }

    public static class MyTask implements Runnable {

        private int id;
        private String taskName;

        public MyTask(int id, String taskName) {
            this.id = id;
            this.taskName = taskName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            System.out.println("run task id " + id);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
