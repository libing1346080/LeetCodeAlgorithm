package LeetCodeAlgorithm;

/**
 * Created by libing on 17/7/1.
 */
public class _33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        _33SearchInRotatedSortedArray test = new _33SearchInRotatedSortedArray();

        int[] nums = {4, 5, 6, 7, 1, 2, 3};
        int[] nums1 = {1, 3};
        int[] nums2 = {1, 3, 5};
        System.out.print(test.search(nums2, 2));
    }

    public  int search(int[] nums, int target){
        if(nums == null || nums.length == 0) return -1;
        //首先求出分界点
        int pivot = findPivot(nums);
        if(pivot == -1) return -1;
        int res1 = binarySearch(nums, 0, pivot, target);
        int res2 = binarySearch(nums, pivot + 1, nums.length - 1, target);
        if(res1 == -1 && res2 == -1) return -1;
        if(res1 != -1) return res1;
        if(res2 != -1) return res2;
        return -1;
    }

    public int findPivot(int[] nums){ //查找分界点，最大序列的最后一个坐标
        if(nums == null) return -1;
        if(nums.length == 1) return 0;
        int left = 0, right = nums.length - 1, mid = 0;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid] == nums[left]){
                break;
            }else if(nums[mid] > nums[left]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return mid;
    }

        public  int  binarySearch(int[] nums, int left, int right, int target){
        if(nums == null || left > right) return -1;
        int mid = (left + right)/2;
        if(nums[mid] == target){
            return mid;
        }
        int res = -1;
        while(left <= right){
             mid = (left + right)/2;
            if(target == nums[mid]){
                res = mid;
                break;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
//
//    public static int findCore(int[] nums, int left, int right, int target){
//        if(nums == null || left > right) return -1;
//        if(left == right){
//            if(nums[left] == target){
//                return left;
//            }else{
//                return -1;
//            }
//        }
//        int pivot = findPivot(nums);
//        if(target > nums[pivot]){
//            return -1;
//        }else if(target == nums[pivot]){
//            return target;
//        }else{
//            if(target < nums[pivot + 1]){
//                return -1;
//            }else if(target == nums[pivot + 1]){
//                return pivot + 1;
//            }else{
//                if(target == nums[0]){
//                    return 0;
//                }else if(target > nums[0]){
//                    return binarySearch(nums, 0, pivot,target);
//                }else{
//                    return binarySearch(nums, pivot + 1, nums.length - 1, target);
//                }
//            }
//        }
//    }
//

}
