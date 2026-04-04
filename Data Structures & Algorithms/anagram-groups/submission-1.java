class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<Map<Character,Integer>,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String curr = strs[i];
            Map<Character,Integer> ansMap = createFreqMap(curr);
            if(map.containsKey(ansMap)){
                List<String> currlist = map.get(ansMap);
                currlist.add(curr);
            }
            else{
                List<String> newlist= new ArrayList<>();
                newlist.add(curr);
                map.put(ansMap,newlist);
            }
        }

        for(Map.Entry<Map<Character,Integer>,List<String>> set:map.entrySet()){
            ans.add(set.getValue());
        }

        return ans;
    }

    private Map<Character,Integer> createFreqMap(String a){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<a.length();i++){
            char ch = a.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }

        return map;

    }
}
