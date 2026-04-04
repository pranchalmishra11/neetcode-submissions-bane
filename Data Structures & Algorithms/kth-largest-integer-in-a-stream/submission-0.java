class KthLargest {

    private PriorityQueue<Integer> pq;// using minheap of size k
    private int kthelement;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        kthelement = k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>kthelement){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
       if(pq.size()==kthelement){
          if(pq.peek()<val){
            pq.poll();
            pq.add(val);
          }
       }
       else{
        pq.add(val);
       }

       return pq.peek();        
    }
}
