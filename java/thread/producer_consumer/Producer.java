import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
    public BlockingQueue queue;
    Producer(BlockingQueue blockingQueue){
        this.queue = blockingQueue;
    }
    
    @Override
    public void run() {
        try {
            while(true){
            Thread.sleep(100);
            queue.add(produce());
            System.out.println("成功生产一个对象，现有"+queue.size()+"个对象。");
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
}
    public Object produce(){
        return new Object();
    }
}