package stack;

public class Stack{
    int top;//栈顶
    char[] arr;//栈
    public Stack(int top, char[] arr){
        this.top = top;
        this.arr = arr;
    }
    //进栈(开始为1,否则出栈到最后栈顶为负)
    public void inStack(char chr){
        top++;
        arr[top] = chr;
    }
    //出栈(如果是引用类型数组,出栈对象需要置为空,否则容易内存溢出)
    public char outStack() throws Exception{
        if(top == 0){
            throw new Exception("栈目前为空,无法出栈");
        }
        return arr[top--];
    }
    public static void main(String[] args) throws Exception{
        //需要验证是否为回文的序列
        String str = "黄山落叶松叶落山黄";
        //转化为字符数组
        char[] chr = str.toCharArray();
        //存储前一半字符数组
        char[] charArray = new char[100];
        //实例化一个栈
        int top = 0;
        Stack s = new Stack(top,charArray);
        //给字符数组赋值
        int mid = (top + chr.length)/2 - 1;
        for(int i = 0;i<=mid;i++){
            s.inStack(chr[i]);
        }
        //将前一半和后一半作对比
        mid = chr.length%2 == 0? (top + chr.length)/2:(top + chr.length)/2+1;
        for(int i = mid;i<chr.length;i++){
            if(s.outStack()==chr[i]){
                continue;
            }
            System.out.println(str+",不是回文序列!");
            return;
            
        }
        System.out.println(str+",是回文序列!");

    }
}