package com.zp.leetcode;

import java.util.*;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-25 23:20
 */
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean searchChild(String s, int start, List<String> wordDict, int max, List<String> unMatch){
        if(start==s.length()){
            return true;
        }
        if(s.length()-start+1 < max){
            max = s.length()-start;
        }
        for(int i = start+max-1;i>=start;i--){
            if(unMatch.contains(s.substring(start,i+1))) continue;
            if(wordDict.contains(s.substring(start,i+1))){
                wordDict.add(s.substring(0,i+1));
                max = i+1;
                if(searchChild(s,i+1,wordDict,max,unMatch)) {
                    return true;
                }
            }
        }
        unMatch.add(s.substring(start));
        return false;
    }



    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        List<String> list = new ArrayList<>();
//        list.add("leet");
//        list.add("code");
//        System.out.println(solution139.wordBreak("leetcode", list));
//        list = new ArrayList<>();
//        list.add("cats");
//        list.add("dog");
//        list.add("sand");
//        list.add("and");
//        list.add("cat");
//        System.out.println(solution139.wordBreak("catsandog", list));
        list = new ArrayList<>();
        list.add("a");
        list.add("aa");
        list.add("aaa");
        list.add("aaaa");
        list.add("aaaaa");
        list.add("aaaaaa");
        list.add("aaaaaaa");
        list.add("aaaaaaaa");
        list.add("aaaaaaaaa");
        list.add("aaaaaaaaaa");
        System.out.println(solution139.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", list));
    }
}
