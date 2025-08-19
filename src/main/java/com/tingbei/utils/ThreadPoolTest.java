package com.tingbei.utils;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    static class PriorityThreadPoolExample implements Runnable, Comparable<PriorityThreadPoolExample>{
        private final int priority; //数字越大优先级越高
        private final String name;

        public PriorityThreadPoolExample(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public int compareTo(PriorityThreadPoolExample o) {
            return Integer.compare(o.priority, this.priority);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 执行任务: " + name + "，优先级: " + priority);
        }
    }

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<>());

        executor.execute(new PriorityThreadPoolExample(1, "任务1"));
        executor.execute(new PriorityThreadPoolExample(3, "任务3"));
        executor.execute(new PriorityThreadPoolExample(2, "任务2"));

        executor.shutdown();

    }

}
