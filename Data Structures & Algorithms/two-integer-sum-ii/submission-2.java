class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ans[] = new int[2];
        int left=0;
        int right=numbers.length-1;

        while(left<=right){
            int curr = numbers[left]+numbers[right];
            if(curr==target){
                ans[0] = left+1;
                ans[1] = right+1;
                break;
            }

            else if(curr>target){
                right--;
            }
            else{
                left++;
            }
        }


        return ans;
        
    }
}
