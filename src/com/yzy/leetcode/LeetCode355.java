package com.yzy.leetcode;

import java.util.*;

/**
 * Description:
 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：

 postTweet(userId, tweetId): 创建一条新的推文
 getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 follow(followerId, followeeId): 关注一个用户
 unfollow(followerId, followeeId): 取消关注一个用户
 示例:

 Twitter twitter = new Twitter();

 // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 twitter.postTweet(1, 5);

 // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 twitter.getNewsFeed(1);

 // 用户1关注了用户2.
 twitter.follow(1, 2);

 // 用户2发送了一个新推文 (推文id = 6).
 twitter.postTweet(2, 6);

 // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 twitter.getNewsFeed(1);

 // 用户1取消关注了用户2.
 twitter.unfollow(1, 2);

 // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 // 因为用户1已经不再关注用户2.
 twitter.getNewsFeed(1);

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode355 {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
/*
        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);

        // 用户1关注了用户2.
        twitter.follow(1, 2);

        // 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        twitter.getNewsFeed(1);

        // 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        twitter.getNewsFeed(1);*/


        /*["Twitter","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
[[],[1,1],[1],[2,1],[2],[2,1],[2]]*/
        /*twitter.postTweet(1,1);
        twitter.getNewsFeed(1);
        twitter.follow(2,1);
        twitter.getNewsFeed(2);
        twitter.unfollow(2,1);
        twitter.getNewsFeed(2);
*/

        /*["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
[[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1,22],[1,11],[1]]*/
        twitter.postTweet(1,5);
        twitter.postTweet(1,3);
        twitter.postTweet(1,101);
        twitter.postTweet(1,13);
        twitter.postTweet(1,10);
        twitter.postTweet(1,2);
        twitter.postTweet(1,94);
        twitter.postTweet(1,505);
        twitter.postTweet(1,333);
        twitter.postTweet(1,22);
        twitter.postTweet(1,11);
        twitter.getNewsFeed(1);
    }

    static class Twitter {

        static class Msg {
            private int tweetId;
            private int index;

            public Msg(int tweetId, int index) {
                this.tweetId = tweetId;
                this.index = index;
            }
        }

        //保存 用户-推特 信息
        private Map<Integer, List<Msg>> userMsg = new HashMap<>();
        //保存 用户-关注信息
        private Map<Integer, Set<Integer>> follows = new HashMap<>();
        //全局消息索引
        private int index = 0;

        /** Initialize your data structure here. */
        public Twitter() {
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            List<Msg> msgs = this.userMsg.get(userId);
            if (msgs == null) msgs = new ArrayList<>();
            int mIndex = this.index++;
            msgs.add(new Msg(tweetId, mIndex));
            this.userMsg.put(userId, msgs);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> followList = this.follows.get(userId);
            if (followList == null) followList = new HashSet<>();
            followList.add(userId);

            List<Msg> msgList = new ArrayList<>();
            for (int followId : followList) {
                List<Msg> m = this.userMsg.get(followId);
                if (m == null) continue;
                msgList.addAll(m);
            }

            msgList.sort((m1,m2) -> m1.index > m2.index ? -1 : 0);
            List<Integer> list = new ArrayList<>();
            for (Msg msg : msgList) {
                list.add(msg.tweetId);
                if (list.size() == 10) return list;
            }
            return list;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            Set<Integer> followList = this.follows.get(followerId);
            if (followList == null) followList = new HashSet<>();
            followList.add(followeeId);
            this.follows.put(followerId, followList);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followList = this.follows.get(followerId);
            if (followList == null) return;
            followList.remove(followeeId);
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


}
