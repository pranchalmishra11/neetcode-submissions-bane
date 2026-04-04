class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.isEmpty()){
            return true;
        }


        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }

        String changed = sb.toString().toLowerCase();

        int left=0;
        int right=changed.length()-1;
        while(left<=right){
            if(changed.charAt(left++)!=changed.charAt(right--)){
                return false;
            }
        }

        return true;
        
    }
}
