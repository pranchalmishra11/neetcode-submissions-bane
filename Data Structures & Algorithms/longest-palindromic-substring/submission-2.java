class Solution {
    public String longestPalindrome(String s) {
        int result = 0;
        int resIdx=0;
        int n = s.length();
        String str="";

        for(int i=0;i<n;i++){
            // for odd length strings
                int left=i;// keep left right at same indices
                int right=i;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){// keep moving outwards from the centered string and keep check for palindrome
                if(right-left+1>result){// if the length we got is more than curr result update result and calculate the new string
                    result = right-left+1;
                    resIdx = left;
                }
                left--;
                right++;
            }
            // for even length strings
                left=i;// keeping left and right at different places next tto each other fro movement
                right=i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){// same code as odd length 
                if(right-left+1>result){
                    result = right-left+1;
                    resIdx = left;
                }
                left--;
                right++;
            }
        }

        return s.substring(resIdx,resIdx+result);
    }
}
