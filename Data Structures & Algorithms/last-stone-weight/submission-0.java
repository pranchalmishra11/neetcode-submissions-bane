class Solution {
    public int lastStoneWeight(int[] stones) {
        if(null==stones || stones.length==0){
            return 0;
        }

        if(stones.length==1){
            return stones[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stn:stones){
            pq.add(stn);
        }

        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            int diff = Math.abs(y-x);
            if(diff!=0){
                pq.add(diff);
            }
        }

        return pq.size()==0?0:pq.peek();
        
    }
}
