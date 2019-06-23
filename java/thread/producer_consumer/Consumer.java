import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
    public BlockingQueue queue;

    Consumer(BlockingQueue bQueue){
        this.queue = bQueue;
    }

    @Override
    public void run(){
        try {
            while(true){
                comsume(queue.take());
                Thread.sleep(150);
                System.out.println("处理了一个对象,目前队列中还有"+queue.size()+"个对象！");
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void comsume(Object obj){
        //todo
    }

}