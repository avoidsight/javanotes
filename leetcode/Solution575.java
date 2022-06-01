package leetcode;

import java.util.Arrays;

/**
 * @author menmenz
 * @version 1.0
 * @date 11/1/21 9:49 AM
 */
public class Solution575 {
    public int distributeCandies(int[] candyType) {
        int size = candyType.length;

        int typeCount = (int)Arrays.stream(candyType).distinct().count();
        return size/2 > typeCount? typeCount: size/2;
    }

    public static void main(String[] args) {
        Solution575 solution575 = new Solution575();
        System.out.println(solution575.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
