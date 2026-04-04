class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;// get grid size
        boolean visited[][] = new boolean[n][n];// for boolean already visited checks
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));// use of minheap-this problem is a variant of djikshtra- to always choose lesser height while deciding the path, but in a certain path taking existing max as that determines the time
        int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};// directions array used for processing further
        pq.add(new int[]{grid[0][0],0,0});// initialize heap with 0,0 starting point
        visited[0][0]=true;// mark 0,0 as visited already

        while(!pq.isEmpty()){
            int popped[] = pq.poll();// popping from minheap
            int t = popped[0];// acquiring popped data
            int r = popped[1];
            int c = popped[2];

            if(r==n-1 && c==n-1){// base case return check when reached location n-1,n-1
                return t;
            }

            for(int dir[]:directions){// processing 4 sides neighbors
                int neiR = r+dir[0];
                int neiC = c+dir[1];

                if(neiR<0 || neiC<0 || neiR>=n || neiC>=n || visited[neiR][neiC]){// boundary check and if already visited check
                    continue;
                }

                pq.add(new int[]{Math.max(t,grid[neiR][neiC]),neiR,neiC});// if not visited then add to min-heap with crux-: taking max of current grid[r][c] and its parent to maintain the max along the path way
                visited[neiR][neiC]=true;// mark as visited
            }
        }

        return n*n;
        
    }
}
