package com.odd_even;

public class Demo {

    public static void main(String[] args) {

        PrintOddEven printOdd = new PrintOddEven(1, 10, 1, 2);
        PrintOddEven printEven = new PrintOddEven(1, 10, 0, 2);

        Thread odd = new Thread(printOdd, "Odd Thread");
        Thread even = new Thread(printEven, "Even Thread");

        odd.start();
        even.start();

    }
}
