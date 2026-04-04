class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.isEmpty()){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }

        String result = sb.toString().toLowerCase();
        int n = result.length();
        int left=0;
        int right=n-1;
        while(left<right){
            char lhs = result.charAt(left++);
            char rhs = result.charAt(right--);
            if(lhs!=rhs){
                return false;
            }
        }

        return true;

    }
}
