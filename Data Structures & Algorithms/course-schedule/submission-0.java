class Solution {
    Set<Integer> visited;
    Map<Integer,List<Integer>> adjlist;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjlist = new HashMap<>();
        visited = new HashSet<>();
        for(int i=0;i<numCourses;i++){
            adjlist.put(i,new ArrayList<>());
        }
        for(int x[]:prerequisites){
            adjlist.get(x[0]).add(x[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i)){
                return false;
            }
        }

        return true;   
    }

    private boolean dfs(int node){
        if(visited.contains(node)){
            return false;
        }
        if(adjlist.get(node).isEmpty()){
            return true;
        }

        visited.add(node);

        for(int x:adjlist.get(node)){
            if(!dfs(x)){
                return false;
            }
        }
        
        
        visited.remove(node);
        adjlist.put(node, new ArrayList<>());
        return true;


    }
}
