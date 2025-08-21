package com.tingbei.utils;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    private final static int THREAD_COUNT = 10;

    private static final Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + ":正在执行");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
