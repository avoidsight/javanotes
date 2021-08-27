package leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-19 14:03
 */
public class Solution125 {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char c1;
        char c2;
        while (i < j) {
            while (!isNumOrChar(c1 = s.charAt(i))) {
                i++;
                if (i > j) {
                    return false;
                }
            }
            while (!isNumOrChar(c2 = s.charAt(j))) {
                j--;
                if (i > j) {
                    return false;
                }
            }
            // 将字母转化为小写 c|0x20
            // 将字母转化为大写 c&oxDF
            if ((c1 | 0x20) != (c2 | 0x20)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isNumOrChar(char c) {
        int index = (int) c;
        if (index < 58 && index > 47 || index < 91 && index > 64 || index < 123 && index > 96) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
