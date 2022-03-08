package leetcode;

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
        boolean cur_same = false;
        if (p == null && q == null) return true;
        if (p != null && q != null) {
            if (p.val == q.val) cur_same = true;
        } else {
            return false;
        }
        boolean left_same = isSameTree(p.left, q.left);
        boolean right_same = isSameTree(p.right, q.right);
        return cur_same && left_same && right_same;
    }

    public static void main(String[] args) {
        Solution100 solution100 = new Solution100();
        TreeNode p = solution100.new TreeNode(1);
        p.left = solution100.new TreeNode(2);
        p.right = solution100.new TreeNode(3);
        TreeNode q = p;
        System.out.println(solution100.isSameTree(p, q));
    }
}
