class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer,List<int[]>> adjlist = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        for(int i=0;i<n;i++){// prepareing adjacency list with points vs {dist, toNode}
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j=i+1;j<n;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
                adjlist.computeIfAbsent(i,k->new ArrayList<>()).add(new int[]{dist,j});
                adjlist.computeIfAbsent(j,k->new ArrayList<>()).add(new int[]{dist,i});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));//use of minheap on cost/distance to node
        pq.add(new int[]{0,0});// add starting node to trigger BFS
        int cost = 0;

        while(visited.size()<n){// keep looping and calculating cost until all nodes are visited once
            int popped[] = pq.poll();//pop a node from heap and explore its neighbors
            int currDist = popped[0];
            int currNode = popped[1];
            
            if(visited.contains(currNode)){// if popped node already visited, go for another one
                continue;
            }

            visited.add(currNode);// if not, add to visited
            cost = cost+currDist;// increment cost by taking its weight-> creating an edge

            for(int neiData[]:adjlist.getOrDefault(currNode,Collections.emptyList())){// now go through its neighbors and check in visit set, if not then call BFS by adding them to priority queue
                int neiCost = neiData[0];
                int neiNode = neiData[1];
                if(!visited.contains(neiNode)){
                    pq.add(new int[]{neiCost,neiNode});
                }
            }


        }

        return cost;// return final cost
    }
}
