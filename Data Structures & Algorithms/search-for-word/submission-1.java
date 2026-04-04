class Solution {
     private int rows, cols;
    private Set<Pair<Integer, Integer>> path = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(i,j,word,0,board)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, String word, int index, char board[][]){
        if(index==word.length()){
            return true;
        }

        if(r<0 ||c<0 || r>=rows ||c>=cols || board[r][c]!=word.charAt(index) || path.contains(new Pair<>(r,c))){
            return false;
        }

        path.add(new Pair<>(r,c));
        boolean res = dfs(r+1,c,word,index+1,board) || dfs(r-1,c,word,index+1,board) || dfs(r,c+1,word,index+1,board) || dfs(r,c-1,word,index+1,board);
        path.remove(new Pair<>(r,c));

        return res;



    }
}
