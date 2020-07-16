package thread.producer_consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer{
    private static final List bufferList = new LinkedList<Object>();
    private static final int SIZE = 10;
    private static Lock lock = new ReentrantLock();
    private static Condition NOTNULL = lock.newCondition();
    private static Condition NOTEMPTY = lock.newCondition();

    public static class Producer extends Thread{
        @Override
        public void run(){
            while(true){
                lock.lock();
                if(bufferList.size()==SIZE){
                    System.out.println("BUFFER满了，让我缓一下...");
                    try {
                        NOTNULL.await();
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                }else{
                    bufferList.add(produce());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("生产了一个元素，当前队列中的元素有"+bufferList.size()+"个！");
                    NOTEMPTY.signal();
                }
                lock.unlock();
            }
        }
        public Object produce(){
            return new Object();
        }

    }

    public static class Consumer extends Thread{
        @Override
        public void run(){
            while(true){
                lock.lock();
                if(bufferList.size()==0){
                    System.out.println("BUFFER空了，让我去生产...");
                    try {
                        NOTEMPTY.await();
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                }else{
                    bufferList.remove(0);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费了一个元素，当前队列中的元素有"+bufferList.size()+"个！");
                    NOTNULL.signal();
                }
                lock.unlock();
            }
        }
        public void consume(){
        }

    }

    public static void main(String[] args) throws Exception{
        new Producer().start();
        new Consumer().start();
    }
}