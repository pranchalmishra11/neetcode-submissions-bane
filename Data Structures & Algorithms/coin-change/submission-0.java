class Solution {
    Map<Integer,Integer> cache;
    public int coinChange(int[] coins, int amount) {
        cache = new HashMap<>();//memcache to hold already solutions of overlapped subproblems
        int mincoins = dfs(coins,amount);
        return mincoins==Integer.MAX_VALUE?-1:mincoins; // return -1 if not possible       
    }

    private int dfs(int coins[], int amount){
        if(amount==0){// top-down recursion dp base case
            return 0;
        }

        if(cache.containsKey(amount)){// check in cache if solution already exists for subproblem
            return cache.get(amount);
        }

        int res = Integer.MAX_VALUE;
        for(int coin:coins){// now for all coins dfs/recursive case is executed
            if(amount-coin>=0){// if coin can deduct from amount then proceed with recursion on remaining amount-coin
                int result = dfs(coins,amount-coin);
                if(result!=Integer.MAX_VALUE){
                    res = Math.min(res,1+result);// calculate current minimum, checking against 1+result as 1 here means use of this coin step
                }
            }
        }

        cache.put(amount,res);// put back to cache the solution to this subproblem
        return res;

    }
}
