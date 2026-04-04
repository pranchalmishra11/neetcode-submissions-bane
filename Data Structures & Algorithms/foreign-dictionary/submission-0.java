class Solution {
    Map<Character,Set<Character>> adjlist;// adjacency list preparation
    Map<Character,Boolean> visited;
    List<Character> result;

    public String foreignDictionary(String[] words) {
        adjlist = new HashMap<>();
        visited = new HashMap<>();
        result = new ArrayList<>();
        for(String word:words){// initially filling with empty hashset for each character
            for(char c:word.toCharArray()){
                if(!adjlist.containsKey(c)){
                    adjlist.put(c,new HashSet<>());
                }
            }
        }

        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(),w2.length());
            if(w1.length()>w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))){
                return "";
            }// check for rule of alien dictionary if length of upcoming word is greater than just previous one and upcoming one is a prefix of new one then invalid rule return ""

            for(int j=0;j<minLen;j++){// otherwise fill adjacency list by checking subsequent letters and catch it on first difference
                if(w1.charAt(j)!=w2.charAt(j)){
                    adjlist.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        for(char c:adjlist.keySet()){// run dfs over all adjacency list members and check as graph can be disconnected too
            if(dfs(c)){// if cycle found then no correct order can be given so empty string
                return "";
            }
        }

        Collections.reverse(result);// post order dfs traversal done so need to reverse list
        StringBuilder sb = new StringBuilder();
        for(char c: result){
            sb.append(c);
        }

        return sb.toString();// final output

    
    }

    private boolean dfs(char ch){
        if(visited.containsKey(ch)){// if the node/character is in visited then return its value, if true-:  processed, false-:not processed yet
            return visited.get(ch);
        }

        visited.put(ch,true);// visiting the node in post order dfs way marking it true- as processed
        for(char nei:adjlist.get(ch)){// traversing in depth till we reach leaf nodes
            if(dfs(nei)){// while traversing if cycle found, means visited has a char which was true already
                return true;// return true to stop dfs further and return empty, as no order can be given now 
            }
        }

        visited.put(ch,false);// after processing if no cycles then mark character in current cycle as false, as we are checking for cycle in curr path
        result.add(ch);// add it to list after all neighbors till leaf nodes processed- post order DFS way
        return false;// false to caller func as cycle not detected in current recursion movement

    }
}
