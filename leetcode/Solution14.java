package com.zp.leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-15 17:38
 */
public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                try {
                    if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                        return sb.toString();
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    return sb.toString();
                }

            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
