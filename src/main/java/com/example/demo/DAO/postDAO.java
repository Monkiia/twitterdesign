package com.example.demo.DAO;
import com.example.demo.SerializeUtil.SerializeUtil;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import com.example.demo.model.Followlist;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.FollowlistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
@Component
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

    public List<Post> findPostByUid(int uid){
        return P.findPostByUid(uid);
    };

    public List<Post> findPostByTime(Date time){
        return P.findPostByTime(time);
    };


    public int test_write(int uid) {
        int ufollowersize = Followlist_R.findAll().size();
        return ufollowersize;
    }

    public Boolean writePost(int uid, String content, int tid) {
        //System.out.println(Followlist_R.findUidByfollows(uid));
        int ufollowersize = Followlist_R.findUidByfollows(uid).size();
        Post newpost = new Post();
        Date dateoj = new Date();
        newpost.setTime(new java.sql.Date(dateoj.getTime()));
        newpost.setContent(content);
        newpost.setUid(uid);
        newpost.setTid(tid);
        System.out.println("followersize" + ufollowersize);
        if (ufollowersize >= 5) {
            System.out.println("testtest");
            Jedis jedis = new Jedis();
            // 写成一个List
            //jedis.opsforHash().put(HashKey,twiiter.getID(),twittsobject);
            jedis.set("abcd","testtest");
            jedis.set(Integer.toString(uid).getBytes(),SerializeUtil.seralize(newpost));
        }
        P.save(newpost);
        return true;
    }



    public PriorityQueue<Post> get_time_line(int uid){
        Date currentdate;
        // Some logic need to filter follows into celebrity && non-celebrity
        List<Integer> allfollows = Followlist_R.findfollowsByUid(uid);
        Comparator<Post> postcp = new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        };
        PriorityQueue<Post> todisplay = new PriorityQueue<>(postcp);
        Jedis jedis = new Jedis();
        for (int u: allfollows) {
            int ufollowersize = Followlist_R.findUidByfollows(u).size();
            if (ufollowersize >= 5) {
                byte[] postsbyte = jedis.get(Integer.toString(u).getBytes());
                List<Post> posts = (List<Post>) SerializeUtil.unseralize(postsbyte);
                for (Post post : posts) {
                    todisplay.add(post);
                }
            }
            else {
                List<Post> posts = P.findPostByUid(u);
                for (Post post : posts) {
                    todisplay.add(post);
                }
            }
        }
        // need to add comparator/sorted order to the pq
        /*
        for (User nc : non_celebrity) {
            List<Post> small_impact_feeds = P.findPostByUid(nc.getId());
            for (Post feed:small_impact_feeds) {
                todisplay.add(feed);
            }
        }


        for (User c: celebrity) {
            // redis serialize deserialize
            //List<Post> celebrity_posts = jedis.get(""+c.getId());
            /*
            List<Post> celebrity_feeds = converted_post(celebrity_posts_in_string);
            for (Post feed: celebrity_feeds) {
                todisplay.add(feed);
            }
        */
        return todisplay;
    }

}
