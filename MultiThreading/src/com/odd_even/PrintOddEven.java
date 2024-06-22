package com.odd_even;

public class PrintOddEven implements Runnable {

    private static int num;
    private int maxNum;
    private int remainder;
    private int threadCount;
    private static Object lock;

    public PrintOddEven(int num, int maxNum, int remainder, int threadCount) {
        this.num = num;
        this.maxNum = maxNum;
        this.remainder = remainder;
        this.threadCount = threadCount;
        lock = new Object();
    }

    @Override
    public void run() {
        while(num<=maxNum) {
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
                lock.notify();
            }
        }

    }
}
