package leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-07-22 09:45
 */
public class Solution11_Offer {
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        Solution11_Offer solution11_offer = new Solution11_Offer();
        System.out.println(solution11_offer.minArray(new int[]{3, 4, 5, 1, 2}));
    }
}
