class Solution {
    int rows;
    int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        for(int i=0;i<cols;i++){// top pacific row and bottom atlantic row
            dfs(0,i,pacific,heights[0][i],heights);
            dfs(rows-1,i,atlantic,heights[rows-1][i],heights);
        }

        for(int j=0;j<rows;j++){// left pacific column and right most atlantic column
            dfs(j,0,pacific,heights[j][0],heights);
            dfs(j,cols-1,atlantic,heights[j][cols-1],heights);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                List<Integer> flow = Arrays.asList(i,j);
                if(pacific.contains(flow) && atlantic.contains(flow)){// if such cell which exists in both pacific and atlantic then it carries water to both seas
                    ans.add(flow);
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, Set<List<Integer>> visited, int prevHeight, int heights[][]){
        if(r<0 || c<0 || r>=rows || c>=cols || prevHeight>heights[r][c] || visited.contains(Arrays.asList(r,c))){// -ve case checks
                return;
        }

        visited.add(Arrays.asList(r,c));
        dfs(r+1,c,visited,heights[r][c],heights);//calling dfs from bordering areas of pacific and atlantic ona ll
        dfs(r-1,c,visited,heights[r][c],heights);// directions to check where can flow go which cells it can flow to
        dfs(r,c+1,visited,heights[r][c],heights);
        dfs(r,c-1,visited,heights[r][c],heights);

    }
}
