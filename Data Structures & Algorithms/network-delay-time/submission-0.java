class Solution {
    Map<Integer,List<int[]>> adjlist;
    Set<Integer> visited;
    public int networkDelayTime(int[][] times, int n, int k) {
        adjlist = new HashMap<>();// for adjacency list preparation
        visited = new HashSet<>();// checking for already visited
        int time=0;// ans variable for total time delay for signal to reach all nodes
        for(int i=1;i<=n;i++){
            adjlist.put(i,new ArrayList<int[]>());
        }

        for(int i=0;i<times.length;i++){// filling adjacency list with directed edges and time-weight values
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adjlist.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));//min-heap needed to pull out edges with least weight and proceed with it so minimu time taken happens
        pq.add(new int[]{0,k});// BFS starts as signal will go to neighbors first, starts from source node k with 0 weight

        while(!pq.isEmpty()){
            int nodeData[] = pq.poll();// pull out from queue and process it
            int node = nodeData[1];
            int weight = nodeData[0];
            if(visited.contains(node)){// if already visited skip it
                continue;
            }
            visited.add(node);//otherwise add to visited set
            time = Math.max(time,weight);// calculate time taken by signal to reach this node

            for(int nei[]:adjlist.get(node)){// now explore its direct neigbors -BFS starts
                if(!visited.contains(nei[0])){// if that node which is currents neighbor is not visited yet then add it to queue for further processing but with weight being added from parent one as we need to knwo time from source
                    pq.add(new int[]{nei[1]+weight,nei[0]});
                }
            }
        }

        return visited.size()==n?time:-1;// final return if all nodes visited then time calculated, otherwise return -1
    }
}
