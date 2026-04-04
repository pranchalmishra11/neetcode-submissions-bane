class MedianFinder {

    PriorityQueue<Integer> leftHeap;// max heap
    PriorityQueue<Integer> rightHeap;// min heap

    public MedianFinder() {
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        leftHeap.add(num);// add to maxheap or on leftside to start with
        if(leftHeap.size()-rightHeap.size()>1 || (!rightHeap.isEmpty() && leftHeap.peek()>rightHeap.peek())){
            rightHeap.add(leftHeap.poll());// if left side more members or left side number is greater than right side, then balance it
        }

        if(rightHeap.size()-leftHeap.size()>1){// if right side more members then balance it 
            leftHeap.add(rightHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(leftHeap.size()==rightHeap.size()){// even case
            return (double)(leftHeap.peek()+rightHeap.peek())/2;
        }
        else if(leftHeap.size()>rightHeap.size()){
            return (double)leftHeap.peek();
        }
        else{
            return (double)rightHeap.peek();
        }
        
    }
}
