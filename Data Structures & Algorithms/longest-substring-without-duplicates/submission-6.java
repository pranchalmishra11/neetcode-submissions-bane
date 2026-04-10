class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left=0;
        int right=0;
        int mxwindow=0;

        while(right<s.length()){
            while(right<s.length() && !seen.contains(s.charAt(right))){
                seen.add(s.charAt(right));
                mxwindow = Math.max(mxwindow,right-left+1);
                right++;
            }

            seen.remove(s.charAt(left));
            left++;
        }

        return mxwindow;
        
    }
}
