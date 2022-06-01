package com.zp.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        Map<Character, Integer> s1map = init(s1);
        int l = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i = 0; i<len2; i++) {
            if(s1map.containsKey(c2[i])){
                if(s1map.get(c2[i]) >0) {
                    s1map.put(c2[i], s1map.get(c2[i])-1);
                    if(i-l+1 == len1){
                        return true;
                    }
                }else{
                    while(c2[l] != c2[i]) {
                        s1map.put(c2[l],s1map.get(c2[l])+1);
                        l++;
                    }
                    l++;
                    if(l > len2 - len1) {
                        return false;
                    }
                }
            }else{
                for(int j = 0; j < i - l; j++) {
                    s1map.put(c2[l+j],s1map.get(c2[l+j])+1);
                }
                l = i + 1;
            }
        }
        return false;

    }

    public Map init(String s1) {
        int len1 = s1.length();
        Map<Character, Integer> s1map = new HashMap<>();
        char[] c1 = s1.toCharArray();
        for(int i = 0; i < len1; i++) {
            if (s1map.containsKey(c1[i])) {
                s1map.put(c1[i],s1map.get(c1[i])+1);
            }else {
                s1map.put(c1[i],1);
            }
        }
        return s1map;
    }
}
