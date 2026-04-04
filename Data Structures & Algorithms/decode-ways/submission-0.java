class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        dp[0]=1;// if empty string then no of ways still is 1
        dp[1]=s.charAt(0)=='0'?0:1;// if len is 1 then if first char is not 0 then 1 way to decode

        for(int i=2;i<=n;i++){
            int one_digit = Integer.valueOf(s.substring(i-1,i));// take 1 digit formation
            int two_digit = Integer.valueOf(s.substring(i-2,i));// take 2 digit formation 

            if(one_digit>=1){//add ways for one digit
                dp[i]+=dp[i-1];
            }

            if(two_digit>=10 && two_digit<=26){// if between 10 and 26 then its a valid way, add ways for 2 digit(decision tree possibilities for a particular length only these 2)
                dp[i]+=dp[i-2];
            }
        }

        return dp[n];
        
    }
}
