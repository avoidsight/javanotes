package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Customer {

    public static void main(String[] args) {
        proxy.dynamic.Wine wine = new proxy.dynamic.Wine("二锅头");
        InvocationHandler iHandler = new proxy.dynamic.Store(wine);
        proxy.dynamic.License lcs = (proxy.dynamic.License) Proxy.newProxyInstance(wine.getClass().getClassLoader(), wine.getClass().getInterfaces(), iHandler);
        lcs.sell();

        //动态代理，新增一个商品的时候，不用重新写个代理类
        System.out.println();

        proxy.dynamic.Cigarette cigarette = new proxy.dynamic.Cigarette("中华");
        InvocationHandler iHandler2 = new proxy.dynamic.Store(cigarette);
        proxy.dynamic.License lcs2 = (proxy.dynamic.License) Proxy.newProxyInstance(cigarette.getClass().getClassLoader(), cigarette.getClass().getInterfaces(), iHandler2);
        lcs2.sell();
    }
}