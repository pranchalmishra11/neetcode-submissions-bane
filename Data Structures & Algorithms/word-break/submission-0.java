class Solution {
    Map<Integer,Boolean> cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        cache = new HashMap<>();// mem cache for already solved overlapping subproblem
        cache.put(s.length(), true);// value for full length match case put to true
        return dfs(s,wordDict,0);// recursion start from index 0    
    }

    private boolean dfs(String s, List<String> wordDict, int index){
        if(cache.containsKey(index)){// if overlapping problem already evaluated
            return cache.get(index);
        }

        for(String word:wordDict){// iterate over all words given in dictionary and check if it matches with index+ length of word coming from dictionary
            if(index+word.length()<=s.length() && s.substring(index,index+word.length()).equals(word)){// if matches then call dfs on the remaining word and look if remaining part matches with any of the word in dictionary
                if(dfs(s,wordDict,index+word.length())){
                    cache.put(index,true);// for this index if matches put value to true in cache
                    return true;
                }
            }
        }

        cache.put(index,false);// if for ith index dfs gives false or no matches on that word break at i then put false and return false
        return false;


    }
}
