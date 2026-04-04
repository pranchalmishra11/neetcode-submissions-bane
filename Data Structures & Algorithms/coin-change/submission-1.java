class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];// use of space table dp
        Arrays.fill(dp,amount+1);// fill this with inital large value of amount greater than 1 atleast
        dp[0]=0;// this points to base case as for amount 0 dp's value is 0
        for(int i=1;i<=amount;i++){// filling it for amount values from 0 to amount
            for(int j=0;j<coins.length;j++){// iterating over all coins for this
                if(i-coins[j]>=0){// if coin value can be deducted from amount then write the solution in dp array
                    dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);// this points to top-down recursive case
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];// if for dp[amount] value doesnt change ans still remains amount+1 then -1 otherwise return updated value
    }
}
