class Solution {
    int maxArea = 0;
    int count;
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        boolean visited[][] = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    count=0;
                    dfs(i,j,grid,visited);
                    maxArea = Math.max(maxArea,count);
                }
            }
        }

        return maxArea;
    }

    private void dfs(int i, int j, int grid[][],boolean visited[][]){
        if(i<0 || j<0 || i>=rows || j>=cols || grid[i][j]==0 || visited[i][j]){
            return;
        }

        visited[i][j]=true;
        count++;
        dfs(i+1,j,grid,visited);
        dfs(i-1,j,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i,j-1,grid,visited);
    }
}
