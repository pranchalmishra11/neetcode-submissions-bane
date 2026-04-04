class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes=0;// initialise time
        Queue<int[]> q = new LinkedList<>();// que for BFS
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){// maintaining total fresh oranges count
                    fresh++;
                }
                else if(grid[i][j]==2){// knowing how many crappy oranges, putting them in que as they start rotting next to them
                    q.add(new int[]{i,j});
                }
            }
        }


        int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};// dirs array for four direction bfs checks

        while(fresh>0 && !q.isEmpty()){// till q is empty and still fresh fruit is left
            int sz = q.size();
            for(int p=1;p<=sz;p++){// for bfs layer movement this loop means processing bfs layer by layer
            int node[] = q.poll();
            int i = node[0];
            int j = node[1];
            for(int dir[]:dirs){
                int er = i+dir[0];
                int ec = j+dir[1];
                if(er<0 || ec<0 || er>=rows || ec>=cols || grid[er][ec]==0 || grid[er][ec]==2){// boundary checks and if no fruit and if already rotten
                    continue;
                }

                grid[er][ec]=2;// rotting it here
                q.add(new int[]{er,ec});// add to queue for processing
                fresh--;// decreasing total fresh fruits by 1 as 1 has been turned rotten now
            }
        }
        minutes++;// time count increase after out for loop bfs layer so it means in one time count,the size of que is processed and it has rotten n fruits
        }

        return fresh==0?minutes:-1;// if any fresh alive return -1 otherwise minutes

  
    }
}
