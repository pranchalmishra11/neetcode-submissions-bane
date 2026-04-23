class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<Map<Character,Integer>, List<String>> map = new HashMap<>();

        for(String str:strs){
            Map<Character,Integer> currMap = createFreqMap(str);
            if(map.containsKey(currMap)){
                List<String> temp = map.get(currMap);
                temp.add(str);
            }
            else{
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(currMap,newList);
            }
        }

        for(Map.Entry<Map<Character,Integer>,List<String>> entry:map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
 
    }

    private Map<Character,Integer> createFreqMap(String str){
        Map<Character,Integer> ansMap = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(ansMap.containsKey(c)){
                ansMap.put(c,ansMap.get(c)+1);
            }
            else{
                ansMap.put(c,1);
            }
        }

        return ansMap;

    }
}
