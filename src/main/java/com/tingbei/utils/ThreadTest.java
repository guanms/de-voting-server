package com.tingbei.utils;

public class ThreadTest {

    public static void main(String[] args) {
        new ThreadExample().start();
    }

    static class ThreadExample extends Thread {

        public void run() {
            System.out.println("Thread is running");
        }
    }
}
