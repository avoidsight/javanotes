package com.zp.leetcode;

import java.util.Vector;

/**
 * @author menmenz
 * @version 1.0
 * @date 1/5/22 2:27 PM
 */
public class Solution1114 {
    private Vector<Integer> v = new Vector();

    public Solution1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        v.add(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        for(;;) {
            if(v.contains(1)) {
                break;
            }
        }
        printSecond.run();
        v.add(2);
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        for(;;) {
            if(v.contains(2)) {
                break;
            }
        }
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        Solution1114 solution1114 = new Solution1114();
        new Thread(()-> {
            try {
                solution1114.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                solution1114.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                solution1114.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
