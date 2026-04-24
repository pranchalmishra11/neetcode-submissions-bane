class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int curr[] = intervals[i];
            int latest[] = ans.get(ans.size()-1);

            if(curr[0]>latest[1]){
                ans.add(curr);
            }
            else{
                latest[1] = Math.max(curr[1],latest[1]);
            }
        }

        int output[][] = new int[ans.size()][2];

        for(int i=0;i<ans.size();i++){
            output[i] = ans.get(i);
        }

        return output;
        
    }
}
