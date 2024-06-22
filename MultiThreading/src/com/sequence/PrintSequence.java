package com.sequence;

public class PrintSequence implements Runnable {

    private static int num = 1;
    private int maxNum;
    private int remainder;
    private int threadCount;
    private static Object lock;

    public PrintSequence(int maxNum, int remainder, int threadCount) {
        this.maxNum = maxNum;
        this.remainder = remainder;
        this.threadCount = threadCount;
        lock = new Object();
    }

    @Override
    public void run() {
        while(num<=maxNum-threadCount+1) {
            synchronized (lock) {
                while (num%threadCount!=remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName()+" = "+num);
                num++;
                lock.notifyAll();
            }
        }

    }
}
