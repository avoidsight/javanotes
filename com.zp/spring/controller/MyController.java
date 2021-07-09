package com.zp.spring.controller;

import com.zp.spring.annotation.AutoWired;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-05-19 22:38
 */
public class MyController {

    @AutoWired
    private MyService myService;

    public void getService() {
        myService.sayHello();
    }
}
