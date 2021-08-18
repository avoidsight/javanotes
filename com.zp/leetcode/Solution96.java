package leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-07-16 09:54
 */
public class Solution96 {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<n+1;i++){
            for(int j = 0; j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees(4));
    }
}
