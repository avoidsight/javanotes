package com.zp.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author menmenz
 * @version 1.0
 * @date 1/5/22 3:06 PM
 */
public class Solution1115 {
    private int n;

    private CyclicBarrier cb;

    volatile boolean isFoo = true;
    public Solution1115(int n) {
        this.n = n;
        cb = new CyclicBarrier(2);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!isFoo) {
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            isFoo = false;

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (isFoo) {
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            isFoo = true;
        }
    }

    public static void main(String[] args) {
        Solution1115 solution1115 = new Solution1115(1000);
        new Thread(() -> {
            try {
                solution1115.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                solution1115.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
