class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Integer> frmap1 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(frmap1.containsKey(curr)){
                frmap1.put(curr,frmap1.get(curr)+1);
            }
            else{
                frmap1.put(curr,1);
            }
        }

        Map<Character,Integer> frmap2 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char curr = t.charAt(i);
            if(frmap2.containsKey(curr)){
                frmap2.put(curr,frmap2.get(curr)+1);
            }
            else{
                frmap2.put(curr,1);
            }
        }

        return frmap1.equals(frmap2);

        



    }
}
