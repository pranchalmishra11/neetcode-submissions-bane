class Solution {
    int cache[];
    public int climbStairs(int n) {
        cache = new int[n+1];
        for(int i=0;i<=n;i++){
            cache[i]=-1;
        }

        return dfs(n);

    }

    private int dfs(int i){
        if(i<0){
            return 0;
        }

        if(i==0){
            return 1;
        }

        if(cache[i]!=-1){
            return cache[i];
        }

        cache[i] = dfs(i-1)+dfs(i-2);
        return cache[i];


    }
}
