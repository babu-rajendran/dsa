package com.babu.corejava;

import java.util.Scanner;

public class OddEvenPrinter {

    private int number = 1;
    private final int max;

    public OddEvenPrinter(int max) {
        this.max = max;
    }

    public void printOdd() {
        synchronized (this) {
            while (number <= max) {
                if (number % 2 == 1) {
                    System.out.println("Odd Thread: " + number);
                    number++;
                    notify(); // Wake up the even thread
                } else {
                    try {
                        wait(); // Wait for even thread to finish
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            notify(); // Final notify in case even is waiting
        }
    }

    public void printEven() {
        synchronized (this) {
            while (number <= max) {
                if (number % 2 == 0) {
                    System.out.println("Even Thread: " + number);
                    number++;
                    notify(); // Wake up the odd thread
                } else {
                    try {
                        wait(); // Wait for odd thread to finish
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            notify(); // Final notify in case odd is waiting
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int max = scanner.nextInt();

        OddEvenPrinter printer = new OddEvenPrinter(max);

        Thread t1 = new Thread(printer::printOdd);
        Thread t2 = new Thread(printer::printEven);

        t1.start();
        t2.start();
    }
}
