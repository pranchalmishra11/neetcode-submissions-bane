class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<rows;i++){ 
            int colindex=0;
            while(colindex<9){  // scan rows
            char bv = board[i][colindex++];
            if(set.contains(bv)){
                return false;
            }
            else{
                if(bv!='.'){
                    set.add(bv);
                }
            }
        }

        set.clear();
    }


        for(int i=0;i<cols;i++){
            int rowindex=0;
            while(rowindex<9){    // scan colwise
            char bv = board[rowindex++][i];
            if(set.contains(bv)){
                return false;
            }
            else{
                 if(bv!='.'){
                    set.add(bv);
                }
            }
        }
        set.clear();
    }

    int i_start=0;
    int i_end=2;

    while(i_end<9){
        int j_start=0;
        int j_end=2;
        while(j_end<9){
            if(!check(i_start,i_end,j_start,j_end,board,set)){
                return false;
            }
            j_start+=3;
            j_end+=3;
            set.clear();
        }
        i_start+=3;
        i_end+=3;
    }

        return true;   
    }

    private boolean check(int i_st, int i_end, int j_st, int j_end, char board[][], Set<Character> set){
        for(int i=i_st;i<=i_end;i++){
            for(int j=j_st;j<=j_end;j++){
                char bv = board[i][j];
                if(set.contains(bv)){
                    return false;
                }
                else{
                     if(bv!='.'){
                        set.add(bv);
                    }
                }
            }
        }

        return true;

    }
}
