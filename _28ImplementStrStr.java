package LeetCodeAlgorithm;

/**
 * Created by libing on 17/6/26.
 */
public class _28ImplementStrStr {
    public static void main(String[] args) {
        String str = " ";
        System.out.println(str.length());
        System.out.println(strStr(" ", " " ));
    }

    public static int strStr(String haystack, String needle) { //这个题目就是字符串匹配查找的问题
        if(haystack == null || needle == null) return -1;
        if(haystack.length() >= 0 && needle.length() == 0) return 0;
        //if(haystack.length() > 0 && needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        computeNext(needle, next);
        int i = 0, j = 0;  //i代表haystack的下标
        while(i < haystack.length() && j < needle.length()){
            if(j == -1 ||(haystack.charAt(i) == needle.charAt(j))){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == needle.length()){
            return (i - j);
        }else{
            return -1;
        }

    }

    private  static void computeNext(String str, int[] next){ //求KMP的next数组
        next[0] = -1;
        int k = -1;
        int i = 0;  //代表字符串str的下标
        while(i < str.length() - 1){
            if(k == -1 || str.charAt(k) == str.charAt(i)){
                k++;
                i++;
                next[i] = k;
            }else{
                k = next[k];
            }
        }
    }
}
