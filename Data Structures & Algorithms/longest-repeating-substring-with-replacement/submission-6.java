class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int maxfreq=0;
        int left=0;
        int right=0;
        int mxwindow=0;

        while(right<s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
            
            maxfreq = Math.max(maxfreq,map.get(ch));
            while(right-left+1-maxfreq>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }

            mxwindow = Math.max(mxwindow,right-left+1);
            right++;

        }

        return mxwindow;
    }
}
