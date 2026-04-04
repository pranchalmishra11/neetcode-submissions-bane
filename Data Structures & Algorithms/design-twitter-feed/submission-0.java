class Twitter {

    private Map<Integer,Set<Integer>> followMap;
    private Map<Integer,List<int[]>> tweetMap;
    private int count;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        count=0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(tweetMap.containsKey(userId)){
            tweetMap.get(userId).add(new int[]{count++,tweetId});
        }
        else{
            List<int[]> newlist = new ArrayList<>();
            newlist.add(new int[]{count++,tweetId});
            tweetMap.put(userId,newlist);
        }
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        followMap.computeIfAbsent(userId, k-> new HashSet<>()).add(userId);
        for(int follower:followMap.get(userId)){
            if(tweetMap.containsKey(follower)){
                List<int[]> tweets = tweetMap.get(follower);
                int index = tweets.size()-1;
                int tweet[] = tweets.get(index);
                maxHeap.add(new int[]{tweet[0],tweet[1],follower,index});
            }
        }

        while(!maxHeap.isEmpty() && result.size()<10){
            int curr[] = maxHeap.poll();
            result.add(curr[1]);
            int index = curr[3];
        if (index - 1 >= 0) { 
            int[] tweet = tweetMap.get(curr[2]).get(index - 1);
            maxHeap.add(new int[]{tweet[0], tweet[1], curr[2], index - 1});
        }
        }

        return result;

        
    }
    
    public void follow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).add(followeeId);
        }
        else{
            Set<Integer> newSet = new HashSet<>();
            newSet.add(followeeId);
            followMap.put(followerId,newSet);
        }
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            Set<Integer> followers = followMap.get(followerId);
            if(followers.contains(followeeId)){
                followers.remove(followeeId);
            } 
        }
        
    }
}
