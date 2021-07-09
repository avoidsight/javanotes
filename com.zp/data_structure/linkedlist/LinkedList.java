package linkedlist;

public class LinkedList {

    public static void main(String[] args) {
        //链表数据
        int data[] = new int[15];
        int tmpdata[] = {0, 3, 1, 3, 9, 4, 1, 7, 9};
        for (int i = 0; i < tmpdata.length; i++) {
            data[i] = tmpdata[i];
        }
        /**链表的指向
         * index[0] = 1 指的是 data第0位的下一位是data[1]
         */
        int index[] = new int[15];
        for (int i = 0; i < tmpdata.length; i++) {
            if (i == tmpdata.length - 1) {
                index[i] = 0;
                break;
            }
            index[i] = i + 1;
        }
        //往data[3]后面插入一个6
        data[tmpdata.length] = 6;
        index[3] = tmpdata.length;
        index[tmpdata.length] = 4;

        // for (int i : index) {
        //     System.out.print(i+" ");
        // }

        //遍历链表
        int j = 1;
        while (j != 0) {
            System.out.print(data[j] + " ");
            j = index[j];
        }

    }
}