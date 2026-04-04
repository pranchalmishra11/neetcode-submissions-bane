class Solution {
    int rows;
    int cols;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        rows = grid.length;
        cols = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0){
                    que.add(new int[]{i,j});
                }// a treasure cell , insert to queue for multi source parellel BFS
            }
        }

        if(que.size()==0){
            return;
        }

        int dirs[][] = {{-1,0},{0,1},{0,-1},{1,0}};
        while(!que.isEmpty()){
            int  node[] = que.poll();
            int i = node[0];
            int j = node[1];
            for(int dir[]:dirs){
                int r = i+dir[0];
                int c = j+dir[1];
                if(r<0 || c<0 || r>=rows || c>=cols || grid[r][c]!=Integer.MAX_VALUE){
                    continue;
                }

                que.add(new int[]{r,c});
                grid[r][c] = grid[i][j]+1;
            }
        }
        
    }
}
