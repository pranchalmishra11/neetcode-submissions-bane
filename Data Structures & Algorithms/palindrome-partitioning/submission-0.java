class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currPath = new ArrayList<>();
        dfs(s,0,currPath,result);
        return result;        
    }

    private void dfs(String s, int index, List<String> currPath, List<List<String>> result){
        if(index==s.length()){
            result.add(new ArrayList<>(currPath));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(index,i,s)){
                currPath.add(s.substring(index,i+1));
                dfs(s,i+1,currPath,result);
                currPath.remove(currPath.size()-1);
            }
        }
    }

    private boolean isPalindrome(int start, int end, String s){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }

        return true;

    }
}
