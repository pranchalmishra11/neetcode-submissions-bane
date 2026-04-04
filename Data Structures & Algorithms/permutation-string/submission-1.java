class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }
        if(s1==null || s1.isEmpty()){
            return false;
        }

        if(s2==null || s2.isEmpty()){
            return false;
        }

        Map<Character,Integer> tmap = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            if(tmap.containsKey(ch))
                tmap.put(ch,tmap.get(ch)+1);
            else
                tmap.put(ch,1);
        }

        int sw=0;
        int ew=s1.length()-1;
        Map<Character,Integer> currmap = new HashMap<>();
        for(int i=0;i<=ew;i++){
            char ch = s2.charAt(i);
            if(currmap.containsKey(ch)){
                currmap.put(ch,currmap.get(ch)+1);
            }
            else{
                currmap.put(ch,1);
            }
        }
        while(ew<s2.length()){
            if(currmap.equals(tmap)){
                return true;
            }

            if(currmap.get(s2.charAt(sw))>1){
                currmap.put(s2.charAt(sw),currmap.get(s2.charAt(sw))-1);
            }
            else{
                currmap.remove(s2.charAt(sw));
            }
            sw++;
            ++ew;
            if(ew<s2.length()){
                if(currmap.containsKey(s2.charAt(ew))){
                    currmap.put(s2.charAt(ew),currmap.get(s2.charAt(ew))+1);
                }
                else{
                    currmap.put(s2.charAt(ew),1);
                }
            }   

        }

        return false;
    }
}
