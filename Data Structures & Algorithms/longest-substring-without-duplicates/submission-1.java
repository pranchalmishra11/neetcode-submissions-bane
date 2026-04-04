class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }
        int lw = 0;
        int rw  = 0;
        int mxlen=0;
        Set<Character> seen = new HashSet<>();
        while(rw<s.length()){
            while(rw<s.length() && !seen.contains(s.charAt(rw))){
                seen.add(s.charAt(rw));
                mxlen = Math.max(mxlen,rw-lw+1);
                rw++;
            }
            seen.remove(s.charAt(lw));
            lw++;
        }

        return mxlen;
           
    }
}
