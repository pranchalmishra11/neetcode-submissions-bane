class Solution {
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        // first phase: DFS-> mark all unsurrounded regions with T

        for(int i=0;i<cols;i++){
            dfs(0,i,board);
            dfs(rows-1,i,board);
        }

        for(int j=0;j<rows;j++){
            dfs(j,0,board);
            dfs(j,cols-1,board);
        } 

        // Second phase: now iterate over whole grid to mark surrounded left over O's as X's

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }


        //Third Phase: now final iteration on whole grid to mark back T's to O's for correctiveness of answer  

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
        
    }

    private void dfs(int r, int c, char board[][]){
        if(r<0 || c<0 || r>=rows || c>=cols || board[r][c]!='O'){
            return;
        }

        

        board[r][c]='T';
        dfs(r+1,c,board);
        dfs(r-1,c,board);
        dfs(r,c+1,board);
        dfs(r,c-1,board);
    }
}
