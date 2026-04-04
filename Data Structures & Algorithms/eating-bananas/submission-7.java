class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mx = Math.max(mx,piles[i]);
        }

        

        int left=1;
        int right=mx;
        int result=mx;
        while(left<=right){
            int mid = left+(right-left)/2;
            long hrs = calchrs(mid,piles);
            if(hrs<=h){
                result = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }

        }

        return result;

    }

    private long calchrs(int k, int piles[]){
        int n =piles.length;
        long count = 0;
        for(int i=0;i<n;i++){
            count = count+(int)(Math.ceil((double)piles[i]/k));
        }

        return count;
    }
}
