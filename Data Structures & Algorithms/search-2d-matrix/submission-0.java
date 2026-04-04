class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int m = matrix.length;
       for(int i=0;i<m;i++){
            if(check(matrix[i],target)!=-1){
                return true;
            }
       }

       return false;
    }

    private int check(int arr[], int target){
        int n = arr.length;
        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(target==arr[mid]){
                return mid;
            }

            else if(target<arr[mid]){
                right = mid-1;
            }

            else{
                left = mid+1;
            }
        }

        return -1;
    }
}
