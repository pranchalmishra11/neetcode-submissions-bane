class PrefixTree {

    private TrieNode node;


    public PrefixTree() {
        node = new TrieNode();        
    }

    public void insert(String word) {
        TrieNode curr = node;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                TrieNode newNode = new TrieNode();
                curr.children[c-'a']=newNode;
            }

            curr = curr.children[c-'a'];
        }

        curr.isEndOfWord = true;

    }

    public boolean search(String word) {
        TrieNode curr = node;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                return false;
            }

            curr = curr.children[c-'a'];
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = node;
        for(char c:prefix.toCharArray()){
            if(curr.children[c-'a']==null){
                return false;
            }

            curr = curr.children[c-'a'];
        }

        return true;

    }
}

public class TrieNode{

    TrieNode children[];
    boolean isEndOfWord;

    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
