package com.example.demo.DAO;

import redis.clients.jedis.Jedis;

public class tryredis {

    public void testfunc() {
        Jedis jedis = new Jedis();
        jedis.set("foo","bar");
        String value = jedis.get("foo");
    }

}
