class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length() || t.isEmpty()){
            return "";
        }
        Map<Character,Integer> countT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            countT.put(ch,countT.getOrDefault(ch,0)+1);
        }

        int have=0;// global variables which at a time tell us that we have reached a valid window substring
        int need = countT.size();

        int lw = 0;
        int res[] = {-1,-1};// result to gran left, right to pull out final result Substring
        int reslen = Integer.MAX_VALUE;
        for(int rw=0;rw<s.length();rw++){
            char curr = s.charAt(rw);
            window.put(curr,window.getOrDefault(curr,0)+1);
            if(countT.containsKey(curr) && countT.get(curr)==window.get(curr)){
                have++;
            }

            while(have==need){// we are at a valid window for min window till this condition is met we can keep shrinking from left to reach a min length window substring
                if(rw-lw+1<reslen){
                    res[0]=lw;
                    res[1]=rw;
                    reslen = rw-lw+1;
                }
                char leftchar = s.charAt(lw);
                window.put(leftchar,window.getOrDefault(leftchar,0)-1);
                if(countT.containsKey(leftchar) && window.get(leftchar)<countT.get(leftchar)){
                    have--;
                }
                lw++;
            }
        }

        return reslen==Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);
    }
}
