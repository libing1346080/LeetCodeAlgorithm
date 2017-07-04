package LeetCodeAlgorithm;

/**
 * Created by libing on 17/7/1.
 */
public class _34SearchForARange {
    public static void main(String[] args) {
        _34SearchForARange test34 = new _34SearchForARange();
        int[] nums = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        System.out.println(nums.length);
        int[] res = test34.searchRange(nums, 2);
        for(int ele : res){
            System.out.println(ele);
        }

    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums ==null || nums.length == 0) return res;
        searchCore(nums, 0, nums.length - 1, target, res);
        return res;
    }

    public void  searchCore(int[] nums, int left, int right, int target, int[] res){
        if(left < 0 || right > nums.length - 1) return;
        while (left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                res[0] = mid;
                res[1] = mid;
                if(((mid - 1) >= left && nums[mid - 1] == target)){
                    res[0] = leftSearch(nums, left, mid - 1, target);
                }
                if((mid + 1) <= right && nums[mid +1] == target){
                    res[1] = rightSearch(nums, mid + 1, right, target);
                }
                break;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return;
    }

    public int leftSearch(int[] nums, int left, int right, int target){
        if(left < 0 || right > nums.length - 1 || left > right) return -1;
        int res = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                if (mid - 1 >= left && nums[mid - 1] == target) {
                    res = leftSearch(nums, left, mid - 1, target);
                }else{
                    res = mid;
                }
                break;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }

    public int rightSearch(int[] nums, int left, int right, int target){
        if(left < 0 || right > nums.length - 1 || left > right) return -1;
        int res = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                if (mid +  1 <= right && nums[mid + 1] == target) {
                    res = rightSearch(nums, mid + 1, right, target);
                    break;
                }else{
                    res = mid;
                    break;
                }
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }

}
