package leetcode;

import com.zp.leetcode.external.TreeNode;

import java.util.*;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            list = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node);
            }
            if(isSymmetricList(list)) {
                list.stream().filter(Objects::nonNull).forEach(e -> {
                    queue.offer(e.left);
                    queue.offer(e.right);
                });
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean isSymmetricList(List<TreeNode> list) {
        if(list.size()< 2) {
            return true;
        }
        for(int i = 0,len = list.size(); i< len/2; i++) {
            if(list.get(i) ==null && list.get(len-i-1) == null) {
                continue;
            }else if(list.get(i) !=null && list.get(len-i-1) != null && list.get(i).val == list.get(len-i-1).val) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution101 solution101 = new Solution101();
        TreeNode root = new TreeNode(1,new TreeNode(2,null,new TreeNode(3)),new TreeNode(2,new TreeNode(3),null));
        System.out.println("solution101.isSymmetric(root) = " + solution101.isSymmetric(root));
    }
}
