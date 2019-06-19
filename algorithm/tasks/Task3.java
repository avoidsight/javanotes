import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * 输入一个字符串，打印该字符串的所有排列
 * abc
 * abc,abc,bac,bca,cab,cba
 */
public class Task3{
    public static int[] book;
    public static List<Character> box;
    public static int deep = 0;
    public static void print(String str){
        char[] chr = str.toCharArray();
        init(chr.length);
        int current = 0;
        dfs(chr, current);
    }
    public static void dfs(char[] chr,int current){
        if(box.size()==chr.length){
            Iterator it = box.iterator();
            while(it.hasNext()){
                System.out.print(it.next()+" "); 
            }
            System.out.println();
            // box.removeAll(box);
            box = null;
            box = new ArrayList<>();
        }
        while(current<chr.length){
        for(int i = 0;i<chr.length;i++){
            if(book[i] ==1) continue;
            if(book[i]==0){
                box.add(Character.valueOf(chr[i]));
                book[i] =1;
                dfs(chr, current+1);
                book[i] =0;
            }
        }
        return;
    }
    }
    public static void init(int size){
        book = new int[size];
        Queue
        box = new ArrayList<Character>();
        for (int i = 0; i < size; i++) {
            book[i] = 0;//0表示第i位字符没有使用过，1表示使用过，不能用了
        }
    }
    public static void main(String[] args) {
        String str = "1234";
        print(str);
    }
}