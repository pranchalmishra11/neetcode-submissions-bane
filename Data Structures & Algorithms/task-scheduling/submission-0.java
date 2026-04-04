class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[] = new int[26];// for task in capital case only A to Z
        
        for(char ch:tasks){// frequency is now stored for all the tasks
            count[ch-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();// queue used to track left over tasks and idle time additions management

        for(int x:count){// add all tasks frequency to max heap
            if(x>0)
                pq.add(x);
        }

        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){// keep processing if task exists in either heap or queue
            time++;
            if(pq.isEmpty()){// if nothing left in heap take time from q which was added for future processing
                time = q.peek()[1]; 
            }
            else{
                int value = pq.poll()-1;// else extract from heap and decrease frequency
                if(value>0){// if still task left add to queue with time+wait time for next round
                    q.add(new int[]{value,time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1]==time){ // if the time has come for stored task in queue, release from queue and add in the heap mix
                pq.add(q.poll()[0]);
            }
        }

        return time;



        
    }
}
