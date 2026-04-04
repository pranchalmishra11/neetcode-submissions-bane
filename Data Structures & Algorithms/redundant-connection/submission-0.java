class Solution {
    Map<Integer,List<Integer>> adjlist;
    Set<Integer> visited;// visit check duplicacy set for cycle existance check
    Set<Integer> cycleSet;// cycle set to add nodes to it which are part of the cycle
    int cycleStart=-1;// cycle source intialized to -1
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adjlist = new HashMap<>();
        visited = new HashSet<>();
        cycleSet = new HashSet<>();

        for(int i=1;i<=n;i++){
            adjlist.put(i,new ArrayList<>());
        }

        for(int edge[]:edges){// filling of adjacency list
            adjlist.get(edge[0]).add(edge[1]);
            adjlist.get(edge[1]).add(edge[0]);
        }

        dfs(1,-1);// starting dfs from node 1 with parent as -1
        for(int i=edges.length-1;i>=0;i--){// running over edges array from end
            int u = edges[i][0];
            int v = edges[i][1];
            if(cycleSet.contains(u) && cycleSet.contains(v)){// to identify from nodes in cycle correspond to which edge from last
                int ans[] = new int[2];
                ans[0]=u;
                ans[1]=v;
                return ans;// add that edge as answer and return
            }
        }

        return new int[0];// otherwise return empty array
    }

    private boolean dfs(int node, int parent){
        if(visited.contains(node)){// cycle detected, mark cycle source node as cycleStart and return true
            cycleStart = node;
            return true;
        }

        visited.add(node);// keep adding

        for(int nei:adjlist.get(node)){
            if(nei==parent){// undirected graph recursion check and continue
                continue;
            }

            if(dfs(nei,node)){// if true returned means cycle source identified
                if(cycleStart!=-1){// if not -1 so some +ve value while recursion unwinds keep adding to cycleSet
                    cycleSet.add(node);
                }
                if(node==cycleStart){// while unwinding the recursion and adding to set if node reaches back to source, set to -1, no need to add again
                    cycleStart = -1;
                }
                return true;
            }
        }

        return false; // till cycle not coming return false(cycle is assured to come at some node)

    }
}
