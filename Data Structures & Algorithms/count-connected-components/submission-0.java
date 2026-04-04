class Solution {
    Map<Integer,List<Integer>> adjlist;
    Set<Integer> visited;
    int count=0;
    public int countComponents(int n, int[][] edges) {
        adjlist = new HashMap<>();
        visited = new HashSet<>();

        for(int i=0;i<n;i++){
            adjlist.put(i,new ArrayList<>());
        }

        for(int edge[]:edges){
            adjlist.get(edge[0]).add(edge[1]);
            adjlist.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i,-1);
                count++;
            }                
        }

        return count;
    }

    private void dfs(int node, int parent){
        if(visited.contains(node)){
            return;
        }

        visited.add(node);
        for(int nei:adjlist.get(node)){
            if(nei==parent){
                continue;
            }
            dfs(nei,node);
        }

    }
}
