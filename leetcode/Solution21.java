package leetcode;

import leetcode.external.ListNode;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = null;
        if(l1 == null && l2 == null){
            return list;
        }
        if(l1 == null) {
            list = l2;
            return list;
        }
        if(l2 == null) {
            list = l1;
            return list;
        }
        if(l1.val < l2.val) {
            list = new ListNode(l1.val);
            list.next = mergeTwoLists(l1.next, l2);
        }else{
            list = new ListNode(l2.val);
            list.next = mergeTwoLists(l1, l2.next);
        }
        return list;
    }
}
