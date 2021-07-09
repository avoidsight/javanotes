package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 5/17/21 1:19 PM
 */
public class Solution993 {
    public int deepX = 0;
    public int deepY = 0;
    public TreeNode parent;
    public TreeNode parentX ;
    public TreeNode parentY ;
    public boolean isCousins(TreeNode root, int x, int y) {
        findXY(root, x, y);
        if(x == y && parentX.val != parentY.val) return true;
        return false;
    }
    public void findXY(TreeNode root, int x, int y) {
        if(root == null || (deepX != 0 && deepY !=0)) return;
        if(root.val == x) {
            parentX = parent;
        }
        if(root.val == y) {
            parentY = parent;
        }
        x++;
        y++;
        parent = root;
        findXY(root.left, x, y);
        findXY(root.right, x, y);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left
    }
}
