package com.sequence;

public class Demo {

    public static void main(String[] args) {

        int threadCount = 4;
        int maxNum = 10;

        Thread t1 = new Thread(new PrintSequence(maxNum, 3, threadCount), "T1");
        Thread t2 = new Thread(new PrintSequence(maxNum, 2, threadCount), "T2");
        Thread t3 = new Thread(new PrintSequence(maxNum, 1, threadCount), "T3");
        Thread t4 = new Thread(new PrintSequence(maxNum, 0, threadCount), "T4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
