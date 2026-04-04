class Solution {
    public boolean exist(char[][] board, String word) {
        Set<Pair<Integer,Integer>> seen = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(backTrackingDfs(0,word,i,j,board,seen)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backTrackingDfs(int index, String word, int r, int c, char board[][], Set<Pair<Integer,Integer>> seen){
        if(index==word.length()){
            return true;
        }

        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]!=word.charAt(index) || seen.contains(new Pair<>(r,c))){
            return false;
        }

        seen.add(new Pair<>(r,c));
        boolean result = backTrackingDfs(index+1,word,r+1,c,board,seen) || backTrackingDfs(index+1,word,r-1,c,board,seen) || backTrackingDfs(index+1,word,r,c+1,board,seen) || backTrackingDfs(index+1,word,r,c-1,board,seen);
        seen.remove(new Pair<>(r,c));
        return result;
    }
}
