class Solution {
    private int row;
    private int col;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        boolean visited[][] = new boolean[row][col];
        int count = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    dfs(i,j,grid,visited);
                    count++;
                }
            }
        }

        return count;
        
    }

    private void dfs(int i, int j, char grid[][], boolean visited[][]){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]=='0' || visited[i][j]==true){
            return;
        }

        visited[i][j]=true;
        dfs(i+1,j,grid,visited);
        dfs(i-1,j,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i,j-1,grid,visited);

    }
}
