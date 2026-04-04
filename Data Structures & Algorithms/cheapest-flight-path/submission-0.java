class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<Pair>> adjlist = new HashMap<>();// adjacency list with Pair having node, dist data
        for(int i=0;i<n;i++){
            adjlist.put(i,new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){// filling the adjacency list here
            adjlist.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        int dist[] = new int[n];// dist array to store distance to each node in graph from src
        for(int i=0;i<n;i++){// initializing it with 
            dist[i] = (int)1e9;
        }

        Queue<Tuple> q = new LinkedList<>();// only a queue can also work, no need of Priority queue as things depend on stops, and stops are increasing as we keep adding in queue and removal happens from front with least stops
        q.add(new Tuple(0,src,0));// initialize the queue with tuple values with node, src, cost
        
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int stops = t.first;
            int node = t.second;
            int cost = t.third;

            if(stops>k){// if stops exceeded then no need to check for the neighbour
                continue;
            }

            for(Pair p:adjlist.get(node)){// else explore neighbor and apply dijksehtras
                int neiNode = p.first;
                int edgeWeight = p.second;

                if(cost+edgeWeight<dist[neiNode] && stops<=k){// djikshetra and stop conditing check for cost updations
                    dist[neiNode] = cost+edgeWeight;// update cost with which ever is the smaller one
                    q.add(new Tuple(stops+1,neiNode,cost+edgeWeight));// adding with stop + 1 as we are on a hop
                }
            }
        }

        return dist[dst]==1e9?-1:dist[dst];// at the end of queue removals if dist array dst has some non-infinity value then return that otherwise -1


    }
}

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Tuple{
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;

    }
}
