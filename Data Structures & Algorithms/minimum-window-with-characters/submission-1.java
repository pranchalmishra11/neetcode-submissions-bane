class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length() || t.isEmpty()){
            return "";
        }

        Map<Character,Integer> countT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        int left=0;
        int right=0;
        int res[] = {-1,-1};
        int result = Integer.MAX_VALUE;

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            countT.put(ch,countT.getOrDefault(ch,0)+1);
        }

        int have=0;
        int need = countT.size();
        for(right=0;right<s.length();right++){
            char curr = s.charAt(right);
            window.put(curr,window.getOrDefault(curr,0)+1);
            if(countT.containsKey(curr) && countT.get(curr)==window.get(curr)){
                have++;
            }

            while(have==need){
                if(right-left+1<result){
                    res[0]=left;
                    res[1]=right;
                    result = right-left+1;
            }

            char leftside = s.charAt(left);
            window.put(leftside,window.getOrDefault(leftside,0)-1);
            if(countT.containsKey(leftside) && window.get(leftside)<countT.get(leftside)){
                have--;
            }
            left++;       
        }
    }
        return result==Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}



