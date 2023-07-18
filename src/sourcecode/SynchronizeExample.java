package sourcecode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;


public class SynchronizeExample {
    private static final int NUM_THREADS = 3;
    private static final int NUM_TASKS = 10;
    private static int sharedVariable = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_TASKS; i++) {
            Runnable task = new Task();
            executor.execute(task);
        }

        executor.shutdown();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            lock.lock(); // 获取锁
            try {
                // 修改共享变量
                sharedVariable++;
                System.out.println("Thread: " + Thread.currentThread().getName() + " - Shared Variable: " + sharedVariable);
            } finally {
                lock.unlock(); // 释放锁
            }
        }
    }
}






