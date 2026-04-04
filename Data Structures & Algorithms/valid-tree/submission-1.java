class Solution {
    Map<Integer,List<Integer>> adjlist;
    Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        adjlist = new HashMap<>();//adjacency list preparation
        visited = new HashSet<>();// visited set 

        if(n==0){// if no vertices, such graph is also a valid tree
            return true;
        }
        for(int i=0;i<n;i++){
            adjlist.put(i,new ArrayList<>());
        }

        for(int edge[]:edges){// filling adjacency list here
            adjlist.get(edge[0]).add(edge[1]);
            adjlist.get(edge[1]).add(edge[0]);
        }

        return dfs(0,-1) && visited.size()==n;// now a graph is a valid tree if if starting from 0 no cycles and all vertices are covered and set size is same as vertices given
    }

    private boolean dfs(int node, int parent){
        if(visited.contains(node)){// if already in set cycle exists
            return false;
        }

        visited.add(node);// add to set while moving in dfs
        for(int nei:adjlist.get(node)){
            if(nei==parent){// as graph is undirected, we may come across cases where one node is another adjacency list and parent->child relationship is taken in set so it may return false
                continue;// which is wrong so we need to skip that and continue
            }
            if(!dfs(nei,node)){// apart from parent->child relation this if cycle exists return false
                return false;
            }
        }
        

        return true;// return true if no cycle
    }
}
