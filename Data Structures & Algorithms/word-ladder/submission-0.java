class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){// if target word is not in list itself it cant be reached by BFS
            return 0;
        }

        Map<String,List<String>> adjlist = new HashMap<>();//adjacency list
        Set<String> visited = new HashSet<>();// visited set as graph will be undirected, no need to process visited words/nodes

        wordList.add(beginWord);// add source word to list also for pattern creation help
        for(String word:wordList){
            for(int i=0;i<word.length();i++){
                String pattern = word.substring(0,i)+"*"+word.substring(i+1);// creating patterns by susbtituting * at each character level
                if(adjlist.containsKey(pattern)){
                    adjlist.get(pattern).add(word);
                }else{
                    List<String> newList = new ArrayList<>();
                    newList.add(word);
                    adjlist.put(pattern, newList);
                }
            }
        }

        int ans=1;
        Queue<String> q = new LinkedList<>();//queue is for BFS movement
        q.add(beginWord);// BFS starts from source word, so added to queue initally

        while(!q.isEmpty()){
            int csize = q.size();// layer by layer or neighbour level movement with 1 char difference in words
            for(int i=1;i<=csize;i++){
                String curr = q.poll();
                if(curr.equals(endWord)){// if source and target word match return the count
                    return ans;
                }

                for(int j=0;j<curr.length();j++){
                    String currWordPattern = curr.substring(0,j)+"*"+curr.substring(j+1);// extract patterm from incoming word to get its neigbours and move via queue in BFS
                    for(String nei:adjlist.get(currWordPattern)){
                        if(!visited.contains(nei)){// check if word is already visited as graph is undirected
                            visited.add(nei);
                            q.add(nei);// add to queue and mark visited
                        }

                    }
                }

            }
            ans++;// keep counting layer by layer as discussed
        }

        return 0;

    }
}
