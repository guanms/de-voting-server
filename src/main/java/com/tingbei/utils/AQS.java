package com.tingbei.utils;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQS {

    /**
     * 自定义一个不可重入锁
     */
    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }
    }

    private static Sync sync = new Sync();
    public static void lock() {
        sync.acquire(1);
    }
    public static void unlock() {
        sync.release(1);
    }
}
