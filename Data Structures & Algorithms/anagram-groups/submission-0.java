class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anslist = new ArrayList<>();
        Map<Map<Character,Integer>,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String st = strs[i];
            Map<Character,Integer> exmap = createMap(st);
            if(map.containsKey(exmap)){
                List<String> currlist = map.get(exmap);
                currlist.add(st);
            }else{
                List<String> newlist = new ArrayList<>();
                newlist.add(st);
                map.put(exmap,newlist);
            }
        }

        for(Map.Entry<Map<Character,Integer>,List<String>> entry : map.entrySet()){
            anslist.add(entry.getValue());
        }

        return anslist;

    }

    private Map<Character,Integer> createMap(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
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
