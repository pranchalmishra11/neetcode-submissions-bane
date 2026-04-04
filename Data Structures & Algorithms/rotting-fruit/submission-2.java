class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0; 
        }

        int minutes=0;
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }


        int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};

        while(fresh>0 && !q.isEmpty()){
            int sz = q.size();
            for(int p=1;p<=sz;p++){
            int node[] = q.poll();
            int i = node[0];
            int j = node[1];
            for(int dir[]:dirs){
                int er = i+dir[0];
                int ec = j+dir[1];
                if(er<0 || ec<0 || er>=rows || ec>=cols || grid[er][ec]==0 || grid[er][ec]==2){
                    continue;
                }

                grid[er][ec]=2;
                q.add(new int[]{er,ec});
                fresh--;
            }
        }
        minutes++;
        }

        return fresh==0?minutes:-1;

  
    }
}
