class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> fmap = new HashMap<>();
        int l=0,r=0;
        int maxf=0;
        int res=0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(fmap.containsKey(ch)){
                fmap.put(ch,fmap.get(ch)+1);
            }
            else{
                fmap.put(ch,1);
            }
            maxf = Math.max(maxf,fmap.get(ch));
            while((r-l+1)-maxf>k){
                fmap.put(s.charAt(l),fmap.get(s.charAt(l))-1);
                l++;
            }

            res = Math.max(res,r-l+1);
            r++;
        }

        return res;

    }
}
