package leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 1/5/22 2:52 PM
 */
public class Solution1576 {
    public String modifyString(String s) {
        char prev = ':', next = ':', curr = ':';
        StringBuilder sb = new StringBuilder();
        for(int i = 0, len = s.length(); i < len; i++) {
            curr = s.charAt(i);
            if (curr == '?') {
                prev = i == 0? ':' : sb.toString().charAt(i-1);
                next = i == len - 1? ':' : s.charAt(i+1);
                if (prev == 'a' && next == 'a') {
                    curr = 'b';
                }else if (prev == 'a') {
                    curr = next == 'b'? 'c':'b';
                }else if (next == 'a') {
                    curr = prev == 'b'? 'c':'b';
                }else {
                    curr = 'a';
                }
            }
            sb.append(curr);
        }
        return sb.toString();
    }
}
