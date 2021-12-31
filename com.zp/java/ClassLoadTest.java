package com.zp.java;

/**
 * @author menmenz
 * @version 1.0
 * @date 10/20/21 10:54 AM
 */
public class ClassLoadTest {
    public static int a = 1;
    public int b = 2;
    {
        System.out.println("common block a :"+a);
        System.out.println("common block b :"+b);

    }
    static {
        System.out.println("static block a :"+a);
    }

    public ClassLoadTest(){
        System.out.println("construction a :"+a);
        System.out.println("construction b :"+b);
    }

    public static void main(String[] args) {
        ClassLoadTest test = new ClassLoadTest();
    }
}
