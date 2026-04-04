class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int left=0;
        int right=n-1;
        while(left<=right){
            if(nums[left]<nums[right]){// means now binary search has pointed us to the correct side of sorted area to find the min
                res = Math.min(res,nums[left]);
                break;
            }

            int mid = left+(right-left)/2;
            res = Math.min(res,nums[mid]);// current mid can also be a minimum, keep it handy
            if(nums[mid]>=nums[left]){// check for rotated sorted arr, larger values got shifted to left so min can be found on the right only
                left = mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return res;
    }
}
