class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid<=high){// intuition --: divide nums from 0...low-1--> all 0s, low, mid-1--->all 1's and mid..high-1 as unsorted where 0/1/2 anything can come and high...n-1 all 2's 
            if(nums[mid]==0){// condition for unsorted part has 0
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1){ // condition for unsorted part to have 1's 
                mid++;
            }
            else{ //othwerwise if 2 in unsorted swap from high end and reduce high to eat up the unsorted array and make it sorted
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
        
    }
}