package LeetCodeAlgorithm;
import java.util.*;
/**
 * Created by libing on 17/6/16.
 */
public class _15ThreeSum {
    public static void main(String[] args) {
        int[] nums = {3, 0, -1, 1, 2, -2};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int left  = i + 1, right = nums.length - 1, sum = 0 - nums[i];
                while(left < right){
                    if(nums[left] + nums[right] == sum){
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        left++; right--;
                    }else if(nums[left] + nums[right] > sum){
                        right--;
                    }else{
                        left++;
                    }
                }

            }
        }
        return res;
    }
}
