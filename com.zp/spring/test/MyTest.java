package com.zp.spring.test;

import com.zp.spring.annotation.AutoWired;
import com.zp.spring.controller.MyController;

import java.util.stream.Stream;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-05-19 22:39
 */
public class MyTest {

    public static void main(String[] args) {
        //  这里不讨论myController的注入，类似
        MyController controller = new MyController();
        Stream.of(controller.getClass().getDeclaredFields()).forEach(field -> {
            // 设置myService可见
            field.setAccessible(true);

            AutoWired autoWired = field.getAnnotation(AutoWired.class);
            // 字段上是否由@Autowired注解
            if(autoWired == null){
                return;
            }

            try {
                // field赋值，只为myService字段的类型的实例
                field.set(controller,field.getType().newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        });
        // 调用，是否成功注入
        controller.getService();
    }
}
