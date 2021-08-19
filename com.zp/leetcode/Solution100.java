package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-23 12:41
 */
public class Solution100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 深度优先算法
//        boolean cur_same = false;
//        if(p== null && q == null) return true;
//        if(p != null && q != null) {
//            if(p.val == q.val) cur_same = true;
//        }else{
//            return false;
//        }
//        boolean left_same = isSameTree(p.left,q.left);
//        boolean right_same = isSameTree(p.right,q.right);
//        return cur_same && left_same && right_same;
//
        // 广度优先算法
        Queue<TreeNode> queue1 = new LinkedList();
        Queue<TreeNode> queue2 = new LinkedList();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() || !queue2.isEmpty()){

            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null){
                return false;
            }
            if(node1.val == node2.val) {
                if (node1.left != null && node2.left != null) {
                    queue1.offer(node1.left);
                    queue2.offer(node2.left);
                }else if(node1.left != null || node2.left != null){
                    return false;
                }
                if(node1.right != null && node2.right != null) {
                    queue1.offer(node1.right);
                    queue2.offer(node2.right);
                }else if(node1.right != null || node2.right != null) {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution100 solution100 = new Solution100();
        TreeNode p = solution100.new TreeNode(1);
        p.left =null;
        p.right = solution100.new TreeNode(3);
        TreeNode q = solution100.new TreeNode(1);
        q.left = solution100.new TreeNode(3);
        System.out.println(solution100.isSameTree(p,q));
    }
}
