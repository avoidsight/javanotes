public class Task5{
    public  static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        int[] numarr1 = change(num1);
        int numarr2[] = change(num2);
        int res[][] = new int[numarr2.length][numarr1.length+numarr2.length];
        for(int i = numarr2.length-1;i>=0;i--){
            cal(res,numarr1,numarr2[i],numarr2.length-1-i);
        }
        for(int i = 0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
        return result(res);
    }
    // 由最终的二维数组来计算最终的值
    @SuppressWarnings("all")
    public static String result(int[][] arr){
        int wid = arr.length;
        int len = arr[0].length;
        int arr1[] = new int[len];
        int carry = 0;
        //开始计算每一列的值
        for(int i = 0;i<len;i++){
            //从上往下相加
            for(int j=0;j<i+1&&j<wid;j++){
                arr1[len-1-i] = arr1[len-1-i] +arr[j][len-1-i];
            }
            arr1[len-1-i] +=carry;
            //用完归零！！！
            carry = 0;
            if(arr1[len-1-i]>9){
                carry = arr1[len-1-i]/10;
                arr1[len-1-i] = arr1[len-1-i]%10;
            }
        }
        //记录最前的位置在哪
        int flag = 0;
        for(int i = 0;i<arr1.length;i++){
            if(arr1[i]!=0){
                //如果最前面的还是有进位的话，拿出来放在最前面
                if(carry!=0){
                    arr1[i-1] = carry;
                    flag = i-1;
                    break;
                }
                flag = i;
                break;
            }
        }
        StringBuilder s = new StringBuilder();
        for(int i=flag;i<arr1.length;i++){
            s.append(arr1[i]);
        }
        return s.toString();
    }
    //将字符串转化为数整型数组
    public static int[] change(String s){
        int num[] = new int[s.length()];
        String str[] = s.split("");
        for(int i = 0;i<str.length;i++){
            num[i] = Integer.valueOf(str[i]);
        }
        return num;
    }
    //把两个整型数组相乘,从一个数组里面拿出一个数和另一个数组相乘
    public static void cal(int[][] res ,int[] arr,int p,int deep){
        int wid = res.length;
        int len = res[0].length;
        int carry = 0;
        int flag = 0;
        for(int i = arr.length-1;i>=0;i--){
            flag = len-1-deep-(arr.length-1-i);
            res[deep][flag] = carry + p*arr[i];
            carry = 0;
            if(res[deep][flag]>9){
                carry = res[deep][flag]/10;
                res[deep][flag] = res[deep][flag]%10;
            }
        }
        if(carry!=0){
            res[deep][flag-1] = carry;
        }
    }

    public static void main(String[] args) {
        System.out.println(multiply("1234","1234"));
    }
}