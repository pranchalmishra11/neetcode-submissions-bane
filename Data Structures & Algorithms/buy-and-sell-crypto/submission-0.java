class Solution {
    public int maxProfit(int[] prices) {
        int curr_min = Integer.MAX_VALUE;
        int mx_profit = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            curr_min = Math.min(curr_min,prices[i]);
            int profit = prices[i]-curr_min;
            if(profit>0){
                mx_profit = Math.max(mx_profit,profit);
            }
        }

        return mx_profit==Integer.MIN_VALUE?0:mx_profit;
        
    }
}
