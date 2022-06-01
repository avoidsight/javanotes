package com.zp.leetcode;

import com.zp.leetcode.external.Node;

public class Solution116 {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        dfs(root);
        return root;
    }
    public void dfs(Node root) {
        if(root.left == null) {
            return;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
