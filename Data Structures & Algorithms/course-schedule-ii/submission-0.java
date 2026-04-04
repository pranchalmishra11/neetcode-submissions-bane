class Solution {
    Map<Integer,List<Integer>> adjlist;
    Set<Integer> cycle;
    Set<Integer> visited;
    List<Integer> ans;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int output[] = new int[numCourses];
        ans = new ArrayList<>();
        adjlist = new HashMap<>();// adjacency list using a map
        cycle = new HashSet<>();// set for checking for cycle if so return empty arrray
        visited = new HashSet<>();// set for maintaining processed nodes which are added to output, if such nodes come again from any other edge we dont need to do further recursion just return true as its already added to output

        for(int i=0;i<numCourses;i++){
            adjlist.put(i,new ArrayList<>());
        }

        for(int pre[]:prerequisites){
            adjlist.get(pre[0]).add(pre[1]);// fill adjacency list
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i)){// if any such node return cycle or false from dfs return empty list
                return new int[0];
            }
        }

        for(int j=0;j<ans.size();j++){
            output[j] = ans.get(j);
        }

        return output;
                                      
    }

    private boolean dfs(int node){
        if(cycle.contains(node)){// if cycle set has repeated value, return false
            return false;
        }

        if(visited.contains(node)){// revisiting a processed node return true as it is already there in output
            return true;
        }
        
        cycle.add(node);// add to cycle as dfs flows

        for(int nei:adjlist.get(node)){// dfs on neigbours of current node
            if(!dfs(nei)){// if any of it has cycle return false to previous call
                return false;
            }
        }
        cycle.remove(node);// backtracking path of dfs clear the set
        visited.add(node);// if it hits this area of code it has returned from true so this node is processed and is going to be added to output
        ans.add(node);// added to output and returned true

        return true;


    }
}
