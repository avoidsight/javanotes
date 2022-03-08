package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/3/6 2:25 PM
 */
public class Solution2100 {
    public List<Integer> goodDaysToRobBank(int[] a, int b) {
        List<Integer> r = new ArrayList<>();
        int l = a.length;
        if(l<2*b + 1){
            return r;
        }
        if(b == 0) {
            for(int i = 0 ; i < l; i++){
                r.add(i);
            }
            return r;
        }
        for(int i = l -1; i>=1;i--) {
            a[i] -=a[i-1];
        }
        for(int i = b; i < l-b;){
            if(a[i]>0) {
                i++;
                continue;
            }
            boolean t = true;
            for(int j = 0; j < b; j++) {
                if(a[i-j]>0 || a[i+j+1]<0){
                    t = false;
                    break;
                }
            }
            if(!t ) {
                i++;
                continue;
            }
            r.add(i);
            if(i+1 < l && a[i] != a[i+1]){
                i += b;
            }else{
                i++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Solution2100 solution2100 = new Solution2100();
        StringBuilder s = new StringBuilder();
        System.out.println(solution2100.goodDaysToRobBank(new int[]{4,3,2,1},1));
    }
}
