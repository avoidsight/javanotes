public class DepthFirstSearch{

    //存数字的数组
    public int NUM[];
    //箱子的总个数
    public int SIZE;
    //计数器
    public int COUNT;
    //标记数组中的那几个数被用过了,0表示没用过,1表示用过
    public int book[];
    public DepthFirstSearch(int[] num){
        this.NUM = num;
        this.SIZE = num.length;
        this.book = new int[SIZE];
        //初始化,开始所有的数都没用过
        for(int i = 0; i<SIZE;i++){
            book[i] = 0;
        }
    }

    public void dfs(int curbox){
        //当前箱子在第9个箱子(超出了,箱子的下标从0开始),开始判断数的组合的正确性,这里使用&更快一点
        if(curbox == SIZE & 100*NUM[0]+10*NUM[1]+NUM[2]+100*NUM[3]+10*NUM[4]+NUM[5] == 100*NUM[6]+10*NUM[7]+NUM[8]){
            System.out.println(COUNT+++":"+(100*NUM[0]+10*NUM[1]+NUM[2])+"+"+(100*NUM[3]+10*NUM[4]+NUM[5])+"="+(100*NUM[6]+10*NUM[7]+NUM[8]));
        }
        while(curbox < SIZE){
            //当前箱可供的选择,每个箱子都遍历1~9
            for(int i = 0;i<SIZE;i++){
                if(book[i] == 1)
                    continue;
                NUM[curbox] = i+1;
                book[i] = 1;
                dfs(curbox+1);
                //使用完把该数重新设为未使用,供其他箱使用
                book[i] = 0;
            }
            //跳出循环
            return;
        }
    }
    public static void main(String[] args) {
       DepthFirstSearch dfs = new DepthFirstSearch(new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1});
       dfs.dfs(0);
    }
}