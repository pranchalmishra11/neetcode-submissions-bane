class Solution {

    public String encode(List<String> strs) {
       StringBuilder sb  =  new StringBuilder();
       for(int i=0;i<strs.size();i++){
        String st = strs.get(i);
        sb.append(st.length()).append("#").append(st);
       }

       return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }

            int strlen = Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+strlen;
            ans.add(str.substring(i,j));
            i=j;
            
    }

    return ans;
}
}
