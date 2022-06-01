package com.zp.leetcode;

import com.zp.leetcode.external.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int deep = 0;
        while(!queue.isEmpty()) {
            while(!queue.isEmpty()) {
                if(queue.poll().left == null) list.add(queue.poll().left);
                if(queue.poll().right == null) list.add(queue.poll().right);
            }
            deep++;
            list.stream().forEach(queue::offer);
        }
        return deep;
    }
}
