package LeetCodeAlgorithm;

/**
 * Created by libing on 17/7/2.
 * 给定一个整数数组，判断该元素的插入位置
 * @param
 * @return position
 */
public class _35SearchInsertPosition {
    public static void main(String[] args) {
        _35SearchInsertPosition test35 = new _35SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        System.out.print(test35.searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int res = insertCore(nums, 0, nums.length - 1, target);
        return res;
    }

    private int insertCore(int[] nums, int left, int right, int target){
        if(nums == null || left < 0 || right > nums.length) return 0;
        if(left > right) return 0;
        int mid = (left + right)/2;
        if(nums[mid] == target) return mid;
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
