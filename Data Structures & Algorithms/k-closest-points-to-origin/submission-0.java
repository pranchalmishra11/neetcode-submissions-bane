class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int ans[][] = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(p -> p.eud));
        int origin[] = {0,0};
        for(int i=0;i<points.length;i++){
            Pair p = new Pair(getEucledianDistance(points[i], origin),points[i][0],points[i][1]);
            pq.add(p);
        }

        int idx=0;
        while(k!=0 && !pq.isEmpty()){
            Pair curr = pq.poll();
            ans[idx][0] = curr.xcod;
            ans[idx][1] = curr.ycod;
            idx++;
            k--;
        }

        return ans;
    }

    private double getEucledianDistance(int first[], int second[]){
        return Math.sqrt(Math.pow(second[0]-first[0],2) + Math.pow(second[1]-first[1],2));

    }


}

class Pair{
    double eud;
    int xcod;
    int ycod;

    public Pair(double eud, int xcod, int ycod){
        this.eud = eud;
        this.xcod = xcod;
        this.ycod = ycod;
    }
}
