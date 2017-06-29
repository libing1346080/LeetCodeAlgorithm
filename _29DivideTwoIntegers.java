package LeetCodeAlgorithm;

/**
 * Created by libing on 17/6/29.
 */
public class _29DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor){
        if(divisor == 0) return Integer.MAX_VALUE;
        int sign = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) sign = -1;
        long ldividend =  Math.abs((long)dividend);
        long ldivisor =   Math.abs((long)divisor);
        long ans = ldivide(ldividend, ldivisor);
        int res = 0;
        if(ans > Integer.MAX_VALUE){
            if(sign == -1){
                res = Integer.MIN_VALUE;
            }else{
                res = Integer.MAX_VALUE;
            }
        }else{
            res = (int) (ans * sign);
        }
        return res;

    }

    public static long ldivide(long ldividend, long ldivisor){
        if(ldividend < ldivisor ) return 0;
        long sum = ldivisor;
        long ans = 1;
        while((sum + sum) <= ldividend){  //类似二分查找， 查找的更迅速
            sum += sum;
            ans += ans;
        }
        return ans + ldivide((ldividend - sum), ldivisor);
    }
}
