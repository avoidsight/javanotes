public class ThreadCount{
    public static int count = 0;
    public static void main(String[] args) {
        for(int i = 0;i <2;i++){
            new Thread(new Runnable(){
            
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                    for(int i = 0;i<100;i++){
                        count++;
                    }
                }
            }).start();
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                //TODO: handle exception
            }
            System.out.println(count);
        }
    }
}