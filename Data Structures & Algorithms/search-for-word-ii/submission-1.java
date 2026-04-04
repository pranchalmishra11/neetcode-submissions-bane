class Solution {
    private Set<String> result;// result set to not allow duplicate word creations to go in even if matrix makes such thing
    private boolean[][] visit;// visit array to check in dfs/backtrack if this cell is already visited or not
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word:words){
            root.addWord(word,root);// add all words to prefix-Tree so once dfs does its thing, only 1 pass of it searcheds all words if it exists in prefix Tree
        }

        result = new HashSet<>();
        visit = new boolean[board.length][board[0].length];

        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                backtrack(board,r,c,root,"");// calling dfs/backtrack from all cells but only once, not required to be done for all words as prefix tree has stored those prefixes and in one pass if such pattern is there dfs will find it on prefix tree
            }
        }

        return new ArrayList<>(result);
        
    }

    private void backtrack(char board[][], int r, int c, TrieNode node, String word){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visit[r][c] || node.children[board[r][c]-'a']==null){// negative checks
            return;
        }

        visit[r][c]=true;// add a visted cell/character
        node = node.children[board[r][c]-'a'];// move further in TrieNode/prefix tree
        word+=board[r][c];// keep creating the word
        if(node.isWord){// if word id finally created and exists in prefix tree which also means in our main list of words add to final answer set
            result.add(word);
        }

        backtrack(board,r+1,c,node,word);// call dfs/backtrack in every direction
        backtrack(board,r-1,c,node,word);
        backtrack(board,r,c+1,node,word);
        backtrack(board,r,c-1,node,word);
        visit[r][c]=false;// backtracking line, undo the visted once once backtracking


    }
}

class TrieNode{// Trie/Prefix Tree class 

    TrieNode children[];
    boolean isWord;

    TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }

    private void addWord(String word, TrieNode root){// utility method to add a word to prefix Tree
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }

            curr = curr.children[c-'a'];
        }

        curr.isWord = true;

    }
}
