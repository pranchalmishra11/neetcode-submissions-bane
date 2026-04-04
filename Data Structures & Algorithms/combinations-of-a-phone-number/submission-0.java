class Solution {

    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        backtrack(0,"",digits,ans);
        return ans;
    }

    private void backtrack(int i,String curr, String digits, List<String> ans){
        if(digits.isEmpty()){
            return;
        }

        if(curr.length()==digits.length()){
            ans.add(curr);
            return;
        }
        for(char c:digitToChar[digits.charAt(i)-'0'].toCharArray()){
            backtrack(i+1,curr+c,digits,ans);
        }
    }
}
