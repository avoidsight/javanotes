import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CPTest{

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingDeque<>();
        Producer p = new Producer(blockingQueue);
        Consumer c = new Consumer(blockingQueue);
        p.start();
        c.start();
    }
}