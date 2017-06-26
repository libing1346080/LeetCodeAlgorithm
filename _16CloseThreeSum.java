package leetCode;
import java.util.*;
/**
 * Created by libing on 17/6/17.
 */
public class _16CloseThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        if(nums.length < 3) return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i, start, end;
        for(i = 0; i < nums.length - 2; i++){
            start = i + 1;
            end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == target){
                    res = target;
                    return res;
                }else if(sum < target){
                    start++;
                }else{
                    end--;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
