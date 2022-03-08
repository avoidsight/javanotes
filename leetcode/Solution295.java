package leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 8/27/21 10:56 AM
 */
class Solution295 {
    private Node root ;
    int length;
    /** initialize your data structure here. */
    private Solution295() {
        this.length = 0;
    }

    private void addNum(int num) {
        if (root == null) {
            root = new Node(num);
            length++;
            return;
        }
        Node pre = new Node();
        pre.next = root;
        Node node = root;
        while (node != null && node.val < num) {
            pre = node;
            node = node.next;
        }
        Node newNode = new Node(num);
        if(pre.next == root) {
            root = newNode;
        }
        pre.next = newNode;
        newNode.next = node;
        length++;
    }

    private double findMedian() {
        Node node = root;
        if((length & 1) == 1){
            for (int i = 0; i < length / 2; i++) {
                node = node.next;
            }
            return node.val;
        }else {
            for (int i = 0; i < length / 2 -1; i++) {
                node = node.next;
            }
            return (double)(node.val+node.next.val)/2;
        }
    }
    class Node{
        int val;
        Node next;

        Node(){

        }

        Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Solution295 obj = new Solution295();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        obj.addNum(3);
        obj.addNum(2);
        obj.addNum(1);
        double res = obj.findMedian();
        System.out.println("param = " + res);
    }
}