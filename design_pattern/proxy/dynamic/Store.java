import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//这是一个商店，什么都卖
public class Store implements InvocationHandler{
    public Object proxyObject;

    Store(Object object){
        this.proxyObject = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
            before();
            method.invoke(proxyObject, args);
            after();
            return null;
        }

    public void before(){
        System.out.println("这里卖的是什么呀？");
    }

    public void after(){
        System.out.println("那给我来一点！");
    }
}