package LeetCodeAlgorithm;

/**
 * Created by libing on 17/6/15.
 */
public class _8StringToInteger {
    public static void main(String[] args) {
        String str = "   aab  c   ";
        System.out.println(str.trim());
        System.out.println(myAtoi("2147483648"));
        //测试一下trim的功能， 只能去除首部和尾部的空格
    }
    public static int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0; //第一步判断非空
        int sign = 1, index = 0, res = 0;
        str = str.trim();   //第二部去除空格
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index++) == '+' ? 1 : -1;  //第三步确定符号， 如果没有符号，那么默认是正数

        }
        for(; index < str.length(); index++){
            int digit  = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            int newRes = res * 10 + digit;
            if(res > Integer.MAX_VALUE /10 || (res == Integer.MAX_VALUE /10 && digit > Integer.MAX_VALUE % 10)){
                return  sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; //判断是否溢出
            }else{
                res = res * 10 + digit;
            }
        }
        return res * sign;

    }
}
