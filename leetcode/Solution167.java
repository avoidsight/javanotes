package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-07-20 13:36
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[]{0, numbers.length - 1};
        int sum;
        while (res[0] < res[1]) {
            sum = numbers[res[0]] + numbers[res[1]];
            if (sum == target) return new int[]{res[0] + 1, res[1] + 1};
            if (sum > target) {
                res[1]--;
            } else {
                res[0]++;
            }
        }
        return res;

    }
    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< numbers.length; i++) {
            if(map.containsKey(numbers[i])){
                return new int[]{map.get(numbers[i]), numbers[i]};
            }
            map.put(target-numbers[i], numbers[i]);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution167 solution167 = new Solution167();
        System.out.println(Arrays.toString(solution167.twoSum1(new int[]{2, 7, 11, 15}, 9)));
    }
}
