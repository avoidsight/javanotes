package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author menmenz
 * @version 1.0
 * @date 6/21/21 6:48 PM
 */
public class Solution401 {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> all = new ArrayList<>(720);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 59; j++) {
                if(Integer.bitCount(i)+Integer.bitCount(j) == turnedOn) {
                    if (j < 10) {
                        all.add(i + ":0" + j);
                    } else {
                        all.add(i + ":" + j);
                    }
                }
            }
        }
        return all;
    }

    public static void main(String[] args) {
        Solution401 solution401 = new Solution401();
        System.out.println(solution401.readBinaryWatch(5).toString());
    }
}
