package com.zp.leetcode;

import java.util.Stack;

/**
 * @author menmenz
 * @version 1.0
 * @date 1/7/22 10:13 AM
 */
public class Solution71 {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String part :
                parts) {
            if (part.equals("..")) {
                if(!stack.empty()) {
                    stack.pop();
                }
                continue;
            }
            if (part.equals(".")) {
                continue;
            }
            if (!part.equals("")) {
                stack.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.insert(0,"/");
            sb.insert(1,stack.pop());
        }
        if(sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(new Solution71().simplifyPath(path));
    }
}
