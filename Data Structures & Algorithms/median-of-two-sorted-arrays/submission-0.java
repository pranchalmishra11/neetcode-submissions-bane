class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int A[] = nums1;
        int B[] = nums2;

        if(B.length<A.length){
            int temp[] = A;
            A=B;
            B=temp;
        }

        int total = A.length+B.length;
        int half = (total+1)/2;
        int left = 0;
        int right = A.length;
        while(left<=right){
            int a_mid = left+(right-left)/2;
            int b_mid = half-a_mid;

            int Aleft = a_mid>0?A[a_mid-1]:Integer.MIN_VALUE;
            int Aright = a_mid<A.length?A[a_mid]:Integer.MAX_VALUE;
            int Bleft = b_mid>0?B[b_mid-1]:Integer.MIN_VALUE;
            int Bright = b_mid<B.length?B[b_mid]:Integer.MAX_VALUE;

            // check if valid partition found for median calculation
            if(Aleft<=Bright && Bleft<=Aright){ // do median calculation
                if(total%2!=0)//odd
                {
                    return Math.max(Aleft,Bleft);
                }
                else{//even
                    return (Math.max(Aleft,Bleft)+Math.min(Aright,Bright))/2.0;
                }
            }

            else if(Aleft>Bright){// if partition not found , aleft>Bright so shift right to mid-1 to reduce left side size to get partition condition
                right = a_mid-1;
            }

            else{
                left = a_mid+1;
            }


        }

        return -1;

    }
}
