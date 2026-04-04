class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];// dp initialized with length of s
        dp[s.length()]=true;// dp[s.length] marked as true to start as this is the base case
        
        for(int i = s.length()-1;i>=0;i--){
            for(String w:wordDict){
                if(i+w.length()<=s.length() && s.substring(i,i+w.length()).equals(w)){// same condition check for word break match to any word in wordDict
                    dp[i] = dp[i+w.length()];// this corresponds to recursive case of dfs
                }

                if(dp[i]){// if true assigned to that case it means for that index i we already got a word from wordDict break off the inner loop, no need to go for further strings in wordDict
                    break;
                }
            }

        }

        return dp[0];// return the final problem at 0th index as the solution
        
    }
}
