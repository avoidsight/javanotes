package thread;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NewThread{
    public static void main(String[] args) {
        new Thread(){
            public void run(){
                System.out.println("线程已经启动,请求变身！");
            };
        }.start();
        new Thread(new Runnable(){
        
            @Override
            public void run() {
                System.out.println("同意变身！");  
            }
        }).start();
        new Thread(()->System.out.println("门门变身！")){}.start();

        Runnable r = ()->System.out.println("打败怪兽！");
        new Thread(r).start();
        String str = "hello word!";
        Arrays.asList(str.toCharArray()).forEach(System.out::println);
    }
}