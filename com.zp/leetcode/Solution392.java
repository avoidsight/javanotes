package leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-07-27 13:29
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int m = 0,max = s.length();
        for(int i = 0;i<t.length();i++){
            if(s.charAt(m) == t.charAt(i)){
                if(m==max-1){
                    return true;
                }
                m++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution392 solution392 = new Solution392();
        System.out.println(solution392.isSubsequence("axc","ahbgdc"));
    }
}
