package singleton;

import java.lang.reflect.Constructor;

public class DestroySingletonByReflect {
    public static void main(String[] args) throws Exception{  
        //实例化第一个单例对象     
        Person p = Person.getInstance(1, "zhap");
        //通过反射获取单例的类和构造方法
        Class cls = Person.class;
        Constructor c = cls.getDeclaredConstructors()[0];
        //强制将私有构造方法设置为公共方法
        c.setAccessible(true);
        //通过篡改的公共方法重新实例化一个对象
        Person p1 = (Person)c.newInstance(2,"zham");
        System.out.println(p.toString());
        System.out.println(p1.toString());
    }
}