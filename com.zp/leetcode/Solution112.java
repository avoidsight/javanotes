package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-07-07 09:09
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left == null && root.right == null) return sum==root.val;
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right = new TreeNode(1);
        Solution112 solution112 = new Solution112();
        System.out.println("solution112.hasPathSum(root,22) = " + solution112.hasPathSum(root, 22));
    }
}
