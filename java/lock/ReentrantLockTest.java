import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest{
    private Lock lock = new ReentrantLock();

    public void show(Thread thread){
        if(lock.tryLock()){
            try {
                System.out.println(thread.getName()+"获得了锁！");
            } catch (Exception e) {
                //TODO: handle exception
            }finally{
                lock.unlock();
            }
        }else{
            System.out.println(thread.getName()+"获取锁失败！");
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        new Thread(){
            public void run(){
                System.out.println(0);
                test.show(Thread.currentThread());
            }
        }.start();
        new Thread(){
            public void run(){
                System.out.println(1);
                test.show(Thread.currentThread());
            }
        }.start();
    }
}