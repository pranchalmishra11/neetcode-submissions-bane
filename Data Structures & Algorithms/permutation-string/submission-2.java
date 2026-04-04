class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }

        Map<Character,Integer> s1Map = new HashMap<>();
        for(char c:s1.toCharArray()){
            if(s1Map.containsKey(c)){
                s1Map.put(c,s1Map.get(c)+1);
            }else{
                s1Map.put(c,1);
            }
        }

        Map<Character,Integer> perMap = new HashMap<>();
        int winlen = s1.length();
        int start=0;
        int end = winlen-1;
        for(int i=start;i<=end;i++){
            char x = s2.charAt(i);
            if(perMap.containsKey(x)){
                perMap.put(x,perMap.get(x)+1);
            }else{
                perMap.put(x,1);
            }
        }

        while(end<s2.length()){
            if(perMap.equals(s1Map)){
                return true;
            }

            char left = s2.charAt(start);
            if(perMap.containsKey(left)){
                if(perMap.get(left)>1){
                    perMap.put(left,perMap.get(left)-1);
                }else{
                    perMap.remove(left);
                }
            }
            start++;
            end++;
            if(end<s2.length()){
            char nch = s2.charAt(end);
            if(perMap.containsKey(nch)){
                perMap.put(nch,perMap.get(nch)+1);
            }else{
                perMap.put(nch,1);
            }
            }
        }

        return false;


    }
}
