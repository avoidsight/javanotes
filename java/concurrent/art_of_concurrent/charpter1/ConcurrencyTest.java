/**
 * 多线程一定快吗？
 * 当count<1,000,000时，串行会快，否则并行快。
 * 因为多线程要线程上下文切换以及死锁问题。ß
 */
public class ConcurrencyTest{
    private static final long count = 1000000000l;
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(()->{
           int a = 0;
           for(long i = 0;i<count;i++){
               a+=5;
           }
        });
        thread.start();
        int b=0;
        for(long i = 0; i<count;i++){
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :"+ time + "ms,b="+b);
    }
    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for(long i = 0;i<count;i++){
            a+=5;
        }
        int b=0;
        for(long i = 0; i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial :"+ time + "ms,b="+b);
    }
}