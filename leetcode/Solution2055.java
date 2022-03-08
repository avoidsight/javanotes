package leetcode;

import java.util.Arrays;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/3/8 10:41 AM
 */
public class Solution2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int count = 0;
            int count1 = 0;
            int last = 0;
            boolean f = false;
            for (int j = query[0]; j <= query[1]; j++) {
                if(j>=0 && j < s.length()) {
                    if(s.charAt(j) == '*' && f) count++;
                    if(s.charAt(j) == '|') {
                        f =true;
                        count1++;
                        last = j;
                    }
                }
            }
            if(count1 >1) {
                count = count - query[1] +last;
            }else {
                count = 0;
            }
            res[i] = count;
        }
        return res;
    }

    public int[] platesBetweenCandles1(String s, int[][] queries) {
        s = s + "|";
        int[] res = new int[queries.length];
        int[] pre = new int[s.length()];
        int[] next = new int[s.length()];
        boolean f = false;
        char[] c = s.toCharArray();
        int count = 0;
        int preCount = 0;
        int last = 0;
        for (int i = 0, l = c.length; i < l; i++) {
            if(c[i] == '*') {
                pre[i] = preCount;
                count ++;

            }
            if(c[i] == '|') {
                if(f) {
                    pre[i] = count;
                    next[i] = count;
                    preCount = count;
                    if(i > last +1) {
                        Arrays.fill(next, last+1, i,count);
                    }
                    if(i <s.length() -1){
                        last = i;
                    }
                }else {
                    f = true;
                    last = i;
                    count = 0;
                }
            }
        }
        Arrays.fill(next,last +1,s.length(), next[last]);
        for (int i = 0, l = queries.length; i < l; i++) {
            int[] query = queries[i];
            res[i] = pre[query[1]] - next[query[0]];
            res[i] = Math.max(res[i], 0);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2055 solution2055 = new Solution2055();
        System.out.println(Arrays.toString(solution2055.platesBetweenCandles1("***|**|*****|**||**|*" , new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}})));
    }
}
