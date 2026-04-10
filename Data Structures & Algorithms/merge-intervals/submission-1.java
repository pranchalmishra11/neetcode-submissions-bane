class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int latest[] = ans.get(ans.size()-1);
            int upcoming[] = intervals[i];
            if(latest[1]<upcoming[0]){
                ans.add(upcoming);
            }
            else{
                latest[1]=Math.max(latest[1],upcoming[1]);
            }
        }

        int output[][] = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            output[i]=ans.get(i);
        }

        return output;


    }
}
