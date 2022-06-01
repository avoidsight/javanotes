package com.zp.leetcode;

import leetcode.external.TreeNode;

public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return null;
        }
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        TreeNode res = new TreeNode(root1.val + root2.val);
        res.left = mergeTrees(root1.left,root2.left);
        res.right = mergeTrees(root1.right,root2.right);
        return res;
    }

    public TreeNode bfs(TreeNode root1, TreeNode root2, TreeNode res) {
        if(root1 == null && root2 == null) {
            return res;
        }
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        res = new TreeNode(root1.val + root2.val);
        res.left = bfs(root1.left,root2.left,null);
        res.right = bfs(root1.right,root2.right,null);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(7);
        node5.left = node6;
        node5.right = node7;
        node6.right = node8;
        node7.right = node9;
        Solution617 solution617 = new Solution617();
        TreeNode res = solution617.mergeTrees(node1, node5);
        System.out.println();
    }
}
