package com.zp.leetcode;

import com.zp.leetcode.external.ListNode;
import com.zp.leetcode.external.TreeNode;

public class Solution206 {
    private static ListNode res = null;
    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode first = recursion(head);
        first.next = null;
        return res;
    }

    public static ListNode recursion(ListNode node) {
        if (node.next == null) {
            res = node;
            return node;
        }
        recursion(node.next).next = node;
        return node;
    }

    public static ListNode reverseList1(ListNode head) {
        if(head == null){
            return null;
        }
        if (head.next == null) {
            res = head;
            return head;
        }
        reverseList1(head.next).next = head;
        head.next = null;
        return head;
    }

    public static void main(String[] args) {
        int a = 1;
        int v = (int)(a + 0.75);
        System.out.println(v);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = reverseList1(node1);
        return;
    }
}
