class TimeMap {
    Map<String,List<Pair>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(timeMap.containsKey(key)){
            List<Pair> curr = timeMap.get(key);
            curr.add(new Pair(timestamp,value));
        }
        else{
            List<Pair> newlist = new ArrayList<>();
            newlist.add(new Pair(timestamp,value));
            timeMap.put(key,newlist);
        }
        
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        if(!timeMap.containsKey(key)){
            return "";
        }
        else{
            int n = timeMap.get(key).size();
            List<Pair> keylist = timeMap.get(key);
            int left=0;
            int right = n-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                if(keylist.get(mid).pk<=timestamp){
                    result = keylist.get(mid).pvalue;
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }

            return result;
        }
        
    }
}

class Pair{
    int pk;
    String pvalue;
    Pair(int pk, String pvalue){
        this.pk=pk;
        this.pvalue = pvalue;
    }

}
