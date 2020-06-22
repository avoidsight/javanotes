package singleton;

public class Singleton {
    /**
     * 单例模式的三要素
     * 1.构造方法私有化
     * 2.实例化对象的私有化
     * 3.提供实例化对象的方法公有化
     */
    private volatile static Singleton uniqueInstance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (uniqueInstance == null) {//防止大量线程加锁导致等待
            synchronized (Singleton.class){
                if(uniqueInstance == null){//进入区域后，再检查一次，如果仍是null,才创建实例
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}