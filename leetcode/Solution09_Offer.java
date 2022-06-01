package com.zp.leetcode;

import java.util.LinkedList;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-30 10:07
 */
public class Solution09_Offer {
    /**
     * 当前栈，保存这现存的数
     */
    LinkedList<Integer> stack1 = new LinkedList<>();
    /**
     * 删除栈，不一定都删除了，只是保存了删除的顺序
     * 删除时优先从该栈删除
     */
    LinkedList<Integer> stack2 = new LinkedList<>();

    public Solution09_Offer() {

    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        // 删除栈中是否有数
        if (stack2.isEmpty()) {
            // 如果删除栈和当前栈都没数，返回-1
            if (stack1.isEmpty()) return -1;
            // 删除栈为空，但是当前栈有值，直接把当前栈所有的值加到删除栈中
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            //删除并返回删除栈的栈顶
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }
}
