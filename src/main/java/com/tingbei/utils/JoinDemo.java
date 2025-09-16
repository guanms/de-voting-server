package com.tingbei.utils;

public class JoinDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1:开始执行");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2:开始执行");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("t3:开始执行");
        });
        try {
            /**
             * 常见情况
             * 1.main主线程创建并启动子线程
             * 2.主线程和子线程同时执行
             * 3.在某个时间点，主线程执行join方法，主线程获取子线程对象锁
             * 4.主线程检查是否还活着，如果还活着，则调用wait方法，释放锁，等待子线程执行完毕
             * 5.子线程执行完毕，jvm调用notify方法，唤醒等待的主线程
             * 6.主线程宠幸竞争子线程对象锁，继续执行
             */
            t1.start();
            t1.join();

            t2.start();
            t2.join();

            t3.start();
            t3.join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
