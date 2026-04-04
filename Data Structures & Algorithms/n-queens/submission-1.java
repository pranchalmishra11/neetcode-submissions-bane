class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> ans = new ArrayList<>();// taking final ans list to fill and give output
       char[][] board = new char[n][n];// board data with n dimensions
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            board[i][j]='.'; // initially filling with the '.'
        }
       }
       backtrack(0,board,ans,n);// backtrack algo starter
       return ans;
       
    }

    private boolean isSafeToPlaceQueen(int row, int col, char board[][], int n){// utility method to check if the row,col is safe to place the queen
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
        if(col==n){// base case if col count reaches n that means one has succesfully placed all the n-queens
            List<String> copy = new ArrayList<>();
            for(char[] row:board){
                copy.add(new String(row));
            }
            ans.add(copy);
            return;
        }

        for(int row=0;row<n;row++){// iterating over all rows, trying to place n-queens over all rows -brute force
            if(isSafeToPlaceQueen(row,col,board,n)){// if only safe then add queen to place
                board[row][col]='Q';
                backtrack(col+1,board,ans,n);// from there try adding other queens placing by recursive call to backtrack
                board[row][col]='.';// the backtrack code while backtracking remove 'Q' and put back '.'
            }
        }
    }
}
