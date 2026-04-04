class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen=0;
        int lwd = 0;
        int rwd=0;
        Set<Character> seen = new HashSet<>();
        while(rwd<s.length()){
            while(rwd<s.length() && !seen.contains(s.charAt(rwd))){
                seen.add(s.charAt(rwd));
                maxlen = Math.max(maxlen,rwd-lwd+1);
                rwd++;
            }

            seen.remove(s.charAt(lwd));
            lwd++;
        }

        return maxlen;
    }
}
