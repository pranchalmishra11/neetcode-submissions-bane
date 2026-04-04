class Solution {
    public int countSubstrings(String s) {
        int count=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int left=i;// potential odd length palindromes starters
            int right=i;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }

            left=i;// potential even length palindromes starters
            right=i+1;

            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }

        return count;
        
    }
}
