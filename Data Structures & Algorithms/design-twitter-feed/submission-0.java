class Twitter {
    class Tweet{
        int id;
        int time;
        Tweet next;
        public Tweet(int id, int time){
            this.id=id;
            this.time=time;
        }
    }

    private int time;
    private Map<Integer, Tweet> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        this.time=0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time++);
        tweet.next = tweetMap.get(userId);
        tweetMap.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> b.time-a.time);

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);// includes self as followeee

        for(int followee: followMap.get(userId)){
            Tweet tweet = tweetMap.get(followee);
            if(tweet != null)
                maxHeap.offer(tweet);
        }

        int count=0;
        while(!maxHeap.isEmpty() && count<10){
            Tweet tweet = maxHeap.poll();
            result.add(tweet.id);
            count++;
            if(tweet.next != null){
                maxHeap.offer(tweet.next);
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
