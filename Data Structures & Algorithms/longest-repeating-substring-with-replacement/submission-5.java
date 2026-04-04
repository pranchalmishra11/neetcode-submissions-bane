class Solution {
    public int characterReplacement(String s, int k) {
        int mxlen=0;
        int lw=0;
        int rw=0;

        Map<Character,Integer> map = new HashMap<>();
        int maxf=0;
        while(rw<s.length()){
            char ch = s.charAt(rw);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }

            maxf = Math.max(maxf,map.get(ch));

            while(rw-lw+1-maxf>k){
                map.put(s.charAt(lw),map.get(s.charAt(lw))-1);
                lw++;
            }

            mxlen = Math.max(mxlen,rw-lw+1);
            rw++;
        }

        return mxlen;
    }
}
