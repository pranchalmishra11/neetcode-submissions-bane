class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> ans = new ArrayList<>();
       char[][] board = new char[n][n];
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            board[i][j]='.';
        }
       }
       backtrack(0,board,ans,n);
       return ans;
       
    }

    private boolean isSafeToPlaceQueen(int row, int col, char board[][], int n){
        int dupRow = row;
        int dupCol = col;

        while(row>=0 && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row--;
            col--;
        }

        row=dupRow;
        col=dupCol;

        while(col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            col--;
        }

        row=dupRow;
        col=dupCol;

        while(row<n && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }

            row++;
            col--;
        }

        return true;

    }

    private void backtrack(int col, char board[][], List<List<String>> ans, int n){
        if(col==n){
            List<String> copy = new ArrayList<>();
            for(char[] row:board){
                copy.add(new String(row));
            }
            ans.add(copy);
            return;
        }

        for(int row=0;row<n;row++){
            if(isSafeToPlaceQueen(row,col,board,n)){
                board[row][col]='Q';
                backtrack(col+1,board,ans,n);
                board[row][col]='.';
            }
        }
    }
}
