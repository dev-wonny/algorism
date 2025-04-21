package main._202503;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // 🔒 락 획득
        try {
            count++;
        } finally {
            lock.unlock(); // 🔓 반드시 해제
        }
    }

    public int getCount() {
        return count;
    }

    // 테스트용
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("최종 카운트: " + counter.getCount()); // 2000이어야 함
    }
}
