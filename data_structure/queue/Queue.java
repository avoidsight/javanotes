import java.util.ArrayList;

public class Queue{
        int head;
        int tail;
        int[] str;
    
    public Queue(int head,int tail,int[] str){
        this.head = head;
        this.tail = tail;
        this.str = str;
    }

    public void inQueue(int s){
        str[tail] = s;
        head++;
        tail++;
    }
    public void outQueue(){
        head++;
    }

    public static void main(String[] args) {
        //最终输出的数组
        int outputArray[] = {3,3,9,1,9,6,7,4,1};
        //用来标记原来QQ号每位数字对应的数组(1,2,3,4...)
        int markArray[] = new int[100];
        //得出一个累加的数组
        for(int i = 0;i<outputArray.length;i++){
                markArray[i] = i;
        }
        //队列的头
        int head = 0;
        //队列的尾+1,当头和尾相等时,则该数组为空数组
        int tail = 9;
        //正确的QQ号数组
        int concrectArray[] = new int [outputArray.length];
        
        int index = 0;
       // int markArray[] = new int[outputArray.length];
        Queue q = new Queue(head, tail, markArray);
        while(q.head<q.tail){
            concrectArray[markArray[q.head]] = outputArray[index++];
            q.outQueue();
            if(q.head<q.tail)
            q.inQueue(markArray[q.head]);
        }
        for(int a:concrectArray){
            System.out.print(a+" ");
        }
    }
}