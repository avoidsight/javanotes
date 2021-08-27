package leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-22 10:18
 */
public class Solution16_18 {
    public boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0 && value.length() == 0) return true;
        if (pattern.length() == 0) return false;
        int count_a = 0;
        int count_b = 0;
        for (char c : pattern.toCharArray()) {
            if (c == 'a') {
                count_a++;
            } else {
                count_b++;
            }
        }
        if (count_a > 0 && count_b > 0 && value.length() == 0) return false;
        if (count_a == 1 || count_b == 1) return true;

        int size = value.length();
        if (count_a == 0) {
            if (size % count_b != 0) return false;
            int sum_b = size / count_b;
            return match(0, sum_b, pattern, value);
        }

        if (count_b == 0) {
            if (size % count_a != 0) return false;
            int sum_a = size / count_a;
            return match(sum_a, 0, pattern, value);
        }


        for (int i = 0; i < size / count_a; i++) {
            if ((size - count_a * i) % count_b == 0) {
                int sum_b = (size - count_a * i) / count_b;
                if (match(i, sum_b, pattern, value)) {
                    return true;
                }
            }
        }
        return false;


    }

    boolean match(int sum_a, int sum_b, String pattern, String value) {
        StringBuilder sb = new StringBuilder();
        String ptn_a = null;
        String ptn_b = null;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                if (ptn_a == null) {
                    ptn_a = value.substring(i * sum_b, i * sum_b + sum_a);
                }
                sb.append(ptn_a);
            } else {
                if (ptn_b == null) {
                    ptn_b = value.substring(i * sum_a, i * sum_a + sum_b);
                }
                sb.append(ptn_b);
            }
        }
        return sb.toString().equals(value);
    }

    public static void main(String[] args) {
        Solution16_18 solution16_18 = new Solution16_18();
        boolean match = solution16_18.patternMatching("aaaa", "dogcatcatdog");
        System.out.println(match);
    }
}
