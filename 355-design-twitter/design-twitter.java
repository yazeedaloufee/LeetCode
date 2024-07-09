class Twitter {
    class User {
        Set<User> followee;
        List<int[]> tweets;
        User(){
            followee = new HashSet<>();
            tweets= new ArrayList<>();
        }
    }
    int time;
    HashMap<Integer, User> db;

    public Twitter() {
        db = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userCheck(userId);
        User user = db.get(userId);
        user.tweets.add(new int[]{tweetId, time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        userCheck(userId);

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(User user : db.get(userId).followee) {
            addtopq(pq, 10, user.tweets);
        }
        addtopq(pq, 10, db.get(userId).tweets);
        List<Integer> output = new ArrayList<>();

        while(!pq.isEmpty()) {
            output.add(pq.poll()[0]);
        }
        Collections.reverse(output);
        return output;
    }
    private void addtopq(Queue<int[]> pq, int maxSize, List<int[]> tweets) {
        for(int[] tweet : tweets) {
            pq.add(tweet); 
            if(pq.size() > maxSize){
                pq.poll();
            }
        }
    }
    
    public void follow(int followerId, int followeeId) {
        userCheck(followerId);
        userCheck(followeeId);
    
        User follower = db.get(followerId);
        follower.followee.add(db.get(followeeId));
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = db.get(followerId);
        follower.followee.remove(db.get(followeeId));
    }
    public void userCheck(int userId) {
       if(!db.containsKey(userId)){
            db.put(userId, new User());
        } 
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */