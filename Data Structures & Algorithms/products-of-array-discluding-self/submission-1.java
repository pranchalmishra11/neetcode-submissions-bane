class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftprefix[] = new int[nums.length];
        int rightprefix[] = new int[nums.length];
        int output[] = new int[nums.length];

        leftprefix[0]=nums[0];
        rightprefix[nums.length-1]=nums[nums.length-1];

        for(int i=1;i<nums.length;i++){
            leftprefix[i]=nums[i]*leftprefix[i-1];
        }

        for(int i=nums.length-2;i>=0;i--){
            rightprefix[i]=nums[i]*rightprefix[i+1];
        }

        
        for(int i=0;i<nums.length;i++){
            if(i==0){
                output[i]=rightprefix[i+1];
            }

            else if(i==nums.length-1){
                output[i]=leftprefix[i-1];
            }

            else{
                output[i]=leftprefix[i-1]*rightprefix[i+1];
            }
        
        }

        return output;

        
    }
}  
