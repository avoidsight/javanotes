package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map= new HashMap<>();
        char[] chars = s.toCharArray();
        int l=0;
        int max = 0;
        for(int i = 0;i <chars.length; i++ ) {
            if(map.containsKey(chars[i])) {
                l = Math.max(map.get(chars[i]) + 1, l);
            }
            map.put(chars[i],i);
            max = Math.max(max, i-l+1);
        }
        return max;
    }

    public static void main(String[] args) {
        char c = 'c';
        String s = "c";
        System.out.println(s.equals(c+""));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
