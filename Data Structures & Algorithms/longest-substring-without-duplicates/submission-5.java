class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }
        int mxwindow=0;
        Set<Character> set = new HashSet<>();
        int sw=0;
        int ew=0;

        while(ew<s.length()){
            while(ew<s.length() && !set.contains(s.charAt(ew))){
                set.add(s.charAt(ew++));
                mxwindow = Math.max(ew-sw,mxwindow);
            }

            set.remove(s.charAt(sw++));
        }

        return mxwindow;
    }
}
