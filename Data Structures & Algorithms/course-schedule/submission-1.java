class Solution {
    Set<Integer> visited;
    Map<Integer,List<Integer>> adjlist;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjlist = new HashMap<>();
        visited = new HashSet<>();
        for(int i=0;i<numCourses;i++){
            adjlist.put(i,new ArrayList<>());
        }
        for(int x[]:prerequisites){// adjacency list creation
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
        if(visited.contains(node)){// if current node in set, means repeated so cycle is there
            return false;
        }
        if(adjlist.get(node).isEmpty()){// if the processed node's list is empty so no pre-reqs left on it, so it can finished
            return true;
        }

        visited.add(node);// add to set once visited

        for(int x:adjlist.get(node)){// process current vertex's neighbours
            if(!dfs(x)){// if any of neighbors found with cyclic dependency, return false
                return false;
            }
        }
        
        
        visited.remove(node);// once current node finished while recursion comes back remove from set as its processed
        adjlist.put(node, new ArrayList<>());// also remove its neighbour list by making it empty
        return true;


    }
}
