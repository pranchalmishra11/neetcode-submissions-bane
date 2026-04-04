class WordDictionary {

private TrieNode root;

    public WordDictionary() {
        root= new TrieNode();
    }

    public void addWord(String word) {// simple same as insert operation in Tries
        TrieNode curr = root;
        for(char c:word.toCharArray()){// iterate over characters and check if position open to fill, fillby adding new node
            if(curr.children[c-'a']==null){
                TrieNode newNode = new TrieNode();
                curr.children[c-'a']=newNode;
            }

            curr = curr.children[c-'a'];// move pointer to latest created node
        }
        curr.isEndOfWord = true;// mark the end fo word to the last looped node as insert is completed
    }

    public boolean search(String word) {
        return dfs(0,word,root);// dfs required as '.' case makes it such

    }

    private boolean dfs(int index, String word, TrieNode root){
        TrieNode curr = root;// assign root to curr node for pointer iteration
        for(int j=index;j<word.length();j++){
            char c = word.charAt(j);
            if(c=='.'){// if c is . then it ca match with any child nodes of the current node
                for(TrieNode child:curr.children){// so iterate over all child nodes as match path can go from any side so need to brute force this
                    if(child!=null && dfs(j+1,word,child)){// if one of the way takes us to searched word return true
                        return true;
                    }
                }
                return false;// if no such way return false

            }
            else{// case with non-dot, there if any character missed in Trie then return false
                if(curr.children[c-'a']==null){
                    return false;
                }
                
                curr = curr.children[c-'a'];//pointer movement
            }
        }

        return curr.isEndOfWord;// return boolean endofword as for normal case pointer would have reached end and we can check for endofword for searched word

    }
}

public class TrieNode {
    TrieNode children[];
    boolean isEndOfWord;

    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
