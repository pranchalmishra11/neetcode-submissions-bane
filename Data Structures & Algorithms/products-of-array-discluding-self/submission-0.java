class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int lprefix[] = new int[n];
        int rprefix[] = new int[n];
        lprefix[0]=nums[0];
        rprefix[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            lprefix[i]=nums[i]*lprefix[i-1];
        }

        for(int i=n-2;i>=0;i--){
            rprefix[i] = nums[i]*rprefix[i+1];
        }

        for(int i=0;i<n;i++){
            if(i==0){
                ans[i] = rprefix[i+1];
            }
            else if(i==n-1){
                ans[i] = lprefix[i-1];
            }
            else{
                ans[i] = lprefix[i-1]*rprefix[i+1];
            }
        }

        return ans;
    }
}  
