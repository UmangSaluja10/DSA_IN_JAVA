import java.util.*;

public class Twitter {
    // Global counter to establish sequential chronological order for tweets
    private static int timestamp = 0;

    // Track internal tweet metadata
    private static class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    // Maps a user to the set of people they follow
    private Map<Integer, Set<Integer>> followingMap;
    // Maps a user to the head of their linked list of tweets (most recent first)
    private Map<Integer, Tweet> userTweetsMap;

    public Twitter() {
        followingMap = new HashMap<>();
        userTweetsMap = new HashMap<>();
    }

    /** Composes a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // Automatically make a user follow themselves if not already done
        follow(userId, userId);
        
        Tweet newTweet = new Tweet(tweetId, timestamp++);
        // Insert at the head of the user's tweet linked list
        newTweet.next = userTweetsMap.get(userId);
        userTweetsMap.put(userId, newTweet);
    }

    /** Retrieves the 10 most recent tweet IDs in the user's news feed. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> followedUsers = followingMap.get(userId);
        
        if (followedUsers == null || followedUsers.isEmpty()) {
            return feed;
        }

        // Max-heap ordered by tweet timestamp descending
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Initialize the heap with the head tweet of each followed user
        for (int user : followedUsers) {
            Tweet headTweet = userTweetsMap.get(user);
            if (headTweet != null) {
                maxHeap.add(headTweet);
            }
        }

        // Multi-way merge processing up to 10 most recent tweets
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet current = maxHeap.poll();
            feed.add(current.id);
            count++;
            
            // Advance to the next oldest tweet in that specific user's timeline
            if (current.next != null) {
                maxHeap.add(current.next);
            }
        }

        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followingMap.putIfAbsent(followerId, new HashSet<>());
        followingMap.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        // A user cannot unfollow themselves to protect feed logic continuity
        if (followerId == followeeId) return; 
        
        if (followingMap.containsKey(followerId)) {
            followingMap.get(followerId).remove(followeeId);
        }
    }
}
