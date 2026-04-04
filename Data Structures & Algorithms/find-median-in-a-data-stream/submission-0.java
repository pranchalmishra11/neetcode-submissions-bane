class MedianFinder {


    List<Integer> res = new ArrayList<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        res.add(num);
        
    }
    
    public double findMedian() {
        int arr[] = res.stream().mapToInt(Integer::intValue).toArray();
        int len = res.size();
        Arrays.sort(arr);
        if(len%2==0){
            return (arr[(len/2)-1]+arr[(len/2)])/2.0;
        }else{
            return arr[((len+1)/2)-1];
        }
    }
}
