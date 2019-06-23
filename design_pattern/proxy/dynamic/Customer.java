import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Customer{

    public static void main(String[] args) {
        Wine wine = new Wine("二锅头");
        InvocationHandler iHandler = new Store(wine);
        License lcs = (License)Proxy.newProxyInstance(wine.getClass().getClassLoader(), wine.getClass().getInterfaces(), iHandler);
        lcs.sell();
        
        //动态代理，新增一个商品的时候，不用重新写个代理类
        System.out.println();

        Cigarette cigarette = new Cigarette("中华");
        InvocationHandler iHandler2 = new Store(cigarette);
        License lcs2 = (License)Proxy.newProxyInstance(cigarette.getClass().getClassLoader(), cigarette.getClass().getInterfaces(), iHandler2);
        lcs2.sell();
    }
}