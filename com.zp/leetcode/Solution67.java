package leetcode;

/**
 * @author menmenz
 * @version 1.0
 * @date 2020-06-23 10:26
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        int max = Math.max(a.length(),b.length());
        StringBuilder sb = new StringBuilder();
        // 进制位 相对位置上a的值，b的值
        int plus = 0,part_a = 0,part_b = 0,res;
        for(int i = 1;i<= max; i++){
            if(a.length()-i <0){
                part_a = 0;
            }else {
                part_a = a.charAt(a.length()-i)-48;
            }
            if(b.length()-i <0){
                part_b = 0;
            }else {
                part_b = b.charAt(b.length() - i) -48;
            }
            if((res = part_a+part_b+plus) > 1){
                sb.append(res-2);
                plus = 1;
            }else {
                sb.append(res);
                plus = 0;
            }
        }
        if(plus == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        String s = solution67.addBinary("1010", "1011");
        System.out.println(s);
    }
}
