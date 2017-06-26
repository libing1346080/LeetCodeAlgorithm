package LeetCodeAlgorithm;
/**
 * Created by libing on 17/6/15.
 */
public class _9PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int res = 0;
        while(x > res){
            res = res * 10 + x % 10;
            x  = x / 10;
        }
        return (x == res || x == res / 10);
    }
}
