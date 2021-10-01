package com.example.demo.DAO;
import redis.clients.jedis.Jedis;
import com.example.demo.model.Followlist;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.FollowlistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

public class postDAO {
    @Autowired
    PostRepository P;

    @Autowired
    FollowlistRepository Followlist_R;

    // 这里写逻辑
    //

    public PostRepository getU() {
        return P;
    }

    List<Post> findPostByUid(int uid){
        return P.findPostByUid(uid);
    };

    List<Post> findPostByTime(Date time){
        return P.findPostByTime(time);
    };

    List<Post> converted_post(String content) {
        return null;
    }

    PriorityQueue<Post> Userloginfetch(int uid){
        Date currentdate;
        // Some logic need to filter follows into celebrity && non-celebrity
        List<User> non_celebrity = Followlist_R.findfollowsByUid(uid);
        List<User> celebrity = Followlist_R.findfollowsByUid(uid);
        PriorityQueue<Post> todisplay = new PriorityQueue<>(); // need to add comparator/sorted order to the pq
        for (User nc : non_celebrity) {
            List<Post> small_impact_feeds = P.findPostByUid(nc.getId());
            for (Post feed:small_impact_feeds) {
                todisplay.add(feed);
            }
        }
        Jedis jedis = new Jedis();
        for (User c: celebrity) {
            String celebrity_posts_in_string = jedis.get(""+c.getId());
            List<Post> celebrity_feeds = converted_post(celebrity_posts_in_string);
            for (Post feed: celebrity_feeds) {
                todisplay.add(feed);
            }
        }
        return todisplay;
    }

}
